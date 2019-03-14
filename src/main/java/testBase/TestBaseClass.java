package testBase;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import testUtils.TestUtils;
public class TestBaseClass {

	public static WebDriver driver;
	public static Properties pro;
	
	public TestBaseClass() {
		try {
			pro = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("Config.properties");
			pro.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Initilization() throws InterruptedException {
		String Browser = pro.getProperty("browser");
		System.out.println(Browser);
		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Hemant Namdev\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Hemant Namdev\\Desktop\\Selenium_JarFiles\\geckodriver-v0.16.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		Thread.sleep(10000);
		driver.get(pro.getProperty("url"));
		
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait,TimeUnit.SECONDS);
		
		
		
	}
	
	
	
}


