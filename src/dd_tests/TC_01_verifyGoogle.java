package dd_tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_01_verifyGoogle extends testCore{
	
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_01_verifyGoogle")){
			throw new SkipException("Skipping test as runmode set to No");
		}
			setup("chrome");
		
	}
	
	
	@Test
	public void LaunchGoogleWebPage() throws InterruptedException
	{
		try{
			System.out.println("1st Test case");		
      driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
      app_logs.debug("Executing verify google testcase");
      
		//check searchButton is present and enabled
		isElementPresent(object.getProperty("GoogleSearchEditBox"));
		Enabled(object.getProperty("GoogleSearchEditBox"));
		
		//check searchButton is present and Enabled
		isElementPresent(object.getProperty("GoogleSearchButton"));
		 Enabled(object.getProperty("GoogleSearchButton"));
		 
		//check IAmFeelingLuckeyButton is present and enabled
		isElementPresent(object.getProperty("IAmFeelingLuckeyButton"));
		Enabled(object.getProperty("IAmFeelingLuckeyButton"));
		 
		 //check SignInButton is present and enabled or not
		 isElementPresent(object.getProperty("SignInButton"));
		 Enabled(object.getProperty("SignInButton"));
			 	
	}catch(Throwable t)
		{
		t.printStackTrace();
		//TestUtil.captureScreenshot();
		}
	}	
@AfterTest
public void closebrowser()
{
	driver.quit();
	
}
}
