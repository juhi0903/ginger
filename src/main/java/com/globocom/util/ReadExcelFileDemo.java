package com.globocom.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReadExcelFileDemo {
	
	public static void main(String args[]) throws IOException {
		readExcel("D:/gameUploadSheets/metadataformat.xlsx"); 
		
	}

public static void readExcel(String filepath) throws IOException{

	FileInputStream file = new FileInputStream(new File(filepath)); 
	XSSFWorkbook workbook = new XSSFWorkbook(file); 
	XSSFSheet sheet = workbook.getSheetAt(0); 
    Row row;
    for(int i=1; i<=sheet.getLastRowNum(); i++){  //points to the starting of excel i.e excel first row
        row = (Row) sheet.getRow(i);  //sheet number

            String title;
			if( row.getCell(0)==null) { title = "null"; }
            else title= row.getCell(0).toString();

               String link;
			if( row.getCell(1)==null) { link = "null";}  //suppose excel cell is empty then its set to 0 the variable
               else link = row.getCell(1).toString();   //else copies cell data to name variable

               String description;
			if( row.getCell(2)==null) { description = "null";   }
               else  description   = row.getCell(2).toString();
			
			String previewPath;
			if( row.getCell(3)==null) { previewPath = "null";   }
               else  previewPath   = row.getCell(3).toString();
			
	System.out.println("title:"+title+" name:"+link+" address:"+description+" previewPath:"+previewPath);
    }
	file.close();

}

}
