package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.TestBaseClass;

public class HomePageWilliamsSomona extends TestBaseClass {
	
	
	@FindBy(xpath ="//ul[@class='nav-menu']/li/a[contains(text(),'Cookware')]")
	WebElement CookWareMenu;

	@FindBy(xpath = "//div[div[text()='Stovetop']]/ul/li/a[contains(text(),'Tea')]")
	WebElement TeaCatleItem;

	@FindBy(xpath = "//img[@alt='Breville Variable-Temperature Tea & Coffee Kettle']")
	WebElement SelectTeaCatleItem;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement AddToCart;
	
	
	@FindBy(xpath ="//a[@title='Checkout']")
	WebElement Checkout;
	
	@FindBy(xpath ="//a[@class='view-cart']/span[text()='Checkout']")
	WebElement CheckoutOnSaveCartPage;
	
	
	@FindBy(xpath ="//span[text()='Save For Later']")
	WebElement SaveForLater;
	

	public HomePageWilliamsSomona() {

		PageFactory.initElements(driver, this);
	}

	
	public void SelectItemFromMenu() {
		Actions ac= new Actions(driver);
		ac.moveToElement(CookWareMenu).perform();
		TeaCatleItem.click();
		Assert.assertTrue(driver.getTitle().contains("Tea Kettles"));
		
	}
	
	public void SelectAndCheckoutTeaKatleItem() {
		SelectTeaCatleItem.click();	
		AddToCart.click();
		Checkout.click();
		}
	
	public void SaveForLaterItem() {
	   SaveForLater.click();
	   
	   
	}
	public void verifySavedItem() {
		driver.switchTo().frame("cartForm");
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Save For Later (1 Item)']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Breville Variable-Temperature Tea & Coffee Kettle']")).isDisplayed());
			
	}
	
	
}
