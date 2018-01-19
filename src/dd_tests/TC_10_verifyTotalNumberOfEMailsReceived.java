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

public class TC_10_verifyTotalNumberOfEMailsReceived extends testCore{
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_10_verifyTotalNumberOfEMailsReceived"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		try{
		System.out.println("10th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
		/*driver.get(object.getProperty("GmailSite"));
		System.out.println("Launched gmail WebPage");
		driver.findElement(By.xpath(object.getProperty("UsernameEditBox"))).sendKeys(username);
		clicked(driver.findElement(By.xpath(object.getProperty("usernameNext"))));
		driver.findElement(By.xpath(object.getProperty("passwordEditBox"))).sendKeys(password);
		clicked(driver.findElement(By.xpath(object.getProperty("passwordNext"))));
		Thread.sleep(3000L);
	*/	
		clicked(driver.findElement(By.xpath(object.getProperty("SelectAllMails"))));
		Thread.sleep(1000L);
		

		String expected1=(driver.findElement(By.xpath(object.getProperty("TotalNoOfSelectedMails"))).getText());
		String actual1=(driver.findElement(By.xpath(object.getProperty("TotalNumberOfInboxMails"))).getText());
		
		ComapareMailCount(expected1,actual1);
		
		}catch(Throwable t)
		{
			t.printStackTrace();
		}
	}	
	@DataProvider
	public Object[][]getdata()
	{
		return TestUtil.getData("Sheet4",excel);
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		//driver.quit();
	}

}
