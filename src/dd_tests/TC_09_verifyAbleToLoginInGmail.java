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
import dd_util.Xls_Reader;

public class TC_09_verifyAbleToLoginInGmail extends testCore{
	

	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_09_verifyAbleToLoginInGmail"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		System.out.println("9th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		driver.get(object.getProperty("GmailSite"));
		System.out.println("Launched gmail WebPage");
		driver.findElement(By.xpath(object.getProperty("UsernameEditBox"))).sendKeys(username);
		clicked(driver.findElement(By.xpath(object.getProperty("usernameNext"))));
		driver.findElement(By.xpath(object.getProperty("passwordEditBox"))).sendKeys(password);
		clicked(driver.findElement(By.xpath(object.getProperty("passwordNext"))));	
	}
	
	@DataProvider
	public Object[][]getdata()
	{
		return TestUtil.getData("Login_Data",excel);
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
