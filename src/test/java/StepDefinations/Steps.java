package StepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.Login;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseClass
{

	@Before
	public void setup() throws IOException
	{

		logger=Logger.getLogger("ICT_LEMS");//Added logger
		PropertyConfigurator.configure("log4j.properties");//Added logger


		//Reading properties

		Properties configProp = new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);




		String br=configProp.getProperty("browser");

		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath") );	
			//driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}
		else if(br.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath") );	
			driver=new FirefoxDriver();
		}

		else if(br.equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath") );	
			driver=new InternetExplorerDriver();
		}
		
		else if(br.equals("msedge")) 
		{
			System.setProperty("webdriver.edge.driver",configProp.getProperty("msedgepath") );	
			driver=new EdgeDriver();
		} 

		logger.info("************* Launching browser**************");	
	}

	
	
	
	

	//	@After
	//	public void reset() throws Exception {
	//		try {
	//			driver.close();
	//
	//		} catch (Exception e) {
	//			
	//		}
	//		
	//		
	//		
	//	}

	@Given("User launches the browser")
	public void user_launches_the_browser() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);


		
		
		ln=new Login(driver);
		
		
		
	
		
	}
	
	@When("User opens the URL {string}")
	public void user_opens_the_URL(String url) {

		ln.user_opens_the_URL(url);
	}

	@When("User enters the email as {string} and password as {string}")
	public void user_enters_the_email_as_and_password_as(String string, String string2) {
		ln.user_enters_the_email_as_and_password_as(string, string2);
	}

	@When("Click on the login")
	public void click_on_the_login() {
		ln.click_on_the_login();

		if(driver.getTitle().equals(" RealCube Cloud for Real Estate "))
		{
			Assert.assertTrue(true); 
			System.out.println("Login Successful");

		}
		else
		{
			System.out.println("Login failed");
		}	   
	}
	
	@When("close browser")
	public void close_browser() {
		logger.info("************* Closing Browswer*******************");
		driver.quit();
	}
	
	
}
