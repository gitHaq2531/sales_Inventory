package com.client.Sales_Inventory.BaseUtility;

import org.testng.annotations.BeforeMethod;

import com.client.Sales_Inventory.ObjectRepository.LoginPage;

public class RetailerBaseClass extends SuperBaseClass {
	
	@BeforeMethod
	public void ConfigBM() {
		
		LoginPage lp=new LoginPage(driver);
		lp.loginAsRetailer("", browser);
		
	}

}
