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

public class TC_13_verify_sendingMail extends testCore {

	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_13_verify_sendingMail"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException, FindFailed
	{
		
		try{
		System.out.println("13th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
		
		clicked(driver.findElement(By.xpath(object.getProperty("composeMailButton"))));
		driver.findElement(By.xpath(object.getProperty("To"))).sendKeys("sonalisonnar@gmail.com");
		driver.findElement(By.xpath(object.getProperty("Subject"))).sendKeys("Reports");
		clicked(driver.findElement(By.xpath(object.getProperty("BrowseButton"))));
		attachDocument();
		clicked(driver.findElement(By.xpath(object.getProperty("sendButton"))));
		System.out.println("sentMail Notification :"+driver.findElement(By.xpath(object.getProperty("sentMailNotification"))).getText());
		clicked(driver.findElement(By.xpath(object.getProperty("SentMailButton"))));	
		
		String xp_start="html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[";
		String xp_mid="]/td[";
		String xp_end="]";
		String result=null;
		System.out.println("Details of recently sent mail: ");
		
		for(int i=1;i<2;i++)
		{
			for(int j=1;j<=4;j++)
			{
				
		          result =(driver.findElement(By.xpath(xp_start+i+xp_mid+j+xp_end)).getText());
		          System.out.println(result);
					
			}
			
		}
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

