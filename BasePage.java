package basicpom;

import java.io.IOException;

import org.checkerframework.checker.mustcall.qual.CreatesMustCallFor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import commonutils.ExcelUtil;
import commonutils.Javautil;
import commonutils.PropertyFileUtil;
import commonutils.WebDriverUtil;
import pom.CreateOrganization;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganizationInformationPage;

public class BasePage {

	public static WebDriver  driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//create the object property file
		PropertyFileUtil fileUtil=new PropertyFileUtil();
		ExcelUtil eUtil=new ExcelUtil();
		WebDriverUtil wUtil=new WebDriverUtil();
		Javautil jUtil=new Javautil();
		
		
		//to read the data from the property file
		String URL = fileUtil.getDataFromPropertyFile("Url");
		String USERNAME = fileUtil.getDataFromPropertyFile("Username");
		String PASSWORD = fileUtil.getDataFromPropertyFile("Password");
		String BROWSER=fileUtil.getDataFromPropertyFile("Browser");
		System.out.println(BROWSER);

		//to read data from excel file
		String ORGNAME=eUtil.getDataFromExcel("Organization", 0, 1);
          String GROUP  = eUtil.getDataFromExcel("Organization", 1, 1) ;
		
		

		//to launch the browser
		
	
		 if (BROWSER.equals("chrome")) {
			
			  driver=new ChromeDriver();
			  
		} else if(BROWSER.equals("firefox")){
                
			driver=new FirefoxDriver();
		}
		 else {
			driver=new EdgeDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		
		//create object of login page
		
		LoginPage lPage=new LoginPage(driver);
		
		lPage.login(USERNAME, PASSWORD);
		
	//***********orrrrrrrrrrrrrrrrrrr****	
//		lPage.getUsernametf().sendKeys(USERNAME);
//		
//		lPage.getPasswordtf().sendKeys(PASSWORD);
//		lPage.getLoginbutton().click();
		
		
		
	
		//create the object of homepage
		HomePage hPage=new HomePage(driver);
		hPage.home();
		
		
		
		//create the object of organizationpage
	CreateOrganization createOrganization=new CreateOrganization(driver);
	
//	createOrganization.getCreateOrgnizationElement().click();
//		
		createOrganization.organization();
		
		//create the object organizationname
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		
          oip.organizationinformation(ORGNAME+jUtil.getRandomNumber(),GROUP);
		
//		//click on group radio btn
//		oip.getGroupbtn().click();
		
//		
//		//select support group in thre dropdown
//		wUtil.handleDropdown(oip.getDropdown(),GROUP);
		
		
//		//click on save button
//		oip.getSavebtn().click();
		
		//mouse over on image
		Thread.sleep(2000);
		hPage.signout(driver);
		//wUtil.mousehover(driver,hPage.getImage() );
		
//		//click on sign out button
//	   hPage.getSignoutbtn().click();
				
		
		
		
	}
}
