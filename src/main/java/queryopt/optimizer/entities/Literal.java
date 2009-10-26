package queryopt.optimizer.entities;

public class Literal implements Term {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
