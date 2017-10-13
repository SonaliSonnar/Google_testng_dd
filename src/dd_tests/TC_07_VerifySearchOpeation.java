package dd_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_07_VerifySearchOpeation extends testCore{
	

	@BeforeTest
	public void isSkip() throws Exception{
		if(! TestUtil.isExecutable("TC_07_VerifySearchOpeation")){
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("Firefox");
	}

	@Test(dataProvider="getdata")
	public void verifyLinkContainText(String name) throws InterruptedException 
	
	{
		System.out.println("7th Test case");
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		System.out.println(" verification of search operation");
		System.out.println("SearchOption ");
		isElementPresent(object.getProperty("SearchOption"));
		System.out.println("SearchOption ");
		Enabled(object.getProperty("SearchOption"));
		clicked(driver.findElement(By.xpath(object.getProperty("SearchOption"))));

		 	driver.findElement(By.xpath(object.getProperty("GoogleSearchEditBox"))).sendKeys(name);
	 		clicked(driver.findElement(By.xpath(object.getProperty("GoogleSearchButton"))));
	 		WebElement Block =driver.findElement(By.xpath(object.getProperty("BlockOfLinks")));
	 		List<WebElement> Links=Block.findElements(By.tagName("a"));
	 		System.out.println(Links.size());
	 		Comparestring(Links);
	 		
	}	
@DataProvider
public Object[][]getdata()
{
	return TestUtil.getData("Search_Data",excel);
	
}
@AfterTest
public void closeBrowser()
{
	driver.quit();
}
}
