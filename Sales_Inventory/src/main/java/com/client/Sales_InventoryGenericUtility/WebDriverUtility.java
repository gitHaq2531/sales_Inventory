package com.client.Sales_InventoryGenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * @author Harshali
	 */
	public void select(WebElement element, String visibletext) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletext);
	}
	public void scroll(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).build().perform();
	}
	public void scroll(WebDriver driver, int x,int y) {
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).build().perform();
	}
	
	
	
	public void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	
	
}
