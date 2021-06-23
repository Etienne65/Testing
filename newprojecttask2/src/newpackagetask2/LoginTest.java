package newpackagetask2;

import org.testng.Assert;
import org.w3c.dom.Element;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.testng.*;


public class LoginTest {
	
	private static final int Voda1234 = 0;
	//static WebDriver _driver;
	
	@Test
	public static void main(String[] args) {
		//Declaring and instantiation if object/variables
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver");
		ChromeDriver driver=new ChromeDriver();
		//Navigate to required URL
		driver.get("https://auth.epic.com.mt/ui/login");
		
		
		//Declaring the variables.
		int user = 99368021;
		int pass = Voda1234;
		//Locating and performing action on relevant elements				
        driver.findElement(By.id("username")).sendkeys(""+user);
		
		driver.findElement(By.id("password")).sendkeys(""+pass);
		
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		
			    	
		//Saving actual URL in a string value
		String actualUrl ="https://www.epic.com.mt/SSP/Epic-prepaid";
		//Expected URL can be found from the below method
		String expectedUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("URL matching" + actualUrl);
		//Checking could also be done with the following If else.
		/*if(actualUrl.equalsIgnoreCase(expectedUrl))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}*/
		
	}
	
	@SuppressWarnings("null")
	public void landingPageTest() {
		//Saving actual URL in a string value
		String actualUrl = "https://www.epic.com.mt/SSP/Epic-prepaid";
		WebDriver driver = null;
		//Asserting if URL is correct
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
		
		//Identify if required text elements are present
		boolean textFound = false;
		try {
			driver.findElement(By.xpath("//*[contains(text(),'My current balance is:')]"));
			textFound = true;
		}catch (Exception e) {
			textFound = false;
		}
		
		//Retrieve and store the Prepaid plan.
		WebElement Plan = driver.findElement(By.xpath("//*[contains(text(),'Youth Plan')]"));
		WebElement currentPlan = Plan.getText();
		
		//Retrieve and store the Prepaid plan.
		WebElement Number = driver.findElement(By.xpath("//div[contains(@class,'landing-number')]/h6"));
		WebElement Num = Number.getText();
	}
	
	@SuppressWarnings("null")
	@AfterClass
	public static void closeBrowserAndSelenium()
	{
		WebDriver driver = null;
		//Close the Browser Window
		driver.close();
		
		//Quit Selenium Session
		driver.close();
	}
	
}
