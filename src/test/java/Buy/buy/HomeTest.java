package Buy.buy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
public static WebDriver driver;
	
	@BeforeMethod
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//dynamic timeout
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.gcrit.com/build3/");
		
	}
	
	@Test(groups="Home")
	public void verifyTitle() {
		String title=driver.getTitle();
		Assert.assertEquals("GCR Shop", title,"not a correct title");
	}
	
	@Test
	
	public void verifyLinks() {
		Boolean b=driver.findElement(By.linkText("login")).isDisplayed();
		Boolean b2=driver.findElement(By.linkText("create an account")).isDisplayed();
		Assert.assertTrue(b);
		Assert.assertTrue(b2);
	}
	
	@AfterMethod
	public void tearDownApp() {
		driver.quit();
	}
}
