package com.client.SalesInventory.ManageUnit;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.ManageUnitPage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class ManageUnitTest extends AdminBaseClass{
	ExcelUtility ex=new ExcelUtility();
	WebDriverUtility wb=new WebDriverUtility();
	@Test(groups="smoke")
	public void manageTest() throws EncryptedDocumentException, IOException {
		String unit = ex.getDataFromExcel("manageUnit", 1, 0);
		String details = ex.getDataFromExcel("manageUnit", 1, 1);
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.getAddUnit().click();
		mp.getUnitName().sendKeys(unit);
		mp.getUnitDetails().sendKeys(details);
		mp.getAddNewUnit().click();
		wb.handleAlert(driver);		
	}
	@Test(groups="smoke")
	public void manageUnitWithoutDetails() throws EncryptedDocumentException, IOException {
		String unit1 = ex.getDataFromExcel("manageUnit", 1, 0);		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.getAddUnit().click();
		mp.getUnitName().sendKeys(unit1);
		mp.getAddNewUnit().click();
		wb.handleAlert(driver);		
	}
	@Test(groups="smoke")
	public void deleteUnit() {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.getDeleteUnit().click();
		Actions ac=new Actions(driver);
		ac.scrollToElement(mp.getAddUnit()).scrollByAmount(0, 50).build().perform();
		mp.clickChechbox("mtr").click();
		mp.getDeleteUnit().click();
		wb.handleAlert(driver);	
	}
	
	@Test(dependsOnMethods = "manageTest")
	public void deleteAddedUnit() {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		ManageUnitPage mp=new ManageUnitPage(driver);
		Actions ac=new Actions(driver);
		ac.scrollToElement(mp.getAddUnit()).scrollByAmount(0, 50).build().perform();
		mp.clickChechbox("cm").click();
		mp.getDeleteUnit().click();
		wb.handleAlert(driver);
	}
	@Test(groups="smoke")
	public void editUnit() throws EncryptedDocumentException, IOException {
		String detail2 = ex.getDataFromExcel("manageUnit", 4, 1);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.editUnit1("pound").click();
		mp.getUnitDetails().clear();
		mp.getUnitDetails().sendKeys(detail2);
		mp.getUpdate().click();
		wb.handleAlert(driver);		
	}

}
