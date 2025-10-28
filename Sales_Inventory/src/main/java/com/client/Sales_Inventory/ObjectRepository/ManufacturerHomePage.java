package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	
	WebDriver driver;
	public ManufacturerHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//section[contains(.,'Welcome')]")
	private WebElement manufactrerWelcomeMsg;
	
	@FindBy(className="submit_button")
	private WebElement logoutBtn;
	
	@FindBy(linkText = "Orders")
	private WebElement ordersLink;
	
	@FindBy(linkText = "Manage Unit")
	private WebElement unit;
	
	

	public WebElement getUnit() {
		return unit;
	}

	public WebElement getOrdersLink() {
		return ordersLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getManufactrerWelcomeMsg() {
		return manufactrerWelcomeMsg;
	}
	
	public WebElement unitPresent(String unit) {
		return driver.findElement(By.xpath("//table[@class='table_displayData']//child::td[text()=' "+unit+" ']"));
		
	}

}
