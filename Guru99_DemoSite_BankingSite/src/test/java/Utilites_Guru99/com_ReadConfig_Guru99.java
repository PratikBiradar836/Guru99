package Utilites_Guru99;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class com_ReadConfig_Guru99 {

	public static Properties pro;
	WebDriver driver;

	public com_ReadConfig_Guru99(WebDriver driver) {

		File src = new File("E:\\Voot_App_Automation-master\\Guru99_DemoSite_BankingSite\\confugration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("The Excepttion is"+e);
		}

	}

	public String getUrl() {
		String url = pro.getProperty("Nurl");
		return url;
	}

	public String getUser123() {
		String user = pro.getProperty("User001");
		return user;
	}

	public String getPassword123() {
		String passward = pro.getProperty("password001");
		return passward;
	}

	/*
	 * public String getUserW1234() { String userW = pro.getProperty("UserW");
	 * return userW; }
	 * 
	 * public String getPasswordW1234() { String PasswordW =
	 * pro.getProperty("passwordW");
	 * 
	 * return PasswordW; }
	 */

}
