package TestCase_Guru99;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObject_Guru99.com_Guru99_AddNewCoustomer_POM;
import PageObject_Guru99.com_Guru99_LoginPage_POM;
import Utilites_Guru99.com_ReadConfig_Guru99;
import net.bytebuddy.utility.RandomString;

public class com_AddNewCoustomer extends com_BaseClass_Guru99 {

	com_ReadConfig_Guru99 rf;

	@Test
	public void addNewCoustomer_001() throws IOException {
		com_Guru99_LoginPage_POM lp = new com_Guru99_LoginPage_POM(driver);
		com_Guru99_AddNewCoustomer_POM anc = new com_Guru99_AddNewCoustomer_POM(driver);

		rf = new com_ReadConfig_Guru99(driver);

		driver.get(rf.getUrl());
		logger.info("Url pass");
		lp.setUsername(rf.getUser123());
		logger.info("Userid enterd");
		lp.setPassward(rf.getPassword123());
		logger.info("Password Enterd");
		lp.clickSubmit();

		logger.info("Click Submit");

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();

			driver.switchTo().defaultContent();

			org.testng.Assert.assertTrue(false);

			logger.warn("Login Fail");
		} else {
			org.testng.Assert.assertTrue(true);

			logger.warn("Login Pass");
		}

		anc.addNewCoustomer();

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept();

			driver.switchTo().defaultContent();

			org.testng.Assert.assertTrue(false);

			logger.warn("Ad Handle Sucessfully");
		} else {
			org.testng.Assert.assertTrue(true);

			logger.warn("Ad is Not Occured");
		}
		System.out.println("User reatch at Add new coustomer page");

		logger.info("Providing Coustomer Details");

		anc.setCustomerName(randomString());
		anc.setGenderM();
		anc.setDOB("14", "07", "2001");
		anc.setAddress(randomString());
		anc.setCity("pund");
		anc.setState("aksjdkabk");
		anc.setPin(123456);
		anc.setMobile("91"+randomNum());
		anc.setEmail(randomString()+"@gmail.com");
		anc.setPassword(randomString()+"@"+randomNum());
		anc.clickSubmit();
		
		captureScreen(driver, "AddNewCoustomer");
		
		driver.getTitle().contains("Customer Registered Successfully!!!");

	}

	

}
