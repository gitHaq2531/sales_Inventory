package com.client.SalesInventory.Module;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.RetailerBaseClass;
import com.client.Sales_Inventory.ObjectRepository.OrderItemsPage;
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class SampleTestClass extends RetailerBaseClass{

	@Test
	public void test() {
	
	OrderItemsPage oip=new OrderItemsPage(driver);
	RetailerHomePage rhp=new RetailerHomePage(driver);
	rhp.getNewOrderLink().click();
	System.out.println(oip.getPrice().getText());
}
}
