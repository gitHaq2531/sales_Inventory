package com.client.Sales_Inventory.BaseUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.client.Sales_Inventory.ObjectRepository.LoginPage;
/**
 * @author Harshali
 */
import com.client.Sales_Inventory.ObjectRepository.RetailerHomePage;
public class RetailerBaseClass extends SuperBaseClass {
	
	@BeforeMethod
	public void configBeforeMethod() {
		LoginPage lp=new LoginPage(driver);
		lp.loginAsRetailerSamshop();
	}
	
	@AfterMethod
	public void configAfterMethod() {
		RetailerHomePage rhp=new RetailerHomePage(driver);
		rhp.logOut();
	}

}
