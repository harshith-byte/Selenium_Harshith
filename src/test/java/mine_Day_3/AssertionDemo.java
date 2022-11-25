package mine_Day_3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {

	@Test
	public void test1() {
		Assert.assertEquals(12, 13);
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(12, 13,"Count missmatch");
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void test4() {
		Assert.assertFalse(false);
	}
	
	@Test(dependsOnMethods="test1")
	public void test5() {
		String msg="Email already Registered";
		Assert.assertTrue(msg.contains("Registered"));
	}
	
	
	
}
