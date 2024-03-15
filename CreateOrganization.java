package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {

	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement createOrgnizationElement;

	/**
	 * @return the createOrgnizationElement
	 */
	public WebElement getCreateOrgnizationElement() {
		return createOrgnizationElement;
	}


	//create  a constructor
	
	public CreateOrganization(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//create  a constructor
	
	public void organization() {
		
		createOrgnizationElement.click();
	}
	
	
}
