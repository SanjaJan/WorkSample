package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelCustomer extends BasicPage {

	public TravelCustomer(WebDriver driver) {
		super(driver);
	}
	
	private By accounts = By.cssSelector("[href='#ACCOUNTS']");
	private By customers = By.cssSelector("#ACCOUNTS li a");
	private By edit = By.cssSelector("[title='Edit']");
	
	private By fNameInput = By.cssSelector("input[name='fname']");
	private By lNameInput = By.cssSelector("input[name='lname']");
	private By emailInput = By.cssSelector("input[name='email']");
	private By mobNmbInput = By.cssSelector("input[name='mobile']");
	private By address1Input = By.cssSelector("input[name='address1']");
	private By selectCountry = By.className("select2-choice");
	private By editCountry = By.className("select2-input");
	
	private By status = By.cssSelector("select[name='status']");
	private By emailNewslSbscr = By.cssSelector("input[class='checkbox']");
	private By submitBtn = By.cssSelector(".panel-footer button");
	
	private By searchBtn = By.cssSelector(".xcrud-search-toggle.btn.btn-default");
	private By searchInput = By.name("phrase");
	private By searchResult = By.cssSelector(".xcrud-row.xcrud-row-0");
	
	public void clickOnSubmit() {
		this.driver.findElement(this.submitBtn).click();
	}

	public void clickOnAccounts() {
		this.driver.findElement(this.accounts).click();
	}
	
	public void clickOnCustomers() {
		this.driver.findElements(this.customers).get(2).click();
	}
	
	public void getToCustomers() {
		this.clickOnAccounts();
		this.clickOnCustomers();
	}
	
	public void editCustomer() {
		this.driver.findElement(this.edit).click();
	}
	
	public void setFName(String name) {
		WebElement fName = this.driver.findElement(this.fNameInput);
		fName.clear();
		fName.sendKeys(name);	
	}
	
	public void setLName(String surname) {
		WebElement lName = this.driver.findElement(this.lNameInput);
		lName.clear();
		lName.sendKeys(surname);
	}
	
	public void setEmail(String emailAddr) {
		WebElement email = this.driver.findElement(this.emailInput);
		email.clear();
		email.sendKeys(emailAddr);
	}
	
	public void setMobNmb(String number) {
		WebElement mobNmb = this.driver.findElement(this.mobNmbInput);
		mobNmb.clear();
		mobNmb.sendKeys(number);
	}
	
	public void setAddress1(String address1) {
		WebElement address = this.driver.findElement(this.address1Input);
		address.clear();
		address.sendKeys(address1);
	}
	
	public void getCountry() {
		this.driver.findElement(this.selectCountry).click();
	}
	
	public void setCountryName(String countryN) {
		WebElement country= this.driver.findElement(this.editCountry);
		country.sendKeys(countryN);
		country.sendKeys(Keys.ENTER);
	}
	
	public void setStatus1(String enblOrDsbl) {
		WebElement selectStatus1 = driver.findElement(this.status);
		Select statuses = new Select(selectStatus1);
		statuses.selectByVisibleText(enblOrDsbl);
	}
	
	public void checkNewsletter() {
		this.driver.findElement(this.emailNewslSbscr).click();
	}
	
	public void updateCustomer(String name, String surname, String emailAddr, String number, String address1, String countryN) throws InterruptedException {
		this.setFName(name);
		this.setLName(surname);
		Thread.sleep(2000);
		this.setEmail(emailAddr);
		this.setMobNmb(number);
		this.setAddress1(address1);
		this.getCountry();
		this.setCountryName(countryN);
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement newsLett = driver.findElement(this.emailNewslSbscr);
		js.executeScript("arguments[0].scrollIntoView();", newsLett);
		
		this.checkNewsletter();
		Thread.sleep(2000);
		this.clickOnSubmit();
	}
	
	public void clickOnSearchBtn() {
		((JavascriptExecutor) driver)
	    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.driver.findElement(this.searchBtn).click();
	}
	
	public void getSearchInput(String name) {
		WebElement sInput = this.driver.findElement(this.searchInput);
		sInput.sendKeys(name);
		sInput.sendKeys(Keys.ENTER);
	}
	
	public WebElement getResult() {
		return this.driver.findElement(this.searchResult);
	}
	
	public boolean nameSearch(String name) {
		boolean matchingFirstName  = false;
		WebElement firstName = driver.findElement(this.searchResult);
		if(firstName.getText().contains(name)) {
			matchingFirstName = true;
		}
		return matchingFirstName;
	}
}