package queryopt.optimizer.join;

import queryopt.optimizer.query.JoinQuery;

public class SortMergeJoin extends Join {

	public SortMergeJoin(JoinQuery joinQuery)  throws Exception {
		super(joinQuery);
	}

	@Override
	protected long calcCost(JoinQuery joinQuery) {
		// TODO Auto-generated method stub
		return 0;
	}

}
