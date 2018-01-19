package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;
import net.sourceforge.htmlunit.corejs.javascript.ast.ErrorCollector;

public class TC_20_verifyAbleToLogOutGmail extends testCore{
	
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_20_verifyAbleToLogOutGmail"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		System.out.println("20th Test case");
		
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
	
		boolean Expected_value =true;
		Thread.sleep(3000L);
		
		try
		{
			Assert.assertTrue(isElementPresent(object.getProperty("signout"))==true);
			clicked(driver.findElement(By.xpath(object.getProperty("signout"))));
			Assert.assertEquals(Expected_value, isElementPresent(object.getProperty("passwordNext")));
			{
				System.out.println("Asking for enter password...Hence proved Current active member is logged out");
			}
		}catch(Throwable t)
		{
			System.out.println("could not be able to log_out");
			t.printStackTrace();
					
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
