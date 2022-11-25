package mine_Day_3;

import org.testng.annotations.Test;

public class MyFirstTestNGTest {

	@Test(priority = 2)
	public void login() {
		System.out.println("Login");
	}
	
	@Test(priority=1)
	public void logout() {
		System.out.println("Logout");
	}
	
	@Test(priority=3)
	public void createaccount() {
		System.out.println("Account created");
	}
	
	@Test(priority=4)
	public void deleteaccount() {
		System.out.println("Delete account");
	}
	
}
