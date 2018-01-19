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

public class TC_15_verifySearchingOfEmails extends testCore{
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_15_verifySearchingOfEmails"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		System.out.println("15th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
		
			isElementPresent(object.getProperty("searchEmailTextBox"));
			driver.findElement(By.xpath(object.getProperty("searchEmailTextBox"))).sendKeys("Naukri Alerts");
			clicked(driver.findElement(By.xpath(object.getProperty("searchEmailButton"))));
			Thread.sleep(2000L);
			
			int rownum=0;
			String xp_start="html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[";
			String xp_end="]/td[2]";
			for(int row=1;row<=40;row++)
			{
				
				String result =(driver.findElement(By.xpath(xp_start+row+xp_end)).getText());
					
				rownum++;
				System.out.println(result);
				Assert.assertEquals(result.contains("Naukri"),true);
				{
					System.out.println("keyword naukri is matching.");
				}
			}
			
			System.out.println("Number of results from inbox are"+rownum);
			
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
