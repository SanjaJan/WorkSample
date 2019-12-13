package tests;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TravelsCar;
import pages.TravelsLogin;

public class TravelsCarsImageTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);
		
		TravelsLogin tl = new TravelsLogin(driver);
		tl.basicLogin("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}
	
	@Test
	public void imageUpload() throws InterruptedException {
		TravelsCar tc = new TravelsCar(driver);
		tc.addCars();
		tc.goToUploadSection();
		Thread.sleep(2000);
		
		tc.uploadImage("images\\cars.jpg");
		Thread.sleep(2000);
		
		Assert.assertTrue(tc.isImageUploadedSuccessfuly());
	}
}