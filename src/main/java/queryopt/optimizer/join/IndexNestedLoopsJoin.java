package queryopt.optimizer.join;

import java.util.List;

import queryopt.optimizer.RelAlgebraOperation;
import queryopt.optimizer.entities.CompareSingleRowClause;
import queryopt.optimizer.path.AccessPath;

public class IndexNestedLoopsJoin extends Join {

	public IndexNestedLoopsJoin(RelAlgebraOperation left, AccessPath right, List<CompareSingleRowClause> joinClauses) {
		super(left, right, joinClauses);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected long calcCost(List<CompareSingleRowClause> joinClauses) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
