package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver=null;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(linkText = "BOOKS")
	private WebElement books;
	
	@FindBy(linkText = "COMPUTERS")
	private WebElement comps;
	
	@FindBy(linkText = "ELECTRONICS")
	private WebElement elec;
	
	@FindBy(linkText = "APPAREL & SHOES")
	private WebElement app_shoes;
	
	@FindBy(linkText = "DIGITAL DOWNLOADS")
	private WebElement digitalDwn;
	
	@FindBy(linkText = "JEWELRY")
	private WebElement jewelry;
	
	@FindBy(linkText = "GIFT CARD")
	private WebElement giftcard;
	
	@FindBy(linkText = "Register")
	private WebElement register;
	
	@FindBy(linkText = "Log in")
	private WebElement login;
	
	@FindBy(xpath = "//span[text()='Shopping cart']/..")
	private WebElement cart;
	
	@FindBy(xpath = "//span[text()='Wishlist']/..")
	private WebElement wishlist;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchTextArea;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;

	public WebElement getBooks() {
		return books;
	}

	public WebElement getComps() {
		return comps;
	}

	public WebElement getElec() {
		return elec;
	}

	public WebElement getApp_shoes() {
		return app_shoes;
	}

	public WebElement getDigitalDwn() {
		return digitalDwn;
	}

	public WebElement getJewelry() {
		return jewelry;
	}

	public WebElement getGiftcard() {
		return giftcard;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getWishlist() {
		return wishlist;
	}

	public WebElement getSearchTextArea() {
		return searchTextArea;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
