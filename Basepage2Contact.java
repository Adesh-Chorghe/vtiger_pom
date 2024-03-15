package basicpom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import commonutils.ExcelUtil;
import commonutils.Javautil;
import commonutils.PropertyFileUtil;
import commonutils.WebDriverUtil;
import pom.LoginPage;
import pom1.ClickContacts;
import pom1.ClickContacts;
import pom1.CreateContacts;

public class Basepage2Contact {

	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
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
		
	

		// to read data from excel file

		String FNAME = eUtil.getDataFromExcel("Contacts", 0, 1);
		String LNAME = eUtil.getDataFromExcel("Contacts", 1, 1);
		String ASSIGNEDTO=eUtil.getDataFromExcel("Contacts", 2, 1);
		String ORGNAME = eUtil.getDataFromExcel("Contacts", 3, 1);
		System.out.println(ORGNAME);

		
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
		
		LoginPage lPage=new LoginPage();
		
		//to initialize the web element
		PageFactory.initElements(driver, lPage);
		lPage.getUsernametf().sendKeys(USERNAME);
		
		lPage.getPasswordtf().sendKeys(PASSWORD);
		lPage.getLoginbutton().click();
		
		//click on contacts
		ClickContacts contacts=new ClickContacts();
		PageFactory.initElements(driver, contacts);
		contacts.getClickOnContact().click();
		
		//click on create contact
		CreateContacts contacts2=new CreateContacts();
		PageFactory.initElements(driver, contacts2);
		contacts2.getCreateContact().click();
		
		//enter the first name
		contacts2.getFirstname().sendKeys(FNAME);
		//enter the last name
		contacts2.getLastname().sendKeys(LNAME);
		//enter the organization name
		//contacts2.getOrgname().sendKeys(ORGNAME);

		//CLICKon select(+)
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//transfer the control from the parent to child
		wUtil.switchWindow(driver,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		//to enter the organization name
		contacts2.getOrgname().sendKeys(ORGNAME);

		//to click on search now button
		driver.findElement(By.name("search")).click();
		//click on organization name
		driver.findElement(By.xpath("//a[text()='QSPIDER']")).click();
		
		//to transfer the control from child window to parent window
		wUtil.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
				

		//in the dropdown select team selling --to handle the dropdown select class is used
		
		contacts2.getAssignedto().click();

		WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		wUtil.handleDropdown(dropdown, ASSIGNEDTO);
		
Thread.sleep(5000);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();	  
		
		Thread.sleep(5000);
		//log out from the application
		//mouse over on image
	WebElement	image=driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
	wUtil.mousehover(driver, image);
	
	//click on sign out
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
		
		
		
		
		
		

	}
}
