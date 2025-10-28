package com.client.SalesInventory.ManageUnit;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.client.Sales_Inventory.BaseUtility.AdminBaseClass;
import com.client.Sales_Inventory.ObjectRepository.AddProductPage;
import com.client.Sales_Inventory.ObjectRepository.AdminHomePage;
import com.client.Sales_Inventory.ObjectRepository.LoginPage;
import com.client.Sales_Inventory.ObjectRepository.ManageUnitPage;
import com.client.Sales_Inventory.ObjectRepository.ManufacturerHomePage;
import com.client.Sales_InventoryGenericUtility.ExcelUtility;
import com.client.Sales_InventoryGenericUtility.WebDriverUtility;

public class ManageUnitTest extends AdminBaseClass{
	ExcelUtility ex=new ExcelUtility();
	WebDriverUtility wb=new WebDriverUtility();
	@Test(groups="smoke")
	public void verifypage() {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		ManageUnitPage mp=new ManageUnitPage(driver);
		String text = mp.getTextPage().getText();
		assertEquals(text, "View Units");
		System.out.println("We have successfully reached on unit page");
	}
	@Test(groups="smoke")
	public void logout() {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.getLogout().click();
		System.out.println("Logout successfully");
		
	}
	
	@Test(groups="smoke")
	public void addUnit() throws EncryptedDocumentException, IOException {
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
	@Test(groups="system")
	public void verifingUnitInAddProduct() throws EncryptedDocumentException, IOException {
		String unit3=ex.getDataFromExcel("manageUnit", 6, 0);
		String details3=ex.getDataFromExcel("manageUnit", 6, 1);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.getAddUnit().click();
		mp.getUnitName().sendKeys(unit3);
		mp.getUnitDetails().sendKeys(details3);
		mp.getAddNewUnit().click();
		wb.handleAlert(driver);
		ahp.getAddProduct().click();
		AddProductPage app=new AddProductPage(driver);
		boolean flag=false;
		List<WebElement> ListOfUnit =app.getUnitList();
		for(WebElement newList:ListOfUnit) {
			String newList1 = newList.getText();
			if(newList1.contains(unit3)) {
				flag=true;
				break;
			}
		}
		assertEquals(flag, true);
		System.out.println("Unit has been added successfully");	
	}
	
	@Test(groups="system")
	public void verifingUnitInManufacturer() throws EncryptedDocumentException, IOException {
		String unit4=ex.getDataFromExcel("manageUnit", 7, 0);
		String details4=ex.getDataFromExcel("manageUnit", 7, 1);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getManageUnit().click();
		ManageUnitPage mp=new ManageUnitPage(driver);
		mp.getAddUnit().click();
		mp.getUnitName().sendKeys(unit4);
		mp.getUnitDetails().sendKeys(details4);
		mp.getAddNewUnit().click();
		wb.handleAlert(driver);
		mp.getLogout().click();
		LoginPage lp=new LoginPage(driver);
		lp.loginAsManufacturer("pavan05", "manager");
		ManufacturerHomePage mhp=new ManufacturerHomePage(driver);
		mhp.getUnit().click();
	    String text = mhp.unitPresent(unit4).getText();
		assertEquals(text, unit4);
		System.out.println("Unit added successfully");	
		
	}
	
	public void unitWithoutdetails() {
		
		
		
		
		
		
		
		
		
	}
}
