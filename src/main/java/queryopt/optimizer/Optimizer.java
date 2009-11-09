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
	private List<HashMap<? extends Plan, List<Relation>>> plansWithRemainingRelations;
	HashMap<AccessPath, List<Relation>> singleRelationAccessPaths;
	HashMap<Relation, SingleRelationQuery> singleRelationQueries;

	public Optimizer(SPJQuery query) throws Exception {
		this.query = query;
	}

	public void generateBestPlan() throws Exception {
		singleRelationAccessPaths = generateSingleRelationPlans(singleRelationQueries);

		singleRelationQueries = Utils.getSingleRelationQueriesFromSPJQuery(query);

		plansWithRemainingRelations.add(singleRelationAccessPaths);

		for (int i = 1; i < singleRelationAccessPaths.size(); i++)
			plansWithRemainingRelations.add(generateMultipleRelationPlans(plansWithRemainingRelations.get(i), query));

	}

	private static HashMap<AccessPath, List<Relation>> generateSingleRelationPlans(
			HashMap<Relation, SingleRelationQuery> singleRelationQueries) throws Exception {

		HashMap<AccessPath, List<Relation>> singleRelationAccessPaths = new HashMap<AccessPath, List<Relation>>();

		for (SingleRelationQuery srquery : singleRelationQueries.values()) {
			AccessPath accessPath = null;
			long cost = 0;

			// FTS plan
			FullTableScan fts = new FullTableScan(srquery);
			accessPath = fts;
			cost = fts.getCost();

			// INDEX plans: single and multiple
			if (srquery.getRelation().getIndexes().size() > 0) {
				SingleIndexAccessPath singleIndex = new SingleIndexAccessPath(srquery);
				if (singleIndex.getCost() > cost) {
					cost = singleIndex.getCost();
					accessPath = singleIndex;
				}
				MultipleIndexAccessPath multipleIndex = new MultipleIndexAccessPath(srquery);
				if (multipleIndex.getCost() > cost) {
					cost = multipleIndex.getCost();
					accessPath = multipleIndex;
				}
			}
			singleRelationAccessPaths.put(accessPath, new ArrayList<Relation>());
		}

		for (AccessPath accessPath : singleRelationAccessPaths.keySet()) {
			SingleRelationQuery srquery = singleRelationQueries.get(accessPath.getInputRelation());
			singleRelationQueries.remove(accessPath.getInputRelation());
			singleRelationAccessPaths.get(accessPath).addAll(singleRelationQueries.keySet());
			singleRelationQueries.put(accessPath.getInputRelation(), srquery);
		}

		return singleRelationAccessPaths;
	}

	private static HashMap<Join, List<Relation>> generateMultipleRelationPlans(
			HashMap<? extends Plan, List<Relation>> nMinusOneRelationPlans, SPJQuery query) {
		HashMap<Join, List<Relation>> nRelationPlans = new HashMap<Join, List<Relation>>();
		for (Plan plan : nMinusOneRelationPlans.keySet()) {

		}
		return nRelationPlans;
	}
}
