package GenaricUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMclass.MyHomePage;
import POMclass.MyLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	FetchingData data=new FetchingData();

	@BeforeClass
	public void Lunchingthe_Browser() throws Throwable 
	{
		System.out.println("----launching the Browser----");
		String browser = data.FetchingDatafromPropertiesFile("Browser");

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String URL=data.FetchingDatafromPropertiesFile("Url");
		driver.get(URL);
		
		
	}
	@BeforeMethod
	public void Logintheapplication() throws Throwable {
		System.out.println("-------Login the application--------");
		String USERNAME = data.FetchingDatafromPropertiesFile("Username");
		String PASSWORD = data.FetchingDatafromPropertiesFile("Password");
		MyLoginPage loginpage=new MyLoginPage(driver);
		loginpage.getUsertextfield().sendKeys(USERNAME);
		loginpage.getPasswordtextfield().sendKeys(PASSWORD);
		loginpage.getLoginbutton().click();
		
	    
	}
	@AfterMethod
	public void Logouttheapplication() {
		System.out.println("------Logout the application-----");
		MyHomePage myhomepage = new MyHomePage(driver);
		myhomepage.getDropdown().click();
		myhomepage.getLogout().click();
		
	}
	@AfterClass
	public void afterclass() throws Throwable {
		System.out.println("------Logout server------");
		Thread.sleep(3000);
		driver.quit();
	}
	

}
