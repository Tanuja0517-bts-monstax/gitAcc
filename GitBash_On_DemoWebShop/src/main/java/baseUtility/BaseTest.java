package baseUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import WD_JavaUtility.JavaUtility;
import genericUtilities.ReadingDataFromPropertiesFile;

public class BaseTest {
	public WebDriver driver=null;
	public JavaUtility ju=new JavaUtility();
	public ReadingDataFromPropertiesFile read=new ReadingDataFromPropertiesFile();
	public static WebDriver sdriver=null;
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void itsBeforeSuite() {
		Reporter.log("Before Suite Started",true);
		String date=ju.getSystemDate();
	}
	
	@BeforeClass(groups = {"Smoke","Regression"})
	public void itsBeforeClass() {
		Reporter.log("Before Class Started",true);
	}
	
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void itsBeforeMethod() throws Exception {
		Reporter.log("Before Method Started",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(read.readDataFromFile("url"));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(read.readDataFromFile("un"));
		driver.findElement(By.id("Password")).sendKeys(read.readDataFromFile("pwd"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		sdriver=driver;
	}
	
	@AfterMethod(groups = {"Smoke","Regression"})
	public void itsAfterMethod() {
		Reporter.log("After Method Started",true);
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass(groups = {"Smoke","Regression"})
	public void itsAfterClass() {
		Reporter.log("After Class Started",true);
		driver.quit();
	}
	
	@AfterSuite(groups = {"Smoke","Regression"})
	public void itsAfterSuite() {
		Reporter.log("After Suite Started",true);
	}
}
