package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle style;
	public  String path;
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public  int rowCount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
	  workbook=new XSSFWorkbook(fi);
	 sheet =workbook.getSheet(sheetname);
	  int rowCount=sheet.getLastRowNum();
	  workbook.close();
	  fi.close();
	  return rowCount;
	}
	public  int cellCount(String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		  workbook=new XSSFWorkbook(fi);
		 sheet =workbook.getSheet(sheetname);
		 int cellCount =sheet.getRow(rownum).getLastCellNum();
		  workbook.close();
		  fi.close();
		  return cellCount;
	}
	public  String getcellData(String sheetname, int rownum ,int column) throws IOException
	{
		fi=new FileInputStream(path);
		  workbook=new XSSFWorkbook(fi);
		 sheet =workbook.getSheet(sheetname);
		 row=sheet.getRow(rownum);
		cell =row.getCell(column);
		String data;
		try
		{
		//data=cell.toString();
			DataFormatter formatter=new DataFormatter();
			data=formatter.formatCellValue(cell);
			
		}
		catch (Exception e) {
		  data="";
		}
		 
		  workbook.close();
		  fi.close();
		  return data;
	}
     
	public  void setcellData (String sheetname,int rownum, int cellnum, String data) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(path);
		workbook.write(fo);
		 workbook.close();
		  fo.close();
	
	}
	public  void fillGreencolor(String sheetname,int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		}
	   
	public  void fillRedcolor(String sheetname,int rownum,int cellnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		}
	

	}


