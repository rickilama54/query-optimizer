package queryopt.optimizer.join;

import java.util.List;

import queryopt.optimizer.RelAlgebraOperation;
import queryopt.optimizer.path.AccessPath;
import queryopt.optimizer.query.CompareSingleRowClause;

public class NestedLoopsJoin extends Join {

	public NestedLoopsJoin(RelAlgebraOperation left, AccessPath right, List<CompareSingleRowClause> joinClauses) {
		super(left, right, joinClauses);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected long calcCost(List<CompareSingleRowClause> joinClauses) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
