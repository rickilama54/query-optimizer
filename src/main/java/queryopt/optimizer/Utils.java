package queryopt.optimizer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.IndexAtribute;
import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;
import queryopt.optimizer.join.Join;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.query.AggregateFunction;
import queryopt.optimizer.query.Clause;
import queryopt.optimizer.query.CompareSingleRowClause;
import queryopt.optimizer.query.JoinClause;
import queryopt.optimizer.query.JoinQuery;
import queryopt.optimizer.query.Literal;
import queryopt.optimizer.query.Operator;
import queryopt.optimizer.query.SPJQuery;
import queryopt.optimizer.query.SingleRelationQuery;
import queryopt.optimizer.query.Term;

/**
 * @author dragan
 * 
 */
public class Utils {

	private static final int SCALE = 10;
	private static final RoundingMode ROUND = RoundingMode.HALF_DOWN;

	public static Relation getOutputRelation(SingleRelationQuery srquery) {
		Relation outputRelation = copy(srquery.getRelation());

		outputRelation.getAtributes().clear();

		outputRelation.getAtributes().addAll(getAllAtributesInSingleRelationQuery(srquery));

		double rowsFactor = 1.0;
		for (Clause clause : srquery.getSelectionCnfClauses())
			rowsFactor *= clause.getSelectivity();

		int rows = (int) (rowsFactor * srquery.getRelation().getNoOfRows());
		outputRelation.setNoOfRows(rows);
		return outputRelation;
	}

	private static Relation copy(Relation r) {
		Relation copy = new Relation();
		copy.setRelationId(r.getRelationId());
		copy.setName(r.getName());
		copy.setBlockingFactor(r.getBlockingFactor());
		copy.setNoOfRows(r.getNoOfRows());
		copy.setSchema(r.getSchema());

		copy.setIndexes(new ArrayList<Index>());
		copy.getIndexes().addAll(r.getIndexes());

		copy.setAtributes(new ArrayList<Atribute>());
		copy.getAtributes().addAll(r.getAtributes());
		return copy;
	}

	private static List<Atribute> getAllAtributesInSingleRelationQuery(SingleRelationQuery srquery) {
		List<Atribute> allAtributesInQuery = new ArrayList<Atribute>();

		allAtributesInQuery.addAll(srquery.getGroupingAtributes());
		allAtributesInQuery.addAll(srquery.getProjectionAtributes());

		for (Clause clause : srquery.getSelectionCnfClauses())
			allAtributesInQuery.addAll(clause.getAtributes());
		for (Clause clause : srquery.getJoinClauses())
			allAtributesInQuery.addAll(clause.getAtributes());

		// Eliminate duplicate Attributes
		HashSet<Atribute> hs = new HashSet<Atribute>(allAtributesInQuery);
		allAtributesInQuery.clear();
		allAtributesInQuery.addAll(hs);

		return allAtributesInQuery;
	}

	/*
	 * Get the output relation from a join operation. Should project out all non
	 * used attributes in the later stages of the query processing. TODO ima
	 * uste rabota
	 */
	public static Relation getOutputRelation(JoinQuery joinquery) throws Exception {

		Relation outputRelation = copy(joinquery.getLeft().getOutputRelation());

		outputRelation.setName(joinquery.getLeft().getOutputRelation().getName() + "_|x|_"
				+ joinquery.getRight().getOutputRelation().getName());

		outputRelation.getAtributes().clear();
		outputRelation.getAtributes().addAll(joinquery.getProjectionAtributes());

		int noOfRows = 0;

		// TODO
		for (JoinClause clause : joinquery.getJoinClauses())
			noOfRows = getNoOfRowsAfterJoin(clause.getAtribute1(), clause.getAtribute2(), joinquery.getLeft()
					.getOutputRelation().getNoOfRows(), joinquery.getRight().getOutputRelation().getNoOfRows(), clause
					.getOperator());

		outputRelation.setNoOfRows(noOfRows);

		return outputRelation;
	}

	public static int getNoOfRowsAfterJoin(Atribute a1, Atribute a2, Operator operator) throws Exception {
		return Utils.getNoOfRowsAfterJoin(a1, a2, a1.getRelation().getNoOfRows(), a2.getRelation().getNoOfRows(),
				operator);
	}

