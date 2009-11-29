package queryopt.optimizer;

import static org.testng.Assert.assertEquals;
import static queryopt.optimizer.Utils.*;

import java.math.BigDecimal;

import org.junit.Test;

import queryopt.entities.Atribute;
import queryopt.entities.Relation;
import queryopt.optimizer.query.Operator;

public class TestUtils {
	@Test
	public void testCompareStrings1() {
		assertEquals(Utils.compare("A", "A", "A", "Z"), 0.0);
		assertEquals(true, Utils.compare("A", "B", "A", "B") < 0);
		assertEquals(true, Utils.compare("B", "A", "A", "B") > 0);
	}

	@Test
	public void test_getHashValue() {
		assertEquals(getHashValue("A"), getHashValue("A"));
		assertEquals(getHashValue("A").subtract(getHashValue("A")), new BigDecimal(0));
		assertEquals(getHashValue("A").subtract(getHashValue("B")).intValue() < 0, true);
		assertEquals(getHashValue("B").subtract(getHashValue("A")).intValue() > 0, true);
	}

	@Test
	public void test_normalize() {
		assertEquals(normalize("A", "A", "Z").doubleValue(), 0.0);
		assertEquals(normalize("Z", "A", "Z").doubleValue(), 1.0);
		assertEquals(normalize("AAA", "AAA", "ZZZ").doubleValue(), 0.0);
		assertEquals(normalize("ZZZ", "AAA", "ZZZ").doubleValue(), 1.0);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_FK_EQ_sameDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		a1.setFkAtribute(a2);

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), 1000);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_FK_EQ_differentDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("B");
		a2.setHighValue("Z");

		a1.setFkAtribute(a2);

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), (int) (1000 * 0.96));

	}

	@Test
	public void test_getNoOfRowsAfterJoin_EQ_distinct1() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(50);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		a1.setFkAtribute(a2);

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), 2000);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_EQ_distinct2() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(50);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(50);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		a1.setFkAtribute(a2);

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), 2000);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_EQ_distinct3() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(10);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		a1.setFkAtribute(a2);

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), 10000);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_EQ_distinct4() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(0);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		a1.setFkAtribute(a2);

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), 100000);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_EQ_sameDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), 1000);
	}

	@Test
	public void test_getNoOfRowsAfterJoin_EQ_differentDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();
		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("B");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.EQ), (int) (1000 * 0.96));

	}

	@Test
	public void test_getNoOfRowsAfterJoin_GT_sameDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.GT), 10 * (99 * 100 / 2));

	}

	@Test
	public void test_getNoOfRowsAfterJoin_GT_EQ_sameDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.GT_EQ), 10 * (100 * 101 / 2));

	}

	@Test
	public void test_getNoOfRowsAfterJoin_LS_sameDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.LS), 10 * (99 * 100 / 2));

	}

	@Test
	public void test_getNoOfRowsAfterJoin_LS_EQ_sameDomain() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.LS_EQ), 10 * (100 * 101 / 2));

	}

	@Test
	public void test_getNoOfRowsAfterJoin_GT_diffDomain1() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("ZZ");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.GT), 99796);

	}

	@Test
	public void test_getNoOfRowsAfterJoin_GT_diffDomain2() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("Z");
		a1.setHighValue("ZZ");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("A");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.GT), 100000);

	}

	@Test
	public void test_getNoOfRowsAfterJoin_LS_diffDomain1() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Y");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("B");
		a2.setHighValue("Z");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.LS), 49403);

	}

	@Test
	public void test_getNoOfRowsAfterJoin_LS_diffDomain2() throws Exception {
		Relation r1 = new Relation();
		r1.setNoOfRows(1000);
		Atribute a1 = new Atribute();

		a1.setRelation(r1);
		a1.setDistinctPercent(100);
		a1.setLowValue("A");
		a1.setHighValue("Z");

		Relation r2 = new Relation();
		r2.setNoOfRows(100);
		Atribute a2 = new Atribute();
		a2.setRelation(r2);
		a2.setDistinctPercent(100);
		a2.setLowValue("Z");
		a2.setHighValue("ZZ");

		assertEquals(getNoOfRowsAfterJoin(a1, a2, Operator.LS), 100000);

	}
}
