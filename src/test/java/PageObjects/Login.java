package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login 
{

	
	public WebDriver driver;
	public Login(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	
	
	public void user_opens_the_URL(String url) {
		driver.get(url);

	}


	public void user_enters_the_email_as_and_password_as(String string, String string2) {
	    driver.findElement(By.name("email")).sendKeys(string);
	    driver.findElement(By.name("password")).sendKeys(string2);

	    

	}

	public void click_on_the_login() {
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}

}
