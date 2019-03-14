package testClasses;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepository.HomePageWilliamsSomona;
import testBase.TestBaseClass;

public class OnLineShoping extends TestBaseClass {
	HomePageWilliamsSomona ObjHomePageWSomona;
	
	
	public OnLineShoping()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		Initilization();
		ObjHomePageWSomona= new HomePageWilliamsSomona();
	}

	
	@Test
	public void addItemInCart() {
		
		ObjHomePageWSomona.SelectItemFromMenu();
		ObjHomePageWSomona.SelectAndCheckoutTeaKatleItem();
		ObjHomePageWSomona.SaveForLaterItem();
		ObjHomePageWSomona.verifySavedItem();
	}
	
	@AfterTest
	public void tearDown() {
	driver.quit();	
	}
	
	
	
}
