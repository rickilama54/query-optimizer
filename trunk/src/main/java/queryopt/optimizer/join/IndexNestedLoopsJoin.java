package queryopt.optimizer.join;

import queryopt.optimizer.query.JoinQuery;

public class IndexNestedLoopsJoin extends Join {

	public IndexNestedLoopsJoin(JoinQuery joinQuery) {
		super(joinQuery);
	}

	@Override
	protected long calcCost(JoinQuery joinQuery) {
		// TODO Auto-generated method stub
		return 0;
	}

}
