package pages;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCar extends BasicPage {

	public TravelsCar(WebDriver driver) {
		super(driver);
	}   

	private By cars = By.cssSelector("[href^='#Cars']");
	private By addCars = By.cssSelector("[href^='https://www.phptravels.net/admin/cars']");
	private By extras = By.cssSelector("[href^='https://www.phptravels.net/admin/cars/extras']");
	private By carsRows = By.cssSelector("tbody tr");
	private By orders = By.cssSelector(".form-control.input-sm");
	private By allBtn = By.cssSelector("button[data-limit='all']");
	
	private By upload = By.cssSelector("[href^='https://www.phptravels.net/admin/cars/gallery/Camioneta-151']");
	private By addPhotosBtn = By.cssSelector("a[class='btn btn-success']");
	private By uploadInput = By.cssSelector("input.dz-hidden-input");
	
	private By deleteNewImg = By.cssSelector(".btn.btn-danger.btn-block.btn-md.deleteImg");
	
	public void clickOnCars() {
		this.driver.findElement(this.cars).click();
	}
	
	public void clickOnAddCars() {
		this.driver.findElement(this.addCars).click();
	}
	
	public void addCars() {
		this.clickOnCars();
		this.clickOnAddCars();
	}
	
	public boolean areThere10Cars() {
		List<WebElement> carsList = driver.findElements(this.carsRows);
		boolean tenCars = false;
		System.out.println(carsList.size());
			if (carsList.size() == 10) {
				tenCars = true;
			} 
			System.out.println(tenCars);
			return tenCars;
	}
	
	public void clickOnAllBtn() {
		this.driver.findElement(this.allBtn).click();
	}
	
	public List<WebElement> getOrders() {
		return this.driver.findElements(orders);
	}
	
	public boolean isNOfOrdersOver50() {
		
		List<WebElement> ordersList = driver.findElements(this.orders);
		List<String> ordersString = new ArrayList<String>();
		
		//getting the attributes (value)
			for(WebElement e : ordersList){
				ordersString.add(e.getAttribute("value"));
			}     
		
		List<Integer> ordersNumbers = new ArrayList<Integer>();
		
		//String to int conversion
			for(String e: ordersString) {
				ordersNumbers.add(Integer.parseInt(e));
				}
		
		int totalOrders = 0;
			for (int i: ordersNumbers) {
				totalOrders = totalOrders + i;
			}
			System.out.println(totalOrders);
	
		boolean over50 = false;
			if (totalOrders > 50) {
				over50 = true;
			}
		
		return over50;
	}
	
	public void clickOnUpload() {
		this.driver.findElement(this.upload).click();
	}
	
	public void addPhotos() {
		this.driver.findElement(this.addPhotosBtn).click();
	}
	
	public void goToUploadSection() {
		clickOnUpload();
		addPhotos();
	}
	
	public WebElement getUploadInput() {
		return this.driver.findElement(uploadInput);
	}
	
	public void uploadImage(String path) {
		getUploadInput().sendKeys(new File(path).getAbsolutePath());
	}
	
	public boolean isImageUploadedSuccessfuly() {
		try {
			return this.driver.findElement(this.deleteNewImg) != null;
		} catch (Exception e) {
			return false;
		}
	}
}


	
