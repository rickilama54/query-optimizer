package queryopt.optimizer.join;

import queryopt.optimizer.Utils;
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
		long costLeft = joinQuery.getLeft().getCost();
		long costRight = joinQuery.getRight().getCost();

		long memorySize = joinQuery.getSystemInfo().getMemorySizeInBytes();
		long leftSize = Utils
				.getRelationSizeInBytes(joinQuery.getLeft().getOutputRelation(), joinQuery.getSystemInfo());
		long rightSize = Utils.getRelationSizeInBytes(joinQuery.getRight().getOutputRelation(), joinQuery
				.getSystemInfo());

		int memoryFactor = 1;

		if (memorySize < leftSize + rightSize) {
			long innerRelationSize = costLeft < costRight ? leftSize : rightSize;
			int pageSize = joinQuery.getSystemInfo().getPageSizeInBytes();
			memoryFactor = (int) Math.ceil((double) innerRelationSize / (double) (memorySize - pageSize * 2));
		}

		long innerRelationCost = costLeft < costRight ? costLeft : costRight;
		long outerRelationCost = costLeft > costRight ? costLeft : costRight;

		return outerRelationCost + memoryFactor * innerRelationCost;
	}

}
