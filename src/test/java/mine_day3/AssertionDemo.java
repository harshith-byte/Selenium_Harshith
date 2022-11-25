package mine_day3;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
	@Test
	public void test1() {
		AssertJUnit.assertEquals(12, 12);
	}
	@Test
	public void test2() {
		AssertJUnit.assertEquals(12, 13);
	}
	@Test(dependsOnMethods = "test2")
	public void test3() {
		AssertJUnit.assertTrue(true);
	}

}
