package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelCustomer;
import pages.TravelsLogin;

public class TravelCustomerTest extends BasicTest {

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
	public void updateCustomerData() throws InterruptedException {
		TravelCustomer tc = new TravelCustomer(driver);
		tc.getToCustomers();
		Thread.sleep(2000);
		
		tc.editCustomer();
		Thread.sleep(2000);
		
		tc.updateCustomer("Ime", "Prezime", "email@gmail.com", "00381", "Ulica b.b.", "Serbia");
		Thread.sleep(2000);
		
		tc.clickOnSubmit();
		Thread.sleep(2000);
		
		tc.clickOnSearchBtn();
		Thread.sleep(2000);
		
		tc.getSearchInput("Ime");
		
		Assert.assertEquals(tc.nameSearch("Ime"), true);	
	}
}