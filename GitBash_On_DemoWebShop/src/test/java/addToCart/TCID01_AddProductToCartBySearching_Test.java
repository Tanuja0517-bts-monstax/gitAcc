package addToCart;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POMPages.HomePage;
import WD_JavaUtility.JavaUtility;
import baseUtility.BaseTest;
import genericUtilities.ListenerImplementation;
import genericUtilities.Reading_WritingDataFromExcelFile;

@Listeners(ListenerImplementation.class)
public class TCID01_AddProductToCartBySearching_Test extends BaseTest{
	HomePage hp;
	Reading_WritingDataFromExcelFile rwdfe;
	JavaUtility ju=new JavaUtility();
	@Test
	public void addProductToCart_Test() throws Exception, IOException {
		System.out.println("Entered in add product to cart method");
		if(driver.findElement(By.linkText("Log out")).isDisplayed())
			ListenerImplementation.test.log(Status.PASS, "successfully logged in");
			
		hp=new HomePage(driver);
		rwdfe=new Reading_WritingDataFromExcelFile();
		
		hp.getSearchTextArea().sendKeys(rwdfe.readingDataFromExcelFile("TC01", 1, 0));;
		hp.getSearchButton().click();
		
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		driver.findElement(By.xpath("//div[@class='overview']//input[@value='Add to cart']")).click();
		hp.getCart().click();
		System.out.println(rwdfe.readingDataFromExcelFile("TC01", 1, 1));
		if(rwdfe.readingDataFromExcelFile("TC01", 1, 1).equals("Blue and green Sneaker"))
			ListenerImplementation.test.log(Status.PASS, "Expected result and actual result match's");
		else
			ListenerImplementation.test.log(Status.FAIL, "Expected result and actual result doesn't match");
		
		Assert.assertEquals(rwdfe.readingDataFromExcelFile("TC01", 1, 1), "Blue and green Sneaker","*****Test case 01 FAIL*****");
		
		rwdfe.writeDataInExcelSheet("TC01", 1, 2, driver.findElement(By.xpath("//span[text()='Price:']/following-sibling::span")).getText());
		
		if(rwdfe.readingDataFromExcelFile("TC01", 1, 2).isEmpty())
			ListenerImplementation.test.log(Status.FAIL, rwdfe.readingDataFromExcelFile("TC01", 1, 2)+" Price not entered");
		else 
			ListenerImplementation.test.log(Status.PASS, rwdfe.readingDataFromExcelFile("TC01", 1, 2)+" Price entered");
	}
}
