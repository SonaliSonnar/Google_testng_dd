package dd_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_03_verifyGoogleAppLaunch extends testCore {
	
	
	@BeforeSuite
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_03_verifyGoogleAppLaunch"))
		{
			throw new SkipException("Skipping test as runmode set to No");
		}
		setup("chrome");
	}

	@Test
	public void verifyGoogleAppLaunching() throws InterruptedException
	{
		System.out.println("3rd Test case");
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
clicked(driver.findElement(By.xpath(object.getProperty("MyAccountOption"))));
isElementPresent(object.getProperty("MyAccountAppTitle"));
System.out.println("Title of My account App is :"+driver.getTitle());
driver.navigate().back();

//SearchApp Launch Successfully or not
System.out.println("SearchOption ");
isElementPresent(object.getProperty("SearchOption"));
System.out.println("SearchOption ");
Enabled(object.getProperty("SearchOption"));
clicked(driver.findElement(By.xpath(object.getProperty("SearchOption"))));
if(isElementPresent(object.getProperty("GoogleSearchEditBox"))==true&&isElementPresent(object.getProperty("GoogleSearchButton"))==true)
{	
   System.out.println("Google Search app Successfully launched");
}								
//driver.navigate().back();


//Maps Option is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("MapsOption"));
Enabled(object.getProperty("MapsOption"));
clicked(driver.findElement(By.xpath(object.getProperty("MapsOption"))));

if(isElementPresent(object.getProperty("Directions"))==true&&Enabled(object.getProperty("Directions"))==true)
{	
	System.out.println("Directions arrow is present hence MappApp page launch successfully ");
	driver.navigate().back();
}

				
//YoutubeApp WebPage is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("YoutubeOption"));
Enabled(object.getProperty("YoutubeOption"));
clicked(driver.findElement(By.xpath(object.getProperty("YoutubeOption"))));
if(isElementPresent(object.getProperty("YoutubeUploadButton"))==true)
{	
	System.out.println("YoutubeUploadButton is present hence youtubeApp page launch successfully ");
}								
driver.navigate().back();


//PlayStoreOption is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("PlayStoreOption"));
Enabled(object.getProperty("PlayStoreOption"));
clicked(driver.findElement(By.xpath(object.getProperty("PlayStoreOption"))));

if(isElementPresent(object.getProperty("PlayStoreSearchBox"))==true&&isElementPresent(object.getProperty("PlayStoreLogo"))==true)
{	
	System.out.println("PlayStoreLogo and PlayStoreSearchBox is present hence PlayStoreApp page launch successfully ");
 }								
driver.navigate().back();
	

//NewsOption is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("NewsOption"));
Enabled(object.getProperty("NewsOption"));
clicked(driver.findElement(By.xpath(object.getProperty("NewsOption"))));

if(isElementPresent(object.getProperty("NewsLogo"))==true&&isElementPresent(object.getProperty("TopStories"))==true)
{	
	System.out.println("NewsLogo  is present hence NewsApp page launch successfully ");
}								
driver.navigate().back();
			


//GmailOption is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("GmailOption"));
Enabled(object.getProperty("GmailOption"));
clicked(driver.findElement(By.xpath(object.getProperty("GmailOption"))));

if(isElementPresent(object.getProperty("GmailLogo"))==true&&isElementPresent(object.getProperty("SignIn"))==true)
{	
	System.out.println("GmailLogo and SignInButton is present hence GmailApp page launch successfully ");
}								
driver.navigate().back();


//DriveOption is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("DriveOption"));
Enabled(object.getProperty("DriveOption"));
clicked(driver.findElement(By.xpath(object.getProperty("DriveOption"))));

if(isElementPresent(object.getProperty("GoogleDriveTitle"))==true&&isElementPresent(object.getProperty("GoToGoogleDriveButton"))==true)
{	
	System.out.println("GoogleDriveTitle  And GoToGoogleDriveButton is present hence GoogleDriveApp page launch successfully ");
}								
driver.navigate().back();


//TranslateOption is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("TranslateOption"));
Enabled(object.getProperty("TranslateOption"));
clicked(driver.findElement(By.xpath(object.getProperty("TranslateOption"))));

if(isElementPresent(object.getProperty("TranslateLabel"))==true&&isElementPresent(object.getProperty("TranslateButton"))==true)
{	
	System.out.println("TranslateLabel And TranslateButton is present hence TranslateApp page launch successfully ");
}								
driver.navigate().back();


//PhotosOption is present or not
clicked(driver.findElement(By.xpath(object.getProperty("GoogleApps"))));
isElementPresent(object.getProperty("PhotosOption"));
Enabled(object.getProperty("PhotosOption"));
clicked(driver.findElement(By.xpath(object.getProperty("PhotosOption"))));

if(isElementPresent(object.getProperty("GooglePhotosLogo"))==true&&isElementPresent(object.getProperty("GoToGooglePhotosButton"))==true)
{	
	System.out.println("GooglePhotosLogo And GoToGooglePhotosButton is present hence PhotosApp page launch successfully ");
}								
driver.navigate().back();

}
	
@AfterTest
public void teardown()
{
	driver.quit();
	
}
}