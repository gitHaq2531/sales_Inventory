package packagetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class A {
	@Test
public  void m1() throws EncryptedDocumentException, IOException {
	ExcelUtility eu = new ExcelUtility();
	String data = eu.getDataFromExcel("Sheet1", 1, 1);
	System.out.println(data);
	System.out.println("Added for feature branch");
}
}
