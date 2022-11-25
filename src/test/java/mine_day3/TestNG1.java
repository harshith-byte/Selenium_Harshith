package mine_day3;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

// Run All
public class TestNG1 {
	
	
  @Test(priority = 2)
	public void login() {
	  System.out.println("Login done");
	}
  @Test()
  	public void createAccount() {
	  System.out.println("Account creates");
  }
  @Test()
  
  public void deleteAccount() {
	  System.out.println("Account deleted");
  }
  @Test(priority =1)
  public void logoutAccount() {
	  System.out.println("Logout done");
  }

}
