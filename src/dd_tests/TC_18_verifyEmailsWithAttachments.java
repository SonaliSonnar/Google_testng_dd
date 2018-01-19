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
import net.sourceforge.htmlunit.corejs.javascript.ast.ErrorCollector;

public class TC_18_verifyEmailsWithAttachments extends testCore{

	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_18_verifyEmailsWithAttachments"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		try{
		System.out.println("18th Test case");
		
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
		
        int count=0;
       // html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/img
		String xp_start="html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[";
		String xp_mid="]/td[";
		String xp_end="]/img";
		
		for(int i=1;i<=5;i++)
		{
			for(int j=3;j<4;j++)
			{
				try
				{
					driver.findElement(By.xpath(xp_start+i+xp_mid+j+xp_end)).isDisplayed();
					count++;
					System.out.println("Mail With Attachments count is:"+count);
					
				}catch(Throwable t)
				{
					//t.printStackTrace();
					//System.out.println("not a star mail");
				}
		           
			}
		}
		System.out.println(" Total Number of mail with Attachments in INBOX are: "+count);
		
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
