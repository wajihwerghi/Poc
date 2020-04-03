package E2ETest.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2ETest.base.BaseTest;

public class LoginPage extends BaseTest  {
	@FindBy(name="session_key")
	WebElement username;
	
	@FindBy(name="session_password")
	WebElement password;
	
	@FindBy(xpath="//button[@data-control-urn='login-submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@data-control-urn='login_join_now']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[@class='btn__tertiary--medium action__btn']")
	WebElement forgotYourPassword;
	
//	intialization the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	Actions
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	 public HomePage Login(String un, String pwd) throws InterruptedException {
		 username.sendKeys(un);
		 Thread.sleep(1000);
		 password.sendKeys(pwd);
		 Thread.sleep(1000);
		 loginBtn.click();
		 return new HomePage();
	 } 

}
