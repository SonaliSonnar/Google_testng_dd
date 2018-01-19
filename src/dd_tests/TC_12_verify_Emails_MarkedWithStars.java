package dd_tests;

import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_12_verify_Emails_MarkedWithStars extends testCore {
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_12_verify_Emails_MarkedWithStars"))
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
		System.out.println("12th Test case");
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		LoginToGmail(username,password);
		//html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[3]/td[1]/child::*
		//html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[3]/td[1]/child::*/img
		//String xp_first="html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr";
		
		int count=0;
		
		String xp_start="html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[";
		String xp_mid="]/td[";
		String xp_end="]/img";
		
		for(int i=2;i<=11;i++)
		{
			for(int j=1;j<2;j++)
			{
				try
				{
					//if(driver.findElement(By.xpath(xp_start+i+xp_mid+j+xp_end)).isDisplayed()&&driver.findElement(By.xpath(xp_start+i+xp_mid+j+xp_end)).isSelected())
					driver.findElement(By.xpath(xp_start+i+xp_mid+j+xp_end)).isEnabled();
					count++;
					System.out.println("Star mail:"+count);
					
				}catch(Throwable t)
				{
					//t.printStackTrace();
					//System.out.println("not a star mail");
				}
		           
			}
		}
		System.out.println(" Total Number of Starred mail in INBOX are: "+count);
		
		Thread.sleep(3000L);  
		}catch(Throwable t)
		{
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