	public static int getNoOfRowsAfterJoin(Atribute a1, Atribute a2, int a1rows, int a2rows, Operator operator)
			throws Exception {
		BigDecimal a1Low = getHashValue(a1.getLowValue());
		BigDecimal a1High = getHashValue(a1.getHighValue());
		BigDecimal a2Low = getHashValue(a2.getLowValue());
		BigDecimal a2High = getHashValue(a2.getHighValue());

		BigDecimal a1Rows = new BigDecimal(a1rows);
		BigDecimal a2Rows = new BigDecimal(a2rows);

		BigDecimal lowIntersection = a1Low;
		if (a2Low.compareTo(a1Low) > 0)
			lowIntersection = a2Low;

		BigDecimal highIntersection = a1High;
		if (a2High.compareTo(a1High) < 0)
			highIntersection = a2High;

		// No intersection between [a1Low, a1High] and [a2Low, a2High]
		if (operator == Operator.EQ && highIntersection.compareTo(lowIntersection) <= 0)
			return 0;

		BigDecimal a1PercentInIntersection = highIntersection.subtract(lowIntersection).divide(a1High.subtract(a1Low),
				SCALE, ROUND);
		BigDecimal a2PercentInIntersection = highIntersection.subtract(lowIntersection).divide(a2High.subtract(a2Low),
				SCALE, ROUND);

		BigDecimal a1RowsInIntersection = a1PercentInIntersection.multiply(a1Rows);
		BigDecimal a2RowsInIntersection = a2PercentInIntersection.multiply(a2Rows);
		if (operator == Operator.EQ)
			return a1RowsInIntersection.multiply(a2Rows.divide(new BigDecimal(getDistinctValues(a2)))).intValue();

		if (operator == Operator.GT || operator == Operator.GT_EQ || operator == Operator.LS
				|| operator == Operator.LS_EQ) {
			BigDecimal rows = new BigDecimal(0);
			// Interval Rows
			for (int i = 1; i <= a1RowsInIntersection.intValue(); i++) {
				int n = a2RowsInIntersection.subtract(
						new BigDecimal(i).multiply(a2RowsInIntersection.divide(a1RowsInIntersection, SCALE, ROUND)))
						.intValue();
				if (operator == Operator.GT_EQ || operator == Operator.LS_EQ)
					n += 1;
				rows = rows.add(new BigDecimal(n));
			}
			if (operator == Operator.GT || operator == Operator.GT_EQ) {
				// Tuples greater than highIntersection
				if (a1High.compareTo(highIntersection) > 0) {
					BigDecimal a1ValuesGtThanInterval = a1High.subtract(highIntersection).divide(
							a1High.subtract(a1Low), SCALE, ROUND).multiply(a1Rows);
					rows = rows.add(a1ValuesGtThanInterval.multiply(a2RowsInIntersection));
				}
				// Tuples greater than a2High
				if (a1Low.compareTo(a2High) >= 0) {
					rows = rows.add(a1Rows.multiply(a2Rows));
				}
			}

			if (operator == Operator.LS || operator == Operator.LS_EQ) {
				// Tuples less than lowIntersection
				if (a1Low.compareTo(lowIntersection) < 0) {
					BigDecimal a1ValuesLsThanInterval = lowIntersection.subtract(a1Low).divide(a1High.subtract(a1Low),
							SCALE, ROUND).multiply(a1Rows);
					rows = rows.add(a1ValuesLsThanInterval.multiply(a2RowsInIntersection));
				}
				// Tuples less than a2Low
				if (a1High.compareTo(a2Low) <= 0) {
					rows = rows.add(a1Rows.multiply(a2Rows));
				}
			}
			return rows.intValue();
		}

		if (operator == Operator.DIFF) {
			BigDecimal rows = new BigDecimal(0);
			// Tuples greater than highIntersection
			if (a1High.compareTo(highIntersection) > 0) {
				BigDecimal a1ValuesGtThanInterval = a1High.subtract(highIntersection).divide(a1High.subtract(a1Low),
						SCALE, ROUND).multiply(a1Rows);
				rows.add(a1ValuesGtThanInterval.multiply(a2RowsInIntersection));
			}
			// Tuples less than lowIntersection
			if (lowIntersection.compareTo(a1Low) > 0) {
				BigDecimal a1ValuesLsThanInterval = lowIntersection.subtract(a1Low).divide(a1High.subtract(a1Low),
						SCALE, ROUND).multiply(a1Rows);
				rows.add(a1ValuesLsThanInterval.multiply(a2RowsInIntersection));
			}
			return rows.intValue();
		}

		throw new Exception("Should not be here");
	}

