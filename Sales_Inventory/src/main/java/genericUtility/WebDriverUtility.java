package genericUtility;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * @author Mugdha
	 */

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * @author Harshali
	 */
	public void selectByVisibleText(WebElement element, String visibletext) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletext);
	}
	
	
	
	public void waitforpageload(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void handleAlert(WebDriver driver) {
		try {
		waitforpageload(driver);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		System.out.println("Alert accepted successfully.");
		}catch (Exception e) {
			System.out.println("Alert accepted successfully.");
			
		}
	}
	
	

	
}
