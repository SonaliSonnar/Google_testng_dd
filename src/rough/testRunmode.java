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
