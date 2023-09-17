package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public 	XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fo;
	 String path; 
//	 Excel file-->Workbook--->Sheets---Rows--->Cells
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
public	int getRowCount(String sheetname) throws IOException
	{
		 fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		  int rowcount =  sheet.getLastRowNum();
		  workbook.close();
		  fi.close();
	     return rowcount ;	
	}
 public	int getCellCount (String sheetname,int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
		 sheet = workbook.getSheet(sheetname);	
	    row =sheet.getRow(rownum);
	     int  cellcount = row.getLastCellNum();
	     workbook.close();
		  fi.close();
	     return cellcount ;
}

 public String getCellData(String sheetname,int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);
	     sheet = workbook.getSheet(sheetname);	
	     row =sheet.getRow(rownum);
	     cell = row.getCell(cellnum);
		
		DataFormatter formatter = new DataFormatter();
		    String data;
			try {
				data = formatter.formatCellValue(cell);
			} catch (Exception e) {
				
				data="";
				}
		    workbook.close();
		    fi.close();
		    return  data;
		
	}
 
  public void setCellData(String sheetname,int rownum, int cellnum, String data) throws IOException
  {
	  File xfile = new File(path);
	  if(xfile.exists())
	  {
		  FileOutputStream fo = new  FileOutputStream (path);
		  workbook =new XSSFWorkbook();
		  workbook.write(fo);
	  }
	  fi = new FileInputStream(path);
	  workbook =new XSSFWorkbook(fi);
	  
	  if(workbook.getSheetIndex(sheetname)==-1)
		  workbook.createSheet(sheetname);
	  sheet=workbook.getSheet(sheetname);
	  
	  if(sheet.getRow(rownum)==null)
	  sheet.createRow(rownum);
	  row=sheet.getRow(rownum);
	  
	cell= row.createCell(cellnum);
	cell.setCellValue(data);
	fo = new  FileOutputStream (path);
	workbook.write(fo);
	workbook.close();
	fi.close();
	fo.close();
	  
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}