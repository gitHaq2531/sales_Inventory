package genericUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

}
