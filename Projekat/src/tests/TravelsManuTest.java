package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsLogin;
import pages.TravelsManu;

public class TravelsManuTest extends BasicTest {
	
	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.basicLogin("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void dashboardAccess() throws InterruptedException {
		TravelsManu tm = new TravelsManu(driver);
		tm.clickOnDashboard();
		Thread.sleep(3000);
		Assert.assertTrue(this.driver.getTitle().contains("Dashboard"));
	}
	
	@Test(priority = 0)
	public void updatesAccess() throws InterruptedException {

		TravelsManu tm = new TravelsManu(driver);
		tm.clickOnUpdates();
		Thread.sleep(3000);
		Assert.assertTrue(this.driver.getTitle().contains("Updates"));
	}
	
	@Test(priority = 2)
	public void modulesAccess() throws InterruptedException {
		TravelsManu tm = new TravelsManu(driver);
		tm.clickOnModules();
		Thread.sleep(3000);
		Assert.assertTrue(this.driver.getTitle().contains("Modules"));
	}
	 
	@Test(priority = 3)
	public void toursAccess() throws InterruptedException {
	TravelsManu tm = new TravelsManu(driver);
	tm.clickOnTours();
	tm.clickOnAddNew();
	Thread.sleep(3000);
	Assert.assertTrue(this.driver.getTitle().contains("Add Tour"));
	}
	
	@Test(priority = 4)
	public void couponsAccess() throws InterruptedException {
		TravelsManu tm = new TravelsManu(driver);
		tm.clickOnCoupons();
		Thread.sleep(3000);
		Assert.assertTrue(this.driver.getTitle().contains("Coupon Codes Management"));
	}
	
	@Test(priority = 5)
	public void newsletterAccess() throws InterruptedException {
		TravelsManu tm = new TravelsManu(driver);
		tm.clickOnNewsletter();
		Thread.sleep(3000);
		Assert.assertTrue(this.driver.getTitle().contains("Newsletter Management"));
	}
	
	@Test(priority = 1)
	public void bookingsAccess() throws InterruptedException {
		TravelsManu tm = new TravelsManu(driver);
		tm.clickOnBookings();
		Thread.sleep(3000);
		Assert.assertTrue(this.driver.getTitle().contains("Booking Management"));
	}
	
}
