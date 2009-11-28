package queryopt.optimizer.join;

import queryopt.optimizer.query.JoinQuery;

public class IndexNestedLoopsJoin extends Join {

	private static final String NAME = "Index Nested Loops Join";

	public IndexNestedLoopsJoin(JoinQuery joinQuery) throws Exception {
		super(joinQuery);
	}

	@Override
	protected String getName() {
		return NAME;
	}


	@Override
	protected long calcCost(JoinQuery joinQuery) {
		// TODO Auto-generated method stub
		return 0;
	}

}
