package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class LoginPage extends BaseClass {

	@FindBy(name="username")
	private WebElement uname ;
	
	@FindBy(name="password")
	private WebElement pass ;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginFunctionality(String username, String password)
	{
		Wait.sendKeys(uname, username);
		Wait.sendKeys(pass, password);
		
	}
	public void clickOnLoginButton()
	{
		Wait.click(loginButton);
		System.out.println("For GitHub Purpose adding Syso 1 Statement by SonaliKhalate");
	}
	
	
	
	
	
	
	
	
	
	
	
}
