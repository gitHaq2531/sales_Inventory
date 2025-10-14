package com.client.SalesInventory.Retailer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.RetailerBaseClass;
import com.client.Sales_Inventory.ObjectRepository.MyOrdersPage;
import com.client.Sales_Inventory.ObjectRepository.OrderDetailsPage;
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.JavaUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;
import com.client.Sales_Inventory.ObjectRepository.OrderItemsPage;

public class RetailerProfile extends RetailerBaseClass {
	
	@Test (groups="integration")
	public void verifyPostOrderDetailsInHomePage() throws EncryptedDocumentException, IOException {
		
		RetailerHomePage rhp=new RetailerHomePage(driver);
		OrderItemsPage oip=new OrderItemsPage(driver);
		OrderDetailsPage odp=new OrderDetailsPage(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		
		rhp.getNewOrderLink().click();
		ExcelUtility eLib=new ExcelUtility();
		String prodID=eLib.getDataFromExcel("Prod", 7, 1);
		String quantity=eLib.getDataFromExcel("Prod", 7, 2);
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+prodID+"]"));
		prodQnty.sendKeys(quantity);
		String product=oip.getProduct(7).getText();
		wLib.scroll(driver, oip.getPostOrderBtn());
		Actions act=new Actions(driver);
		act.scrollToElement(oip.getPostOrderBtn()).scrollByAmount(0, 100).perform();
		oip.getPostOrderBtn().click();
		rhp.getHomeLink().click();
		rhp.getDetailsOfRecentOrder();
		System.out.println(product);
		String actualProd=odp.getProducts().getText();
		System.out.println(actualProd);
		Assert.assertEquals(product, actualProd);
		
	}
	
	@Test (dependsOnMethods = "searchOrdersbyDate")
	public void verifyPostOrderInAdminOrders() throws EncryptedDocumentException, IOException {
		
		RetailerHomePage rhp=new RetailerHomePage(driver);
		OrderItemsPage oip=new OrderItemsPage(driver);
		OrderDetailsPage odp=new OrderDetailsPage(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		
		rhp.getNewOrderLink().click();
		ExcelUtility eLib=new ExcelUtility();
		String prodID=eLib.getDataFromExcel("Prod", 7, 1);
		String quantity=eLib.getDataFromExcel("Prod", 7, 2);
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+prodID+"]"));
		prodQnty.sendKeys(quantity);
		String product=oip.getProduct(7).getText();
		wLib.scroll(driver, oip.getPostOrderBtn());
		Actions act=new Actions(driver);
		act.scrollToElement(oip.getPostOrderBtn()).scrollByAmount(0, 100).perform();
		oip.getPostOrderBtn().click();
		rhp.getMyOrdersLink().click();
		searchOrdersbyDate();
		rhp.getDetailsOfRecentOrder();
		String actualProd=odp.getProducts().getText();
	}
	@Test
	public void searchOrdersbyDate() {
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		MyOrdersPage mop=new MyOrdersPage(driver);
		RetailerHomePage rhp=new RetailerHomePage(driver);
		
		rhp.getMyOrdersLink().click();
		wLib.select(mop.getSearchByDD(), "Date");
		String date=jLib.getSystemDateDDMMYYYY();
		mop.getDateTextEdt().sendKeys(date);
		mop.getSearchBtn().click();
	}
}
