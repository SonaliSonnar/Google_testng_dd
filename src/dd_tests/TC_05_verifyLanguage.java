package dd_tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.testCore;
import dd_util.TestUtil;

public class TC_05_verifyLanguage extends testCore{

	@BeforeTest
	public void isSkip() throws Exception
	{
		if(! TestUtil.isExecutable("TC_05_verifyLanguage")){
			throw new SkipException("Skipping test as runmode set to No.,,,,,,,,");
		}
		setup("Firefox");
	}
	
	@Test
	public void Change_Language() throws InterruptedException
	{
		System.out.println("5th Test case");
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		clicked(driver.findElement(By.xpath(object.getProperty("Hindi"))));
		System.out.println(driver.findElement(By.xpath(object.getProperty("HindiSearchButton"))).getAttribute("value"));
		System.out.println(driver.findElement(By.xpath(object.getProperty("HindiLuckyButton"))).getAttribute("value"));
		
		
		
		WebElement allLanguage = driver.findElement(By.xpath(object.getProperty("LanguageList")));
		
		List<WebElement> lang = allLanguage.findElements(By.tagName("a"));
		System.out.println(lang.size());
		
		for(int i=0;i<lang.size();i++)
		{
			System.out.println(lang.get(i).getText());
		}
		
	}	 

	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}
}
