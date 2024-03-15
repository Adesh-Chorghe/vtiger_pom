package commonutils;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	// driver is global variable
	public WebDriver driver = new ChromeDriver();

	// declaration is done is only for the taking screenshot
	public static WebDriver sDriver;

	PropertyFileUtil pUtil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();

	@BeforeSuite
	public void BS() {
       System.out.println("connect to the database");
	}

	@BeforeClass
	public void BC() throws IOException {

		String BROWSER = pUtil.getDataFromPropertyFile("Browser");
		String URL = pUtil.getDataFromPropertyFile("url");

		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();

		} else {
			driver = new FirefoxDriver();
		}

		// initialization only for takes screenshot
		sDriver = driver;
		//to lauch the application
		driver.get(URL);
	}

	@BeforeMethod
	public void BM() throws IOException {
        String USERNAME=pUtil.getDataFromPropertyFile("Username");
        String PASSWORD=pUtil.getDataFromPropertyFile("Password");
        
        //login to the application
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
     
		
	}

	@AfterMethod
	public void AM() throws InterruptedException {

		Thread.sleep(3000);
		//log out from the application
		//mouse over on image
	WebElement	image=driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
	wutil.mousehover(driver, image);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

	@AfterClass
	public void AC() {

		System.out.println("close the browser");
		driver.quit();
	}

	@AfterSuite
	public void AS() {
System.out.println("disconnect the database");
		
	}

}
