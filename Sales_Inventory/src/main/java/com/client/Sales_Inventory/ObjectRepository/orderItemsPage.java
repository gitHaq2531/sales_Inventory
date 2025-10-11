package com.client.Sales_Inventory.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderItemsPage {

	WebDriver driver;
	public orderItemsPage(WebDriver driver) {
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
	
	public void postOrder(int id,String quantity) {
		WebElement prodQnty=driver.findElement(By.xpath("//input[@class='quantity' and @id="+id+"]"));
		prodQnty.sendKeys(quantity);
		postOrderBtn.click();
	}
}
