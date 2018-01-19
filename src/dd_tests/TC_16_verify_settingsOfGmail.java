package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_16_verify_settingsOfGmail  extends testCore
{
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_16_verify_settingsOfGmail"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		try
		{
		System.out.println("16th Test case");
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		LoginToGmail(username,password);
		
		String result = (driver.findElement(By.xpath(object.getProperty("SettingsLabel"))).getText());
		System.out.println(result);
		Assert.assertEquals(result.contains("Settings"),true);
		{
			System.out.println("Label Settings is matching.");
		}
		System.out.println("Setting page Successfully opened:");
		}catch(Throwable t)
		{
			
		}
}

	@DataProvider
	public Object[][]getdata()
	{
		return TestUtil.getData("Login_Data",excel);
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		//driver.quit();
	}


}