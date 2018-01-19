package dd_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_11_verify_Unread_mails extends testCore{
	
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_11_verify_Unread_mails"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		try{
			
		System.out.println("11th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
        int count=0;
       // html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[1]/td[3]/img
         List<WebElement> rowcount = driver.findElements(By.xpath("html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr"));
		String xp_start="html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/form/table[2]/tbody/tr[";
		String xp_mid="]/td[";
		String xp_end="]/b";
		for(int i=1;i<=rowcount.size();i++)
		{
			for(int j=2;j<3;j++)
			{
				try
				{
					String fontWeight =driver.findElement(By.xpath(xp_start+i+xp_mid+j+xp_end)).getCssValue("font-weight");
					
					 boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;
					if(isBold=true)
					{
					count++;
					}
					System.out.println("Unread Mail count is:"+count);
					
				}catch(Throwable t)
				{
					//t.printStackTrace();
					//System.out.println("not a star mail");
				}
		           
			}
		}
		System.out.println(" Total Number of unread mail in INBOX : "+count);
		
		Thread.sleep(3000L);  
		}catch(Throwable t)
		{
			t.printStackTrace();
		}
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
