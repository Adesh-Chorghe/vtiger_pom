package commonutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.Acceleration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.css.CSS.TakeCoverageDeltaResponse;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {


	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();	
	}
	
	public void implicitwait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	public void handleDropdown(WebElement element,String targetedElement) {
		Select select=new Select(element);
		
		select.selectByVisibleText(targetedElement);
		
	}
	public void mousehover(WebDriver driver,WebElement element) {
		
		Actions actions=new Actions(driver);
	    actions.moveToElement(element);
	    actions.perform();
	}
	
	public void switchWindow(WebDriver driver,String expectedurl) {
		
	Set<java.lang.String> ids = driver.getWindowHandles();
	
	for (String e : ids) {
		
		java.lang.String actualurl = driver.switchTo().window(e).getCurrentUrl();
		
		if (actualurl.contains(expectedurl)) {
			break;
		}
	}
	}
	
	public String screenshot(WebDriver driver,String Screenshotname) throws IOException {
		
		TakesScreenshot tScreenshot=(TakesScreenshot)driver;
		File tempfile=tScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("./Screenshot/"+Screenshotname+".png");
		FileUtils.copyFile(tempfile, destinationFile);
		return destinationFile.getAbsolutePath();
	}
}
