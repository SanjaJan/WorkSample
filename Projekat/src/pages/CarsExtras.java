package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CarsExtras extends BasicPage {

	public CarsExtras(WebDriver driver) {
		super(driver);
	}
	
		private By cars = By.cssSelector("[href^='#Cars']");
		private By extras = By.cssSelector("[href^='https://www.phptravels.net/admin/cars/extras']");
		private By addExtras = By.cssSelector("a[class='btn btn-success xcrud-action']");
		private By addImage = By.cssSelector("input[name='xcrud-attach']");
		private By nameInput = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
		private By status = By.cssSelector("select.xcrud-input.form-control");
		private By priceInput = By.name("cHRfZXh0cmFzLmV4dHJhc19iYXNpY19wcmljZQ--");
		private By saveReturn = By.cssSelector(".xcrud-top-actions.btn-group a");
		
		private By rowData = By.cssSelector(".xcrud-row.xcrud-row-0");
		
		private By errorMessage = By.cssSelector(".xcrud-message.error");
		
		public void clickOnCars() {
			this.driver.findElement(this.cars).click();
		}
		
		public void clickOnExtras() {
			this.driver.findElement(this.extras).click();
		}
		
		public void getToExtras() {
			this.clickOnCars();
			this.clickOnExtras();
		}
		
		public void addExtras() {
			this.driver.findElement(this.addExtras).click();
		}
		
		public WebElement getAddImage() {
			return this.driver.findElement(this.addImage);
		}
		
		public WebElement getNameInput() {
			return this.driver.findElement(this.nameInput);
		}
		
		public WebElement getStatus() {
			return this.driver.findElement(status);
		}
		
		public WebElement getPriceInput() {
			return this.driver.findElement(this.priceInput);
		}
		
		public void clickOnSaveReturn() {
			this.driver.findElement(this.saveReturn).click();
		}
		
		public void setStatus(String yesOrNo) {
			WebElement selectStatus = driver.findElement(this.status);
			Select statusi = new Select(selectStatus);
			statusi.selectByVisibleText(yesOrNo);
		}
		
		public void addExtrasToCars(String path, String name, String price) {
			getAddImage().sendKeys(path);
			getNameInput().sendKeys(name);
			getPriceInput().sendKeys(price);
		}
		
		public boolean firstRowNameContent(String name) {
			boolean matchingName  = false;
			WebElement firstRow = driver.findElement(this.rowData);
			if(firstRow.getText().contains(name)) {
				matchingName = true;
			}
			return matchingName;
		}	
		
		public boolean isThereErrorMessage() {
			//"Some fields are likely to contain errors. Fix errors and try again"
			try {
				return this.driver.findElement(this.errorMessage) != null;
			} catch (Exception e) {
				return false;
			}
		}
	}
