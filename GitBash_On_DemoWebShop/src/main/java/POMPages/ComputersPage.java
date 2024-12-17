package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputersPage extends HomePage {
	public WebDriver driver=null;
	public ComputersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//div[@class='item-box']//a[contains(text(),'Desktops')]")
	private WebElement desktop;
	
	@FindBy(xpath = "//div[@class='item-box']//a[contains(text(),'Notebooks')]")
	private WebElement notebook;
	
	@FindBy(xpath = "//div[@class='item-box']//a[contains(text(),'Accessories')]")
	private WebElement asscessories;
	public WebElement getDesktop() {
		return desktop;
	}

	public WebElement getNotebook() {
		return notebook;
	}

	public WebElement getAsscessories() {
		return asscessories;
	}
}
