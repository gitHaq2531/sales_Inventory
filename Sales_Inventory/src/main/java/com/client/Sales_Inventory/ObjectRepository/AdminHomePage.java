package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	WebDriver driver;
	public AdminHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='submit_button']")
	private WebElement logout;
	
	
	@FindBy(linkText = "Add Products")
	private WebElement addProduct;
	
	@FindBy(linkText = "Manage Unit")
	private WebElement manageUnit;
	
	
	@FindBy(linkText = "Manage Category")
	private WebElement manageCategory;
	
	
	@FindBy(linkText = "Products")
	private WebElement productList;
	
	
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getAddProduct() {
		return addProduct;
	}
	public WebElement getManageUnit() {
		return manageUnit;
	}

	public WebElement getManageCategory() {
		return manageCategory;
	}
	
	public WebElement getProductList() {
		return productList;
	}
	
	
	
	
	
	public void logOut() {
		logout.click();
	}

}
