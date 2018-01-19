package rough;


import dd_core.testCore;
import dd_util.Xls_Reader;

public class testRunmode extends testCore {

	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\testdata1.xlsx");
	
	
	
	
	public static  boolean isExecutable()
	{
		for(int rownum=2;rownum<=excel.getRowCount("test_suite");rownum++)
		{
			if(excel.getCellData("test_suite","TCID", rownum).equals("verifyGoogle"))
			{
				if(excel.getCellData("test_suite","RunMode", rownum).equals("Y"))
				{
					return true;
				}
				else
				{
					return false;
				}
			
			}
			
		}
		return false;
	}
	
	
	public static void main(String [] args)
	{
		
		System.out.println(isExecutable());
	}

}



/*
String NumberOfMails = driver.findElement(By.xpath(object.getProperty("Inbox"))).getText();
int ReceivedMail = Integer.parseInt(NumberOfMails.replaceAll("[^0-9]+",""));
System.out.println("Total Number of mails received is "+ReceivedMail);
Thread.sleep(3000L);


int count= ReceivedMail/50;
int i=0;
System.out.println(count);
do{
		String range=(driver.findElement(By.xpath(object.getProperty("range"))).getText());
		System.out.println("Email upto "+range);
		clicked(driver.findElement(By.xpath(object.getProperty("older"))));
		Thread.sleep(1000L);
		i++;
  }while(i<=count);

System.out.println("range is near to reaceived mail(i.e):"+(driver.findElement(By.xpath(object.getProperty("range"))).getText()));
}*/