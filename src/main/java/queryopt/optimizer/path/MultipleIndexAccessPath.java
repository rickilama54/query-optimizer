package queryopt.optimizer.path;

import java.util.HashMap;
import java.util.List;

import queryopt.entities.Index;
import queryopt.optimizer.Utils;
import queryopt.optimizer.entities.Clause;
import queryopt.optimizer.entities.SingleRelationQuery;

public class MultipleIndexAccessPath extends AccessPath {

	public MultipleIndexAccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	@Override
	protected long calcCost(SingleRelationQuery srquery) throws Exception {
		List<Index> indexes = srquery.getRelation().getIndexes();
		if (indexes.size() == 0)
			throw new Exception("No indexes");

		HashMap<Clause, List<Index>> matchingSelectionIndexes = Utils.getMatchingIndexes(srquery, indexes);
		// calc price
		return 0;
	}

}
