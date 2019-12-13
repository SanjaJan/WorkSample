package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ExcelUtils;

public class TravelsLogin extends BasicPage {

	private By demoCredentials = By.cssSelector("[href^='//www.phptravels.net/admin']");
	private By email = By.name("email");
	private By password = By.cssSelector("input[type='password']");
	private By rememberMe = By.cssSelector("input[type='checkbox']");
	private By forgetPass = By.id("link-forgot");
	private By loginBtn = By.cssSelector("button[type='submit']");
	
	private By logOut = By.cssSelector("[href^='https://www.phptravels.net/admin/logout']");
	
	public void clickOnDemoCred() {
		this.driver.findElement(this.demoCredentials).click();
	}
	
	public void setEmail(String email) {
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void setPassword(String password) {
		this.driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickOnRememberMe() {
		this.driver.findElement(this.rememberMe).click();
	}
	
	public void clickOnForgetPass() {
		this.driver.findElement(this.forgetPass).click();
	}
	
	public void clickOnLoginBtn() {
		this.driver.findElement(this.loginBtn).click();
	}
	
	public void basicLogin(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
		clickOnLoginBtn();
	}
	
	public void tableDataLogin() {
		ExcelUtils ex = new ExcelUtils();
		ex.setExcell("C:\\Users\\Sanja\\eclipse-workspace\\Projekat\\Username.xlsx");
		ex.setWorkSheet(0);
		
		for (int i = 1; i < ex.getRowNumber(); i++) 
		{
			this.setEmail(ex.getDataAt(i, 0));
			this.setPassword(ex.getDataAt(i, 1));
			clickOnLoginBtn();
			
		}
		ex.closeExcell();
	}
	
	public void logOut() {
		this.driver.findElement(this.logOut).click();
	}
	
	public TravelsLogin(WebDriver driver) {
		super(driver);
		
	}

}
