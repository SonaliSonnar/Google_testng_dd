package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_04_SignIn_in_allApps extends testCore{
	
	
	@BeforeTest
	public void isSkip() throws Exception{
		if(! TestUtil.isExecutable("TC_04_SignIn_in_allApps")){
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("Firefox");
	}
	
	@Test(dataProvider="getdata")
	public void SignIn_Apps  (String username,String password) throws InterruptedException
	{
		System.out.println("4th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);

		System.out.println("SignIn into Google");
		clicked(driver.findElement(By.xpath(object.getProperty("SignInButton"))));
		driver.findElement(By.xpath(object.getProperty("UsernameEditBox"))).sendKeys(username);
		clicked(driver.findElement(By.xpath(object.getProperty("usernameNext"))));
		driver.findElement(By.xpath(object.getProperty("passwordEditBox"))).sendKeys(password);
		clicked(driver.findElement(By.xpath(object.getProperty("passwordNext"))));
		
		System.out.println("playStore App WebPage");
		clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
		clicked(driver.findElement(By.xpath(object.getProperty("PlayStoreOption"))));
		ActiveMember();
		
		System.out.println("Gmail App WebPage");
		clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
		clicked(driver.findElement(By.xpath(object.getProperty("GmailOption"))));
		driver.navigate().back();
		ActiveMember();
		
		System.out.println("YouTube App WebPage");
		clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
		clicked(driver.findElement(By.xpath(object.getProperty("YoutubeOption"))));
		driver.navigate().back();
		ActiveMember();
		
		System.out.println("Google maps  App WebPage");
		clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
		clicked(driver.findElement(By.xpath(object.getProperty("MapsOption"))));
		ActiveMember();
		}
	
@DataProvider
public Object[][]getdata()
{
		return TestUtil.getData("Login_Data",excel);
			
}

	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}
}
