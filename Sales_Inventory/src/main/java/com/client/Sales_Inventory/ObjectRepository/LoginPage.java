package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class LoginPage {
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="txtUsername")
	private WebElement usernameEdt;
	

	@FindBy(name="txtPassword")
	private WebElement passwordEdt;
	
	
	@FindBy(xpath="//div[@class='input-box']/descendant::option")
	private WebElement loginTypeOptions;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public void loginAsAdmin(String url,String username,String password) {
		System.out.println("Excute method");
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wb.select(loginTypeOptions, 4);
	    loginbtn.click();			
	}	
	public void loginAsRetailer(String username,String password) {
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wb.select(loginTypeOptions, 2);
		loginbtn.click();		
	}
	
	public void loginAsManufacturer(String username,String password) {
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		wb.select(loginTypeOptions, 3);
		loginbtn.click();
	}

}
