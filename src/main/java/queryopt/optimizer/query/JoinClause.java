package queryopt.optimizer.query;

import queryopt.entities.Atribute;

public class JoinClause extends CompareSingleRowClause {

	public JoinClause(Operator operator, Atribute atribute1, Atribute atribute2) {
		super(operator, atribute1, atribute2);
	}

}
