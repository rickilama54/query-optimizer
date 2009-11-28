package queryopt.optimizer.join;

import queryopt.optimizer.query.JoinQuery;

public class NestedLoopsJoin extends Join {
	private static final String NAME = "Nested Loops Join";

	public NestedLoopsJoin(JoinQuery joinQuery) throws Exception {
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
