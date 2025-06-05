package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws Exception
	{
		String path=".\\testdata\\LoginData.xlsx";
		ExcelUtility xlutility=new ExcelUtility(path);
		int rowCount=xlutility.rowCount("Sheet1");
		int colCount=xlutility.cellCount("Sheet1", 1);
		Object logindata[][]=new Object[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				logindata[i-1][j]=xlutility.getcellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

}
