package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
	
	public WebDriver driver;
	public OrderDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProducts() {
		WebElement products=driver.findElement(By.xpath("//table[@class='table_invoiceFormat']//td[1]"));
		return products;
	}
	public WebElement getQuantity() {
		WebElement quantity=driver.findElement(By.xpath("//table[@class='table_invoiceFormat']//td[3]"));
		return quantity;
	}
}
