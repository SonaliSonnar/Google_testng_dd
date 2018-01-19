package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_14_verify_WorkingOfCompose extends testCore{

	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_14_verify_WorkingOfCompose"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException, FindFailed
	{
		System.out.println("14th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
		
		clicked(driver.findElement(By.xpath(object.getProperty("composeMailButton"))));
		driver.findElement(By.xpath(object.getProperty("To"))).sendKeys("sonalisonnar@gmail.com");
		driver.findElement(By.xpath(object.getProperty("Subject"))).sendKeys("Reports");
		clicked(driver.findElement(By.xpath(object.getProperty("BrowseButton"))));
		attachDocument();
		
		
		Thread.sleep(3000L);
		
		
       
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
