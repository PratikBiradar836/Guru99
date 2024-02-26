package PageObject_Guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class com_Guru99_AddNewCoustomer_POM {
	WebDriver rdriver;

	public com_Guru99_AddNewCoustomer_POM(WebDriver ldriver) {

		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement AddNewCoustomer;

	@FindBy(how = How.XPATH, using = "//*[@name='name']")
	@CacheLookup
	private WebElement customerName;

	@FindBy(how = How.XPATH, using = "//*[@value='m']")
	@CacheLookup
	private WebElement genderM;

	@FindBy(how = How.XPATH, using = "//*[@value='f']")
	@CacheLookup
	private WebElement genderF;

	@FindBy(xpath = "//*[@name='dob']")
	@CacheLookup
	private WebElement dateOFBirth;

	@FindBy(xpath = "//*[@name='addr']")
	@CacheLookup
	private WebElement address;

	@FindBy(xpath = "//*[@name='city']")
	@CacheLookup
	private WebElement city;

	@FindBy(xpath = "//*[@name='state']")
	@CacheLookup
	private WebElement state;

	@FindBy(xpath = "//*[@name='pinno']")
	@CacheLookup
	private WebElement pin;

	@FindBy(xpath = "//*[@name='telephoneno']")
	@CacheLookup
	private WebElement mobile;

	@FindBy(xpath = "//*[@name='emailid']")
	@CacheLookup
	private WebElement email;

	@FindBy(xpath = "//*[@name='password']")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//*[@name='sub']")
	@CacheLookup
	private WebElement Submit;

	// Setter methods for each WebElement

	public void addNewCoustomer() {
		AddNewCoustomer.click();
	}

	public void setCustomerName(String name) {
		customerName.sendKeys(name);
	}

	public WebElement setGenderM() {
		return genderM;
	}

	public WebElement setGenderF() {
		return genderF;
	}

	public void setDOB(String mm, String dd, String yy) {

		dateOFBirth.sendKeys(mm);
		dateOFBirth.sendKeys(dd);
		dateOFBirth.sendKeys(yy);
	}

	public void setAddress(String addressValue) {
		address.sendKeys(addressValue);
	}

	public void setCity(String cityValue) {
		city.sendKeys(cityValue);
	}

	public void setState(String stateValue) {
		state.sendKeys(stateValue);
	}

	public void setPin(int pinValue) {
		pin.sendKeys(String.valueOf(pinValue));
	}

	public void setMobile(String mobileValue) {
		mobile.sendKeys(mobileValue);
	}

	public void setEmail(String emailValue) {
		email.sendKeys(emailValue);
	}

	public void setPassword(String passwordValue) {
		password.sendKeys(passwordValue);
	}

	public void clickSubmit() {
		Submit.click();
	}
}