	private static int getDistinctValues(Atribute a) {
		if (a.getDistinctPercent() == 0)
			return 1;
		return (int) (0.01 * a.getDistinctPercent() * (double) a.getRelation().getNoOfRows());
	}

	public static boolean isIndexOnlyScanPossible(Collection<Index> indexes, SingleRelationQuery srquery) {
		List<Atribute> atributes = Utils.getAllAtributesInSingleRelationQuery(srquery);
		List<Atribute> atributesInIndexes = new ArrayList<Atribute>();
		for (Index index : indexes)
			atributesInIndexes.addAll(index.getAtributes());
		return atributesInIndexes.containsAll(atributes);
	}

	public static HashMap<Index, List<Atribute>> getMatchingIndexes(List<Index> indexes, SingleRelationQuery srquery) {
		HashMap<Index, List<Atribute>> matchingIndexes = new HashMap<Index, List<Atribute>>();
		List<Atribute> atributes = Utils.getAllAtributesInSingleRelationQuery(srquery);

		for (Index index : indexes) {
			boolean found = false;
			int atributeIndex = 0;
			List<Atribute> indexAtributes = index.getAtributes();
			do {
				found = false;
				for (Atribute atribute : atributes)
					if (indexAtributes.get(atributeIndex).equals(atribute)) {
						found = true;
						atributeIndex++;
						if (!matchingIndexes.containsKey(index))
							matchingIndexes.put(index, new ArrayList<Atribute>());
						matchingIndexes.get(index).add(atribute);
						break;
					}
			} while (found);
		}
		return matchingIndexes;
	}

	public static HashMap<Index, List<Atribute>> getMinimalSetOfIndexesForAtributes(List<Atribute> atributes,
			List<Index> candidateIndexes) {
		HashMap<Index, List<Atribute>> indexes = new HashMap<Index, List<Atribute>>();

		for (Index index : candidateIndexes) {
			List<Atribute> indexAtributes = index.getAtributes();
			for (Atribute atribute : indexAtributes)
				if (atributes.contains(atribute)) {
					if (!indexes.containsKey(index))
						indexes.put(index, new ArrayList<Atribute>());
					indexes.get(index).add(atribute);
				}
		}

		// Find and remove redundant indexes
		List<Index> redundantIndexes = new ArrayList<Index>();
		for (Index index1 : indexes.keySet())
			for (Index index2 : indexes.keySet())
				if (!redundantIndexes.contains(index1))
					if (!index2.equals(index1) && indexes.get(index1).containsAll(indexes.get(index2)))
						redundantIndexes.add(index2);
		for (Index index : redundantIndexes)
			indexes.remove(index);
		//

		return indexes;
	}

