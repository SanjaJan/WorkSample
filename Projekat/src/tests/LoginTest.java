package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TravelsLogin;
 
public class LoginTest extends BasicTest {

	@Test (priority = 0)
	public void basicLoginTest() throws InterruptedException {
		
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.basicLogin("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
		
		Assert.assertTrue(this.driver.getTitle().contains("Dashboard"));
	}
	
	@Test (priority = 1)
	public void tableDataLoginTest() throws InterruptedException {
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.logOut();
		Thread.sleep(2000);
		
		tl.tableDataLogin();
		Thread.sleep(2000);
		
		Assert.assertTrue(this.driver.getTitle().contains("Dashboard"));
	}
}