package org.utilityPackage;

	import java.io.File;
import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.xssf.usermodel.*;

	public class ExcelUtils {

	    public  FileInputStream fi;
	    public  FileOutputStream fo;
	    public  XSSFWorkbook wb;
	    public  XSSFSheet ws;
	    public  XSSFRow row;
	    public  XSSFCell cell;
	    public  CellStyle style;
	    String path;
	    
	    public ExcelUtils(String path) {
			// TODO Auto-generated constructor stub
	    	this.path=path;
	    	
		}

	    // ✅ Get Row Count
	    public  int getRowCount( String xlsheet) throws IOException {
	        fi = new FileInputStream(path);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);

	        int rowcount = ws.getLastRowNum();

	        wb.close();
	        fi.close();

	        return rowcount;
	    }

	    // ✅ Get Cell Count
	    public  int getCellCount(String xlsheet, int rownum) throws IOException {
	        fi = new FileInputStream(path);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);

	        row = ws.getRow(rownum);
	        int cellcount = row.getLastCellNum();

	        wb.close();
	        fi.close();

	        return cellcount;
	    }

	    // ✅ Get Cell Data
	    public  String getCellData( String xlsheet, int rownum, int column ) throws IOException {
	        fi = new FileInputStream(path);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);

	        row = ws.getRow(rownum); 
	        cell = row.getCell(column); 

	        String data; 

	        try {
	            DataFormatter formatter = new DataFormatter();
	            data = formatter.formatCellValue(cell);
	        } catch (Exception e) {
	            data = "";
	        }

	        wb.close();
	        fi.close();

	        return data;
	    }

	    // ✅ Set Cell Data
	    public void setCellData(String sheetName, int rownum, int column, String data) throws IOException
	    {
	        File file = new File(path);

	        // If file not exists then create new file
	        if(!file.exists())
	        {
	            wb = new XSSFWorkbook();
	            fo = new FileOutputStream(path);
	            wb.write(fo);
	            fo.close();
	        }

	        fi = new FileInputStream(path);
	        wb = new XSSFWorkbook(fi);

	        // If sheet not exists then create new Sheet
	        if(wb.getSheetIndex(sheetName) == -1)
	        {
	            wb.createSheet(sheetName);
	        }

	        ws = wb.getSheet(sheetName);

	        // If row not exists then create new Row
	        if(ws.getRow(rownum) == null)
	        {
	            ws.createRow(rownum);
	        }

	        row = ws.getRow(rownum);

	        cell = row.createCell(column);
	        cell.setCellValue(data);

	        fo = new FileOutputStream(path);
	        wb.write(fo);

	        wb.close();
	        fi.close();
	        fo.close();
	    }

	    // ✅ Fill Green Color
	    public  void fillGreenColor( String xlsheet, int rownum, int column)
	            throws IOException {

	        fi = new FileInputStream(path);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);

	        row = ws.getRow(rownum);
	        cell = row.getCell(column);

	        style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(style);

	        fo = new FileOutputStream(path);
	        wb.write(fo);

	        wb.close();
	        fi.close();
	        fo.close();
	    }

	    // ✅ Fill Red Color
	    public  void fillRedColor( String xlsheet, int rownum, int column)
	            throws IOException {

	        fi = new FileInputStream(path);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);

	        row = ws.getRow(rownum);
	        cell = row.getCell(column);

	        style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(style);

	        fo = new FileOutputStream(path);
	        wb.write(fo);

	        wb.close();
	        fi.close();
	        fo.close();
	    }
	}


