package dd_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_06_Open_close_Browser extends testCore {
	@BeforeTest
	public void isSkip()
	{
		if(! TestUtil.isExecutable("TC_06_Open_close_Browser"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		
	}

	@Test
	public void LaunchBrowser() throws InterruptedException
	{
		System.out.println("6th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		System.out.println("Opening and Closing Browser");
		try
		{
			setup("chrome");
		} catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
