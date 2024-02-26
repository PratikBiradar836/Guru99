package TestCase_Guru99;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class com_BaseClass_Guru99 {

	public static WebDriver driver;
	
	public static org.apache.log4j.Logger logger;
	public static ExtentTest logger1;

	public static ExtentReports extent;
    public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger = org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	}

	public static void scrollPage(WebDriver driver, int scrollAmount) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0])", scrollAmount);
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			System.out.println(e);
			return false;
		}

	}

	public static boolean isImageBroken(WebDriver driver, String Xpath) {
		WebElement imageElement = driver.findElement(By.xpath(Xpath));

		String imageURL = imageElement.getAttribute("src");
		try {
			BufferedImage imeage = ImageIO.read(new URL(imageURL));
			return (imeage == null);

		} catch (Exception e) {

			return true;
		}

	}
	
	public static String randomString() {
		String randomStr = RandomStringUtils.randomAlphabetic(8);
		return randomStr;
	}
	public static String randomNum() {
		String randomNum = RandomStringUtils.randomNumeric(4);
		return randomNum;
		
	}
	
	public static void captureScreen(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sorce =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Guru99_DemoSite_BankingSite/Screenshot"+tName+""+randomNum()+".png");
		FileUtils.copyFile(sorce, target);
		System.out.println("Taken Screenshot Sucessfully");
		
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