	// Treba i nesto kako project out atributes after Join
	public static HashMap<Index, HashMap<Clause, Atribute>> getMatchingSelectionIndexes(SingleRelationQuery srquery,
			List<Index> indexes) throws Exception {

		HashMap<Clause, Atribute> clausesAtributes = new HashMap<Clause, Atribute>();
		for (Clause clause : srquery.getSelectionCnfClauses()) {
			if (clause instanceof CompareSingleRowClause) {
				CompareSingleRowClause csrclause = (CompareSingleRowClause) clause;
				Atribute atribute = null;
				if (csrclause.getOperand1() instanceof Literal && csrclause.getOperand2() instanceof Atribute)
					atribute = (Atribute) csrclause.getOperand2();
				else if (csrclause.getOperand1() instanceof Atribute && csrclause.getOperand2() instanceof Literal)
					atribute = (Atribute) csrclause.getOperand1();
				clausesAtributes.put(clause, atribute);
			} else
				throw new Exception("Not implemented yet");
		}

		HashMap<Index, HashMap<Clause, Atribute>> matchingSelectionIndexes = new HashMap<Index, HashMap<Clause, Atribute>>();
		for (Index index : indexes) {
			boolean found;
			int atributeIndex = 0;
			List<Atribute> indexAtributes = index.getAtributes();
			do {
				found = false;
				for (Clause clause : clausesAtributes.keySet())
					if (indexAtributes.get(atributeIndex).equals(clausesAtributes.get(clause))) {
						found = true;
						atributeIndex++;
						if (!matchingSelectionIndexes.containsKey(index))
							matchingSelectionIndexes.put(index, new HashMap<Clause, Atribute>());
						matchingSelectionIndexes.get(index).put(clause, clausesAtributes.get(clause));
						break;
					}
			} while (found && atributeIndex < indexAtributes.size());
		}

		return matchingSelectionIndexes;
	}

	public static boolean isPkIndex(Index index) {
		for (Atribute a : index.getRelation().getAtributes()) {
			if (!a.isPk())
				continue;
			boolean found = false;
			for (IndexAtribute ia : index.getIndexAtributes())
				if (ia.getAtribute().equals(a)) {
					found = true;
					break;
				}
			if (!found)
				return false;
		}
		return true;
	}

	public static int getRowSizeInBytes(Relation r) {
		int rowSizeInBytes = 0;
		for (Atribute a : r.getAtributes())
			rowSizeInBytes += a.getSizeInBytes();
		return rowSizeInBytes;
	}

	public static long getRelationSizeInPages(Relation r, SystemInfo systemInfo) {
		int pagesize = systemInfo.getPageSizeInBytes();
		// System.out.println("pagesize:" + pagesize);
		// System.out.println("getRelationSizeInBytes(r, systemInfo):" +
		// getRelationSizeInBytes(r, systemInfo));
		return getRelationSizeInBytes(r, systemInfo) / pagesize;
	}

	public static long getRelationSizeInBytes(Relation r, SystemInfo systemInfo) {
		long rowsize = Utils.getRowSizeInBytes(r);
		int rows = r.getNoOfRows();
		double blockingFactor = 1.0 / (double) r.getBlockingFactor();
		return (long) (rowsize * rows * blockingFactor);
	}

	public static long getNoOfFirstLevelIndexPages(Index index, SystemInfo systemInfo) {
		int rows = index.getRelation().getNoOfRows();
		int blockingFactor = systemInfo.getBlockingFactorIndexFirstLevelRows();
		int ridSize = systemInfo.getRidSizeInBytes();
		long atributesSize = 0;
		for (Atribute atribute : index.getAtributes())
			atributesSize += atribute.getSizeInBytes();
		int pageSize = systemInfo.getPageSizeInBytes();
		long leafSize = ridSize + atributesSize;
		return (long) Math.ceil(rows * blockingFactor * leafSize / pageSize);
	}

	public static boolean areAllAtributesInIndex(Index index, SingleRelationQuery srquery) {
		List<Atribute> allAtributesInQuery = getAllAtributesInSingleRelationQuery(srquery);

		for (Atribute a : allAtributesInQuery) {
			boolean found = false;
			for (IndexAtribute ia : index.getIndexAtributes())
				if (ia.getAtribute().equals(a))
					found = true;
			if (!found)
				return false;
		}

		return true;
	}

	public static boolean areAllAtributesInIndexAndSelectionClauseIsPrefix(Index index, SingleRelationQuery srquery) {
		List<Atribute> allAtributesInQuery = getAllAtributesInSingleRelationQuery(srquery);

		List<Atribute> selectionClause = new ArrayList<Atribute>();
		for (Clause clause : srquery.getSelectionCnfClauses())
			selectionClause.addAll(clause.getAtributes());

		if (!index.getAtributes().containsAll(allAtributesInQuery))
			return false;

		// We should secure that the index contains all the selection (WHERE)
		// attributes in a prefix on its list of attributes
		boolean notContainPrevious = false;
		for (IndexAtribute ia : index.getIndexAtributes())
			if (selectionClause.contains(ia.getAtribute())) {
				if (notContainPrevious == true)
					return false;
			} else
				notContainPrevious = true;

		return true;
	}

