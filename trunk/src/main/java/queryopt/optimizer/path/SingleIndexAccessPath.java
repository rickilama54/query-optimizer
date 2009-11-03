package queryopt.optimizer.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.optimizer.Utils;
import queryopt.optimizer.entities.Clause;
import queryopt.optimizer.entities.CompareSingleRowClause;
import queryopt.optimizer.entities.Literal;
import queryopt.optimizer.entities.SingleRelationQuery;

public class SingleIndexAccessPath extends AccessPath {
	private Index index;

	public SingleIndexAccessPath(SingleRelationQuery srquery) throws Exception {
		super(srquery);
	}

	public Index getIndex() {
		return index;
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
