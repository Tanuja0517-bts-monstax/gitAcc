package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
	public WebDriver driver=null;
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement passw;
	
	@FindBy(name = "RememberMe")
	private WebElement rememberMe;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPwd;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassw() {
		return passw;
	}

	public WebElement getRememberMe() {
		return rememberMe;
	}

	public WebElement getForgotPwd() {
		return forgotPwd;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
}