	public static HashMap<Relation, SingleRelationQuery> getSingleRelationQueriesFromSPJQuery(SPJQuery query)
			throws Exception {
		HashMap<Relation, SingleRelationQuery> srqueries = new HashMap<Relation, SingleRelationQuery>();

		// Fill Projection and Grouping Terms
		for (Term term : query.getProjectionTerms())
			resolveTerm(term, srqueries, query.getSystemInfo());
		for (Atribute atribute : query.getGroupingAtributes())
			resolveTerm(atribute, srqueries, query.getSystemInfo());

		// Fill Selection Clauses
		for (Clause clause : query.getSelectionCnfClauses())
			for (Atribute a : clause.getAtributes()) {
				if (!srqueries.containsKey(a.getRelation()))
					srqueries.put(a.getRelation(), new SingleRelationQuery(query.getSystemInfo(), a.getRelation()));
				srqueries.get(a.getRelation()).getSelectionCnfClauses().add(clause);
			}

		// Fill Join Clauses
		for (JoinClause clause : query.getJoinClauses())
			for (Atribute a : clause.getAtributes()) {
				if (!srqueries.containsKey(a.getRelation()))
					srqueries.put(a.getRelation(), new SingleRelationQuery(query.getSystemInfo(), a.getRelation()));
				srqueries.get(a.getRelation()).getJoinClauses().add(clause);
				resolveTerm(a, srqueries, query.getSystemInfo());
			}
		return srqueries;
	}

	private static void resolveTerm(Term term, HashMap<Relation, SingleRelationQuery> srqueries, SystemInfo systemInfo)
			throws Exception {
		Atribute atribute = null;
		if (term instanceof Atribute)
			atribute = (Atribute) term;
		else if (term instanceof AggregateFunction)
			atribute = ((AggregateFunction) term).getAtribute();
		else
			throw new Exception("Should not be here");

		if (!srqueries.containsKey(atribute.getRelation()))
			srqueries.put(atribute.getRelation(), new SingleRelationQuery(systemInfo, atribute.getRelation()));

		List<Atribute> projectionAtributes = srqueries.get(atribute.getRelation()).getProjectionAtributes();

		if (!projectionAtributes.contains(atribute))
			projectionAtributes.add(atribute);
	}

	public static List<JoinQuery> getJoinQueriesFromSPJQuery(List<? extends Plan> leftdeepPlansMinusOne,
			SPJQuery query, List<AccessPath> allAccessPaths) throws Exception {

		List<JoinQuery> joinQueries = new ArrayList<JoinQuery>();

		for (Plan plan : leftdeepPlansMinusOne)
			for (AccessPath accessPath : Utils.getRemainingAccessPaths(plan, allAccessPaths)) {
				JoinQuery joinQuery = Utils.computeJoinQuery(query, plan, accessPath);
				if (joinQuery != null)
					joinQueries.add(joinQuery);
			}
		for (JoinQuery jq : joinQueries) {
			System.out.println("jq:" + jq.getRight().getOutputRelation().getName() + " "
					+ jq.getLeft().getOutputRelation().getName());
		}
		return joinQueries;
	}

