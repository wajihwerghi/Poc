package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import E2ETest.base.BaseTest;
import E2ETest.page.LoginPage;
import E2ETest.page.HomePage;


public class LoginTest  extends BaseTest {
	LoginPage loginPage;
	HomePage  homePage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
	}
//	 un cas de test 1
	@Test(priority=1)
	public void loginPageTitleTest() {
		String Title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(Title, "S’identifier sur LinkedIn | LinkedIn");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
	 homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
