package queryopt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "queries", schema = "public")
public class Query {
	private int queryId;
	private String name;
	private String text;
	private Schema schema;

	public Query() {

	}

	public Query(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "query_id", unique = true, nullable = false)
	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "text", nullable = false, length = 10000)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schema_id", nullable = false)
	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

}
