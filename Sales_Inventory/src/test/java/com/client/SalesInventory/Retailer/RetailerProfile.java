package com.client.SalesInventory.Retailer;

import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.RetailerBaseClass;
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
import com.client.Sales_Inventory.ObjectRepository.orderItemsPage;

public class RetailerProfile extends RetailerBaseClass {
	
	@Test (groups="system")
	public void verifyPostOrderInAdminOrders() {
		
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		orderItemsPage oip=new orderItemsPage(driver);
		oip.postOrder(7, "10");
		driver.navigate().back();
		rhp.getHomeLink().click();
		
	}
	
}
