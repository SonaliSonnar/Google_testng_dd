package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;
import net.sourceforge.htmlunit.corejs.javascript.ast.ErrorCollector;

public class TC_19_verify_LabelCreation extends testCore{


	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_19_verify_LabelCreation"))
		{
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("chrome");
	}

	@Test(dataProvider="getdata")
	public void LaunchGmail(String username,String password) throws InterruptedException
	{
		try{
		System.out.println("19th Test case");
		
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		LoginToGmail(username,password);
		
		clicked(driver.findElement(By.xpath(object.getProperty("Edit_label"))));
		driver.findElement(By.xpath(object.getProperty("create_label"))).sendKeys("Selenium");
		clicked(driver.findElement(By.xpath(object.getProperty("create_Button"))));
		
		String xp_start="html/body/table[2]/tbody/tr/td[1]/table[2]/tbody/tr/td/a[";
		String xp_end="]";
		String result=null;
		System.out.println("recently created label: ");
		
		for(int i=1;i<2;i++)
		{
			for(int j=1;j<2;j++)
			{
				
		          result =(driver.findElement(By.xpath(xp_start+i+xp_end)).getText());
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
