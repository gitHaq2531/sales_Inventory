package com.client.Sales_Inventory.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class OrderItemsPage {

	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	public OrderItemsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="7")
	private WebElement prodQnty7;
	
	@FindBy(id="totalPrice7")
	private WebElement prodPrice7;
	
	@FindBy(id="btnSubmit")
	private WebElement postOrderBtn;
	
	public WebElement getProdQnty7() {
		return prodQnty7;
	}

	public WebElement getProdPrice7() {
		return prodPrice7;
	}

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}
	public WebElement getProduct(int id) {
		WebElement prod=driver.findElement(By.xpath("//input[@id='"+id+"']//parent::td//parent::tr//td[2]"));
		return prod;
	}
	public WebElement getProduct() {
		WebElement prod=driver.findElement(By.xpath("//input[@id='7']//parent::td//parent::tr//td[2]"));
		return prod;
	}
	
	public void postSingleOrder(String id,String quantity) {
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+id+"]"));
		prodQnty.sendKeys(quantity);
		wLib.scroll(driver, 0,300);
		postOrderBtn.click();
	}
	
	public void postSingleProdOrder() throws EncryptedDocumentException, IOException {
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		ExcelUtility eLib=new ExcelUtility();
		String prodID=eLib.getDataFromExcel("Prod", 7, 1);
		String quantity=eLib.getDataFromExcel("Prod", 7, 2);
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+prodID+"]"));
		prodQnty.sendKeys(quantity);
		String product=getProduct(7).getText();
		wLib.scroll(driver, postOrderBtn);
		Actions act=new Actions(driver);
		act.scrollToElement(postOrderBtn).scrollByAmount(0, 100).perform();
		postOrderBtn.click();
	}
	
	public void postMultipleProdOrder() {
		
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		ExcelUtility eLib=new ExcelUtility();
	}

}
