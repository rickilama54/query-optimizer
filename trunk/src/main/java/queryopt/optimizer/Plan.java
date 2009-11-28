package queryopt.optimizer;

import queryopt.entities.Relation;
import queryopt.entities.SystemInfo;

public abstract class Plan {
	private SystemInfo systemInfo;

	public Plan(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

	protected long cost;

	public long getCost() {
		return cost;
	}

	public abstract Relation getOutputRelation();

	protected abstract String getName();

	protected abstract String getPrefix();

	protected abstract String getSufix();

	public String getPlanAsTree() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());

		sb.append(" " + this.getPrefix());

		sb.append(" (");
		sb.append("cost=" + cost);
		sb.append(" ");
		sb.append("rows=" + this.getOutputRelation().getNoOfRows());
		sb.append(" ");
		sb
				.append("width=" + (double) Utils.getRelationSizeInBytes(this.getOutputRelation(), systemInfo) / 1000
						+ " kB");
		sb.append(")");

		sb.append(this.getSufix());
		return sb.toString();
	}
}
