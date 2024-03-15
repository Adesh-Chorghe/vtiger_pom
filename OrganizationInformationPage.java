package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutils.WebDriverUtil;

public class OrganizationInformationPage {

	WebDriverUtil wutil=new WebDriverUtil();
	
	//Identify the oraganization name
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	//identify group radio button
	@FindBy(xpath ="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;
	
	
	//identify the dropdown
     @FindBy(name="assigned_group_id")
     
     private WebElement dropdown;
     
     //identify save button
     @FindBy(xpath="(//input[@name='button'])[1]")
     
     
     private WebElement savebtn;
     
     //
     
     
	/**
	 * @return the organizationName
	 */
	public WebElement getOrganizationName() {
		return organizationName;
	}

	/**
	 * @return the groupbtn
	 */
	public WebElement getGroupbtn() {
		return groupbtn;
	}

	/**
	 * @return the dropdown
	 */
	public WebElement getDropdown() {
		return dropdown;
	}

	/**
	 * @return the savebtn
	 */
	public WebElement getSavebtn() {
		return savebtn;
	}

	//create a constructor
	
	public OrganizationInformationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
	//create a method for code optimization
	
	public void organizationinformation(String orgnameData,String groupData) {
		//enter organization name
		
		organizationName.sendKeys(orgnameData);
		//click on  group radio button
		groupbtn.click();
		//Select support group  in the dropdown
		wutil.handleDropdown(dropdown,groupData);
		//click on save button
		savebtn.click();
		
	}
	
	
	
	
	
	
	
	
	

}

