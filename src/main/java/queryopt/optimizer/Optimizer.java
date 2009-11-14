package queryopt.optimizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import queryopt.entities.Relation;
import queryopt.optimizer.join.Join;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.path.FullTableScan;
import queryopt.optimizer.path.MultipleIndexAccessPath;
import queryopt.optimizer.path.SingleIndexAccessPath;
import queryopt.optimizer.query.SPJQuery;
import queryopt.optimizer.query.SingleRelationQuery;

public class Optimizer {
	private SPJQuery query;
	private List<HashMap<? extends Plan, List<AccessPath>>> plansWithRemainingRelations;
	private HashMap<AccessPath, List<AccessPath>> singleRelationAccessPathsWithRemainingAccessPaths;
	private HashMap<Relation, SingleRelationQuery> singleRelationQueries;

	public Optimizer(SPJQuery query) throws Exception {
		this.query = query;
	}

	public Plan generateBestPlan() throws Exception {
		
		singleRelationQueries = Utils.getSingleRelationQueriesFromSPJQuery(query);
		singleRelationAccessPathsWithRemainingAccessPaths = generateSingleRelationPlans(singleRelationQueries);

		plansWithRemainingRelations = new ArrayList<HashMap<? extends Plan, List<AccessPath>>>();
		plansWithRemainingRelations.add(singleRelationAccessPathsWithRemainingAccessPaths);

		for (int i = 1; i < singleRelationAccessPathsWithRemainingAccessPaths.size(); i++)
			plansWithRemainingRelations.add(generateMultipleRelationPlans(plansWithRemainingRelations.get(i), query));

		Plan bestPlan = null;
		long cost = Long.MAX_VALUE;
		for (Plan allRelationPlan : plansWithRemainingRelations.get(plansWithRemainingRelations.size() - 1).keySet())
			if (allRelationPlan.getCost() < cost) {
				cost = allRelationPlan.getCost();
				bestPlan = allRelationPlan;
			}
		return bestPlan;
	}

	private static HashMap<AccessPath, List<AccessPath>> generateSingleRelationPlans(
			HashMap<Relation, SingleRelationQuery> singleRelationQueries) throws Exception {

		HashMap<AccessPath, List<Relation>> singleRelationAccessPaths = new HashMap<AccessPath, List<Relation>>();

		for (SingleRelationQuery srquery : singleRelationQueries.values()) {
			AccessPath accessPath = null;
			long cost = Long.MAX_VALUE;

			// FTS plan
			FullTableScan fts = new FullTableScan(srquery);
			accessPath = fts;
			cost = fts.getCost();

			// INDEX plans: single and multiple
			if (srquery.getRelation().getIndexes().size() > 0) {
				SingleIndexAccessPath singleIndex = new SingleIndexAccessPath(srquery);
				if (singleIndex.getCost() < cost) {
					cost = singleIndex.getCost();
					accessPath = singleIndex;
				}
				MultipleIndexAccessPath multipleIndex = new MultipleIndexAccessPath(srquery);
				//if (multipleIndex.getCost() < cost) {
					cost = multipleIndex.getCost();
					accessPath = multipleIndex;
				//}
			}
			singleRelationAccessPaths.put(accessPath, new ArrayList<Relation>());
		}

		for (AccessPath accessPath : singleRelationAccessPaths.keySet()) {
			for (Relation relation : singleRelationQueries.keySet())
				if (!relation.equals(accessPath.getInputRelation()))
					singleRelationAccessPaths.get(accessPath).add(relation);
		}
		HashMap<AccessPath, List<AccessPath>> singleRelationAccessPathsWithRemainingAccessPaths = new HashMap<AccessPath, List<AccessPath>>();
		for (AccessPath accessPath : singleRelationAccessPaths.keySet()) {
			singleRelationAccessPathsWithRemainingAccessPaths.put(accessPath, new ArrayList<AccessPath>());
			for (Relation relation : singleRelationAccessPaths.get(accessPath)) {
				for (AccessPath accessPath2 : singleRelationAccessPaths.keySet())
					if (relation.equals(accessPath2.getInputRelation()))
						singleRelationAccessPathsWithRemainingAccessPaths.get(accessPath).add(accessPath2);
			}
		}
		return singleRelationAccessPathsWithRemainingAccessPaths;
	}

	private static HashMap<Join, List<AccessPath>> generateMultipleRelationPlans(
			HashMap<? extends Plan, List<AccessPath>> nMinusOneRelationPlans, SPJQuery query) {
		HashMap<Join, List<AccessPath>> nRelationPlans = new HashMap<Join, List<AccessPath>>();
		for (Plan plan : nMinusOneRelationPlans.keySet()) {
			for (AccessPath accessPath : nMinusOneRelationPlans.get(plan)) {
				Join join = null;
				long cost = Long.MAX_VALUE;

				// NestedLoopsJoin nestedLoops = new NestedLoopsJoin(plan, );
			}
		}
		return nRelationPlans;
	}
}
