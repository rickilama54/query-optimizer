package queryopt.optimizer.query;

public class Literal implements Term {
	private String value;

	public Literal(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
