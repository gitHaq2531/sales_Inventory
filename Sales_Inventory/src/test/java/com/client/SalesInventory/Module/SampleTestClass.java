package com.client.SalesInventory.Module;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.client.Sales_Inventory.BaseUtility.SuperBaseClass;
@Listeners(com.client.Sales_Inventory.ListenerUtility.ListenerImpClass.class)
public class SampleTestClass{

	@Test
	public void test() {
		Assert.fail();
	}
}
