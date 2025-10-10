package genericUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * @author Harshali
	 */
	public void selectByVisibleText(WebElement element, String visibletext) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibletext);
	}

}
