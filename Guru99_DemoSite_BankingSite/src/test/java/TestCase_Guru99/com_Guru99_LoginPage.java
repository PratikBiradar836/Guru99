package TestCase_Guru99;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import PageObject_Guru99.com_Guru99_LoginPage_POM;
import Utilites_Guru99.com_ReadConfig_Guru99;
import io.qameta.allure.Description;

public class com_Guru99_LoginPage  extends com_BaseClass_Guru99{
	
com_ReadConfig_Guru99 rf ;
	@Test
	@Description("Check user able to Login")
	public void loginTest() throws IOException {
		com_Guru99_LoginPage_POM lp = new com_Guru99_LoginPage_POM(driver);

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

		System.out.println(driver.getTitle());

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			org.testng.Assert.assertTrue(true);

			logger.info("Login Test Pass");

		} else {
			org.testng.Assert.assertTrue(false);
			logger.info("Login test Fail");

		}
		
		captureScreen(driver, "Login");

	}


}