	private static JoinQuery computeJoinQuery(SPJQuery query, Plan plan, AccessPath accessPath) throws Exception {
		List<JoinClause> remainingJoinClauses = new ArrayList<JoinClause>();
		remainingJoinClauses.addAll(query.getJoinClauses());
		Plan join = plan;
		while (join instanceof Join) {
			remainingJoinClauses.removeAll(((Join) join).getJoinQuery().getJoinClauses());
			join = ((Join) join).getLeft();
		}
		List<JoinClause> joinClauses = new ArrayList<JoinClause>();
		for (JoinClause joinClause : remainingJoinClauses)
			if (accessPath.getOutputRelation().getAtributes().contains(joinClause.getAtribute1()))
				if (!plan.getOutputRelation().getAtributes().contains(joinClause.getAtribute2())) {
					// System.out.println("plan.getOutputRelation().getName():"+plan.getOutputRelation().getName());
					// System.out.println(plan.getOutputRelation().getAtributes());
					// System.out.println(joinClause.getAtribute1().getName() +
					// " " + joinClause.getAtribute2().getName());
					// throw new Exception("Invalid state");
					//return null;
				} else
					joinClauses.add(joinClause);
			else if (accessPath.getOutputRelation().getAtributes().contains(joinClause.getAtribute2()))
				if (!plan.getOutputRelation().getAtributes().contains(joinClause.getAtribute1())) {
					// throw new Exception("Invalid state");
					//return null;
				} else
					joinClauses.add(joinClause);
			else
				throw new Exception("Invalid state");

		// No join Clauses found i.e. Plan and AccessPath are not join-able
		if (joinClauses.size() == 0)
			return null;

		// TODO project out not needed attributes
		List<Atribute> projectionAtributes = new ArrayList<Atribute>();
		projectionAtributes.addAll(plan.getOutputRelation().getAtributes());
		projectionAtributes.addAll(accessPath.getOutputRelation().getAtributes());

		for(Atribute a1 : plan.getOutputRelation().getAtributes())
			for(Atribute a2 : accessPath.getOutputRelation().getAtributes())
				if(a1.getFkAtribute() != null)
				if(a1.getFkAtribute().equals(a2))
					return new JoinQuery(query.getSystemInfo(), plan, accessPath, projectionAtributes, joinClauses);
		
		for(Atribute a1 : accessPath.getOutputRelation().getAtributes())
			for(Atribute a2 : plan.getOutputRelation().getAtributes())
				if(a1.getFkAtribute() != null)
				if(a1.getFkAtribute().equals(a2))
					return new JoinQuery(query.getSystemInfo(), plan, accessPath, projectionAtributes, joinClauses);
		
		return null;
	}

	private static List<AccessPath> getRemainingAccessPaths(Plan plan, List<AccessPath> allAccessPaths) {

		if (plan instanceof AccessPath) {
			List<AccessPath> remainingAccessPaths = new ArrayList<AccessPath>();
			remainingAccessPaths.addAll(allAccessPaths);
			remainingAccessPaths.remove((AccessPath) plan);
			return remainingAccessPaths;
		}

		if (plan instanceof Join) {
			List<AccessPath> remainingAccessPaths = new ArrayList<AccessPath>();
			remainingAccessPaths.addAll(allAccessPaths);

			Plan leftPlan = plan;
			while (leftPlan instanceof Join) {
				remainingAccessPaths.remove(((Join) leftPlan).getRight());
				leftPlan = ((Join) leftPlan).getLeft();
			}
			remainingAccessPaths.remove((AccessPath) leftPlan);
			return remainingAccessPaths;
		}

		return null;
	}

	public static double compare(String s1, String s2, String low, String high) {
		return normalize(s1, low, high).subtract(normalize(s2, low, high)).doubleValue();
	}

	/**
	 * @param str
	 * @param low
	 * @param high
	 * @return str / (high - low) is in [0.0, 1.0]
	 */
	public static BigDecimal normalize(String str, String low, String high) {
		return getHashValue(str).subtract(getHashValue(low)).divide(getHashValue(high).subtract(getHashValue(low)),
				SCALE, ROUND);
	}

	public static BigDecimal getHashValue(String str) {
		BigDecimal hash = new BigDecimal(0.0);
		int power = str.length();
		for (char c : str.toCharArray())
			hash = hash.add(new BigDecimal((int) c).pow(power--));
		return hash;
	}

	public static String getOperatorString(Operator operator) {
		String str = null;
		switch (operator) {
		case EQ:
			str = "=";
			break;
		case DIFF:
			str = "<>";
			break;
		case GT_EQ:
			str = ">=";
			break;
		case LS_EQ:
			str = "<=";
			break;
		case GT:
			str = ">";
			break;
		case LS:
			str = "<";
			break;
		}
		return str;
	}
}
