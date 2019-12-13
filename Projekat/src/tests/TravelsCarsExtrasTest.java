package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CarsExtras;
import pages.TravelsCar;
import pages.TravelsLogin;

public class TravelsCarsExtrasTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.basicLogin("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void addExtrasTest() throws InterruptedException {
		CarsExtras ce = new CarsExtras(driver);
		ce.getToExtras();
		
		ce.addExtras();
		Thread.sleep(2000);
		
		ce.setStatus("No");
		ce.addExtrasToCars("C:\\Users\\Sanja\\eclipse-workspace\\Projekat\\images\\cars.jpg","kolca","1500");
		Thread.sleep(2000);
		
		ce.clickOnSaveReturn();
		Thread.sleep(2000);
		
		Assert.assertEquals(ce.firstRowNameContent("kolca"), true);
	}
	
	@Test (priority = 1)
	public void lettersInPriceInput() throws InterruptedException {
		
		CarsExtras ce = new CarsExtras(driver);
		ce.addExtras();
		Thread.sleep(2000);
		
		ce.addExtrasToCars("C:\\Users\\Sanja\\eclipse-workspace\\Projekat\\images\\cars.jpg","kolca","abcd");
		Thread.sleep(2000);
		
		ce.clickOnSaveReturn();
		
		Assert.assertTrue(ce.isThereErrorMessage());
	}

}
