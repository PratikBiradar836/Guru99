package PageObject_Guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class com_Guru99_LoginPage_POM {
	
	WebDriver rdriver ;
	
	public com_Guru99_LoginPage_POM(WebDriver ldriver) {
		
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//*[@name = 'uid']")
	@CacheLookup
	WebElement Uname;

	@FindBy(xpath = "//*[@name = 'password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//*[@name = 'btnLogin']")
	@CacheLookup
	WebElement Login;

	public WebElement setUsername(String Username) {
		Uname.sendKeys(Username);
		return Uname;
	}

	public void setPassward(String Passward) {
		password.sendKeys(Passward);

	}

	public void clickSubmit() {
		Login.click();
	}


}
