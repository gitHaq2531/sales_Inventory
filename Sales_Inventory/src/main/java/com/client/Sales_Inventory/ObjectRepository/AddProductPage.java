package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class AddProductPage {
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver;
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="product:name")
	private WebElement productName;
	
	@FindBy(id="product:price")
	private WebElement price;
	
	@FindBy(id="product:unit")
	private WebElement unitType;
	
	@FindBy(id="product:category")
	private WebElement Pcategory;
		
	@FindBy(xpath="//input[@value='1']")
	private WebElement enable;
	
	@FindBy(xpath="//input[@value='2']")
	private WebElement disable;
	
	@FindBy(id="product:description")
	private WebElement description;
	
	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement add;
	
	
	public WebElement getUnitType() {
		return unitType;
	}
	public WebElement getPcategory() {
		return Pcategory;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getEnable() {
		return enable;
	}

	public WebElement getDisable() {
		return disable;
	}
	
	
	public void selectEnable() {
		enable.click();
	}
				
	public void selectDisable() {
		disable.click();
	}
	
	public void selectUnit(String unit) {
		wb.select(unitType, unit);
	}
	
	public void selectCategory(String category) {
		wb.select(Pcategory, category);
	}
	
	public void clickAddproduct() {
		getAdd().click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
