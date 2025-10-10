package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	
	public WebDriver driver;
	
	public RetailerHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="submit_button")
	private WebElement logOutBtn;
	
	@FindBy(linkText="New Order")
	private WebElement newOrderLink;
	
	@FindBy(linkText="Edit Profile")
	private WebElement editProfileLink;
	
	@FindBy(linkText="Home")
	private WebElement homeLink;
	
	@FindBy (linkText="Products")
	private WebElement productsLink;
	
	@FindBy (linkText = "My Orders")
	private WebElement myOrderesLink;
	
	@FindBy (linkText = "My Invoices")
	private WebElement myInvoicesLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getNewOrderLink() {
		return newOrderLink;
	}

	public WebElement getEditProfileLink() {
		return editProfileLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMyOrderesLink() {
		return myOrderesLink;
	}

	public WebElement getMyInvoicesLink() {
		return myInvoicesLink;
	}
	
	public void logOut() {
		logOutBtn.click();
	}

}
