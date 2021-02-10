package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FTest {
	
public WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\eclipse-workspace\\com.demotestmaven\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
	@Test(priority = 1)
	public void One() {
		driver.get("https://google.com");
	}
	@Test(dependsOnMethods = "One")
	public void two() {
		driver.get("https://bing.com");
	}
	@Test(dependsOnMethods = "two")
	public void three() {
		driver.get("https://yahoo.com");
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();//Branch code updated
	}

}
