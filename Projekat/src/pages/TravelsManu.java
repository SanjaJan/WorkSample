package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelsManu extends BasicPage { 

	private By dashboard = By.cssSelector("[href^='https://www.phptravels.net/admin']");
	private By updates = By.cssSelector("[href^='https://www.phptravels.net/admin/updates/']");
	private By modules = By.cssSelector("[href^='https://www.phptravels.net/admin/settings/modules/']");
	private By tours = By.cssSelector("[href^='#Tours']");
	private By addNewTours = By.xpath("//*[@id=\"Tours\"]/li[2]/a");
	private By coupons = By.cssSelector("[href^='https://www.phptravels.net/admin/coupons/']");
	private By newsletter = By.cssSelector("[href^='https://www.phptravels.net/admin/newsletter/']");
	private By bookings = By.cssSelector("[href^='https://www.phptravels.net/admin/bookings/']");

	public void clickOnDashboard() {
		this.driver.findElement(this.dashboard).click();
	}
	
	public void clickOnUpdates() {
		this.driver.findElement(this.updates).click();
	}
	
	public void clickOnModules() {
		this.driver.findElement(this.modules).click();
	} 
	
	public void clickOnTours() {
		this.driver.findElement(this.tours).click();
	}
	
	public void clickOnAddNew() {
		this.driver.findElement(this.addNewTours).click();
	}
	
	public void clickOnCoupons() {
		this.driver.findElement(this.coupons).click();
	}
	
	public void clickOnNewsletter() {
		this.driver.findElement(this.newsletter).click();
	}
	
	public void clickOnBookings() {
		this.driver.findElement(this.bookings).click();
	}
	
	public TravelsManu(WebDriver driver) {
		super(driver);	
	}

}
