package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		
		//identify the user name textfield
	      
	      @FindBy(name="user_name")
	     private WebElement usernametf;
	
	
		//identify the password textfield
	      @FindBy(name="user_password")
	     private WebElement passwordtf;
	      
		//identify the login button
	      
	      @FindBy(id="submitButton")
	     private WebElement loginbutton;

		/**
		 * @return the usernametf
		 */
		public WebElement getUsernametf() {
			return usernametf;
		}

		/**
		 * @return the passwordtf
		 */
		public WebElement getPasswordtf() {
			return passwordtf;
		}

		/**
		 * @return the loginbutton
		 */
		public WebElement getLoginbutton() {
			return loginbutton;
		}
		
		//create a constructor-- to initialized  webelement
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//create a method
		
		public void login(String usernameData,String passwordData) {
			
			usernametf.sendKeys(usernameData);
			passwordtf.sendKeys(passwordData);
			loginbutton.click();
			
		}
		
	      
	      
	      
}
