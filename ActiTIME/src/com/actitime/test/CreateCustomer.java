package com.actitime.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TasksListPage;
@Listeners(com.actitime.generics.ListenersImplementation.class)
public class CreateCustomer extends BaseClass{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		String Etext = f.getExcelData("./data/testscriptdata.xlsx", "CreateCustomer", 1, 2);
		HomePage h=new HomePage(driver);
		h.clickOnTaskTab();
		TasksListPage t=new TasksListPage(driver);
		t.getAddNewCustomDD().click();
		t.getNewCustomerMenu().click();
		t.getEnterCustomerNameTbx().sendKeys(Etext);
		t.getSelectCustomerDD().click();
		t.getOurcompanyoption().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(3000);
		String AText = t.getActualText().getText();
		Assert.assertEquals(AText, Etext);
	}
}
