package queryopt.optimizer;
import static org.testng.Assert.assertEquals;

import org.junit.Test;


public class TestUtils {
	@Test
	public void testCompareStrings1() {
		assertEquals(Utils.compare("A", "A", "A", "Z"), 0.0);
		assertEquals(Utils.compare("A", "A", "", ""), 0.0);
		assertEquals(true, Utils.compare("A", "B", "A", "B") < 0);
		assertEquals(true, Utils.compare("B", "A", "A", "B") > 0);
	}
	
}
