package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.This;
import commonutils.WebDriverUtil;

public class HomePage extends WebDriverUtil {

	// identify the organization element

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organization;

	// identify the Contact element

	@FindBy(xpath = "//a[text()=(//a[text()='Contacts'])[1]]")
	private WebElement contact;

	// identify the signout image
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;

	// identify the sign out element
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutbtn;

	/**
	 * @return the organization
	 */
	public WebElement getOrganization() {
		return organization;
	}

	/**
	 * @return the contact
	 */
	public WebElement getContact() {
		return contact;
	}

	/**
	 * @return the image
	 */
	public WebElement getImage() {
		return image;
	}

	/**
	 * @return the signoutbtn
	 */
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	// create a constructor
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	// create a method
	public void home() {

		organization.click();

		

	}
	
	public void signout(WebDriver driver) {
		// mouse over on image

				mousehover(driver, image);

				// click on sign out btn
				signoutbtn.click();

	}
}
