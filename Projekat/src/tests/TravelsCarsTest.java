package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsCar;
import pages.TravelsLogin;

public class TravelsCarsTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.basicLogin("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}
	
	@Test(priority = 0)
	public void numberOfCars() throws InterruptedException {
		TravelsCar tc = new TravelsCar(driver);
		tc.addCars();
		boolean actual = tc.areThere10Cars();
		boolean expected = false;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 1)
	public void TotalOfOrders() throws InterruptedException {
		TravelsCar tc = new TravelsCar(driver);
		boolean actual = tc.isNOfOrdersOver50();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}

}
