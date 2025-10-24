package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUnitPage {
	WebDriver driver;
	public ManageUnitPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@value='+ Add Unit']")
	private WebElement addUnit;
	
	@FindBy(id="unitName")
	private WebElement unitName;
	
	@FindBy(id="unitDetails")
	private WebElement unitDetails;
	
	@FindBy(xpath="//input[@value='Add Unit']")
	private WebElement addNewUnit;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteUnit;
	
	@FindBy(xpath="//input[@value='Update Unit']")
	private WebElement update;
	
	public WebElement getAddUnit() {
		return addUnit;
	}

	public WebElement getUnitName() {
		return unitName;
	}

	public WebElement getUnitDetails() {
		return unitDetails;
	}

	public WebElement getAddNewUnit() {
		return addNewUnit;
	}

	public WebElement getDeleteUnit() {
		return deleteUnit;
	}
	
	
	public WebElement getUpdate() {
		return update;
	}

	public WebElement clickChechbox(String Unitname) {
		return driver.findElement(By.xpath("//table[@class='table_displayData']//td[text()=' "+Unitname+" ']/preceding-sibling::td/descendant::input"));
		
	}
	public WebElement editUnit1(String edit) {
		return driver.findElement(By.xpath("//table[@class='table_displayData']//td[text()=' "+edit+" ']/following-sibling::td/a"));
		
	}
	
	
	

}
