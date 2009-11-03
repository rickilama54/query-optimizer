package queryopt.optimizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import queryopt.entities.Atribute;
import queryopt.entities.Index;
import queryopt.entities.Relation;
import queryopt.optimizer.entities.Clause;
import queryopt.optimizer.entities.CompareSingleRowClause;
import queryopt.optimizer.entities.Literal;
import queryopt.optimizer.entities.SPJQuery;
import queryopt.optimizer.entities.SingleRelationQuery;

public class Utils {
	public static Relation performSelection(Relation relation, List<Clause> selectionClauses) {
		return null;
	}

	public static Relation projectOutSingleRelation(Relation relation, SPJQuery query) {
		return null;
	}

	// Treba i nesto kako project out atributes after Join
	public static HashMap<Clause, List<Index>> getMatchingIndexes(SingleRelationQuery srquery, List<Index> indexes)
			throws Exception {
		HashMap<Clause, List<Index>> matchingSelectionIndexes = new HashMap<Clause, List<Index>>();

		for (Clause clause : srquery.getSelectionCnfClauses()) {
			if (clause instanceof CompareSingleRowClause) {
				CompareSingleRowClause csrclause = (CompareSingleRowClause) clause;
				Atribute atribute = null;
				if (csrclause.getOperand1() instanceof Literal && csrclause.getOperand2() instanceof Atribute)
					atribute = (Atribute) csrclause.getOperand2();
				else if (csrclause.getOperand1() instanceof Atribute && csrclause.getOperand2() instanceof Literal)
					atribute = (Atribute) csrclause.getOperand1();

				if (atribute != null)
					for (Index index : indexes)
						if (atribute.equals(index.getIndexAtributes().get(0))) {
							if (!matchingSelectionIndexes.containsKey(clause))
								matchingSelectionIndexes.put(clause, new ArrayList<Index>());
							matchingSelectionIndexes.get(clause).add(index);
						}
			} else
				throw new Exception("Not implemented yet");
		}
		return matchingSelectionIndexes;
	}
}
