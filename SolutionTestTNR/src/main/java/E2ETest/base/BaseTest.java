package E2ETest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import E2ETest.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseTest {
	
	public static  WebDriver driver;
	public static Properties prop;

	public  BaseTest() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("\\Users\\wajih\\eclipse-workspace\\FreeCRMTest\\src\\"
		+"\\main\\java\\com\\E2ETest\\config\\config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	
	public void initialization () {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "/Users/wajih/eclipse-workspace/"
//				+"/FreeCRMTest/driver/chrome/chromedriver.exe");
		driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
//			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecho.driver", "/Users/wajih/eclipse-workspace/SolutionTestTNR/Driver/Firefox/geckodriver.exe");
//			driver= new FirefoxDriver();
//			System.setProperty("webdriver.chrome.driver", "/Users/wajih/eclipse-workspace/"
//					+"/FreeCRMTest/driver/chrome/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		  driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
		    driver.get(prop.getProperty("url"));
	  }
	
	
	 public void getScreenshot(String result) throws IOException {  
		 File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrfile, new File("C://Users//wajih//Desktop//Nouveau dossier//" +result+"Screenshot.jpg"));
	     }
	
	
	
	
	
	
	 
}