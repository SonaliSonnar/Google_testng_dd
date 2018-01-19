
package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_02_verifyGoogleApp extends testCore{
	
	

	 
	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_02_verifyGoogleApp"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
		setup("chrome");
	}

	@Test
	public void VerifyGoogleApps() throws InterruptedException
	{
		System.out.println("2nd Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		
		System.out.println("GoogleApps ");
		isElementPresent(object.getProperty("GoogleApps"));
		System.out.println("GoogleApps ");
		Enabled(object.getProperty("GoogleApps"));	
		clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));	
			
//MyAccountOption Option is present or not		
		System.out.println("MyAccountOption ");
		isElementPresent(object.getProperty("MyAccountOption"));
		System.out.println("MyAccountOption ");
		Enabled(object.getProperty("MyAccountOption"));
			
//Search Option is present or not		 
		isElementPresent(object.getProperty("SearchOption"));
		Enabled(object.getProperty("SearchOption"));
			
//Maps Option is present or not
		isElementPresent(object.getProperty("MapsOption"));
		Enabled(object.getProperty("MapsOption"));
							
 //YoutubeOption is present or not
	isElementPresent(object.getProperty("YoutubeOption"));
	 Enabled(object.getProperty("YoutubeOption"));
		
//PlayStoreOption is present or not
	 isElementPresent(object.getProperty("PlayStoreOption"));
	 Enabled(object.getProperty("PlayStoreOption"));
					
//NewsOption is present or not
	 isElementPresent(object.getProperty("NewsOption"));
	 Enabled(object.getProperty("NewsOption"));
	
//GmailOption is present or not
	 isElementPresent(object.getProperty("GmailOption"));
	 Enabled(object.getProperty("GmailOption"));
	 				
//DriveOption is present or not
	 isElementPresent(object.getProperty("DriveOption"));
	 Enabled(object.getProperty("DriveOption"));
	
//CalenderOption is present or not
	 isElementPresent(object.getProperty("CalenderOption"));
	 Enabled(object.getProperty("CalenderOption"));
		 
//Google+Option is present or not
	 isElementPresent(object.getProperty("Google+Option"));
	 Enabled(object.getProperty("Google+Option"));
	 	
//TranslateOption is present or not
	 isElementPresent(object.getProperty("TranslateOption"));
	 Enabled(object.getProperty("TranslateOption"));
	 		 		 
//PhotosOption is present or not
	 isElementPresent(object.getProperty("PhotosOption"));
	 Enabled(object.getProperty("PhotosOption"));	 		 	
}	
@AfterTest
public void teardown()
{
	driver.quit();
	
}
}
	
		
	

	
	


