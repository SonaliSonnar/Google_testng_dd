package dd_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dd_util.TestConfig;
import dd_util.TestUtil;
import dd_util.Xls_Reader;
import dd_util.monitoringMail;

public class testCore {
	

/*
 * init methods will be responsible for Initilizing the Selenium server, 
 * Load properties, logs  and other files
 */
	
	public static Properties config  = new Properties();
	public static Properties object  = new Properties();
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;
	public static Logger app_logs =  Logger.getLogger("devpinoyLogger");
	public static String captionName;
	


	
	@BeforeSuite
	public static void init() throws IOException
	{
		
		if(driver==null)
		{
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\config.properties");
			config.load(fis);
			
			app_logs.debug("Loading the config properties file");
			
			//loading object property file
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\object.properties");
			object.load(fis);
			app_logs.debug("Loading the object properties file");
			
			excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\testdata1.xlsx");
			app_logs.debug("Loading the excel file");
	
		}
	}
	
	
    public int setup(String browser)throws Exception
    {

		
		if(browser.equalsIgnoreCase("Firefox"))	
		{
			
			System.setProperty("webdriver.gecko.driver","C:\\gecko\\geckodriver-v0.17.0-win32\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		
			driver = new FirefoxDriver();
			driver.get(config.getProperty("testsite"));
			
		}else if(browser.equalsIgnoreCase("ie"))
		{
			
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(config.getProperty("testsite"));
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(config.getProperty("testsite"));
			
		}
	
		driver.manage().timeouts().implicitlyWait(30L,TimeUnit.SECONDS);
		
	return 0;

}
		

	public boolean Enabled(String locator)
	{

		try
		{
			
		driver.findElement(By.xpath(locator)).isEnabled();
		captionName=(driver.findElement(By.xpath(locator))).getText();	
		System.out.println(captionName +":Element is Enabled");
		return  true;
		
		}catch(Throwable t)
		{
			System.out.println(locator+": Element is Disabled");
			//TestUtil.captureScreenshot();
		return false;
 	
		}
		
	
	}
	
	public void Comparestring(List<WebElement> Links)
	{

			String []linkText =new String[Links.size()];
			int j=0;

			//Storing List elements text into String array
			for(WebElement a: Links)
			{
				linkText[j]=a.getText();
				j++;
			}
			
			
			for(int i=0;i<linkText.length;i++)
			{
				
				if(linkText[i].contains("Abdul Kalam"))
		 		{
			 		
					System.out.println(Links.get(i).getText());	
		 		}
 		}
		
		//Thread.sleep(5000L);
	}

	
	

	public boolean clicked(WebElement button)
	{
		try
		{
			
			button.click();
			return  true;
			
		}catch(Throwable t)
	 	{
			
			System.out.println(" Element is Disabled");
			return false;
	 	}
	
	}
	
	

	public boolean selected(String locator)
	{
		try
		{
			
		driver.findElement(By.xpath(locator)).isSelected();
		captionName=(driver.findElement(By.xpath(locator))).getText();	
		System.out.println(captionName +":Element is selected");
		return  true;
		
		}catch(Throwable t)
		{
			System.out.println(locator+": Element is not selected");
			TestUtil.captureScreenshot();
		return false;
 	
		}
		
	}
	
	
	
	

	public boolean isElementPresent(String locator)
	{
	
		try
		{
			
		driver.findElement(By.xpath(locator)).isDisplayed();
		captionName=(driver.findElement(By.xpath(locator))).getText();	
			
		
		System.out.println(captionName +":Element is Present");
		return  true;
		
		}catch(Throwable t)
		{
			System.out.println(locator+": Element is Absent");
			TestUtil.captureScreenshot();
		return false;
 	
		}
		
	
			
	}
	
public void ActiveMember()
{
	clicked(driver.findElement(By.xpath(object.getProperty("AppsSignIn"))));
	System.out.println("Active Account Member is");
	System.out.println(driver.findElement(By.xpath(object.getProperty("ActiveAccountMember"))).getText());	
	
}

	
	
		@AfterSuite
		public static void QuitDriver() throws AddressException, MessagingException
		{
		
			
			driver.quit();
			/*
			monitoringMail mail = new monitoringMail();
			mail.sendMail(TestConfig.server,TestConfig.from , TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
			*/
		}
	
	
	
}
