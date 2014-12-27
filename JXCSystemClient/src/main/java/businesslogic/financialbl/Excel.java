package businesslogic.financialbl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;



public class Excel {
	
	public void output(String[][] inf,String place){
		
		try {	
			File excelFile = new File(place);
			if (!excelFile.exists()) {
				excelFile.createNewFile();
			} 
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    Workbook wb = new SXSSFWorkbook();      //创建一个文档  
	    Sheet sh = wb.createSheet();            //创建一个片 
	    
//	    sheet.setDefaultColumnWidth ((short)20); 
//	    sheet.setDefaultRowHeight((short)10);  
	    
	    int cellIndex = 0 ;  
        Row title = sh.createRow(0);    //创建一行  
        for(cellIndex=0;cellIndex<inf[0].length;cellIndex++){
        	title.createCell(cellIndex).setCellValue(inf[0][cellIndex]);
        }
  
  
        CellStyle style = wb.createCellStyle();     //单元格样式  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);           // 设置背景颜色模式  
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);  // 设置背景颜色  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);   
        Font font = wb.createFont();              
        font.setFontName("黑体");  
        font.setFontHeightInPoints((short) 13);//设置字体大小  
        style.setFont(font);    //设置字体  
        for (int i = 0; i < cellIndex ; i++) {  
            title.getCell(i).setCellStyle(style);  
            sh.setColumnWidth(i , 4000);        //设置列宽  
        } 
	    
        
        for (int i = 1; i < inf.length ; i++) {  
            Row row = sh.createRow(i);
            for(cellIndex = 0 ; cellIndex<inf[0].length;cellIndex++){  
            	row.createCell(cellIndex).setCellValue(inf[i][cellIndex]); 
            }
        }
        
        try  
        {
            FileOutputStream fout = new FileOutputStream(place);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
//            {   //入住日期(如果入住日期在今天之后， 显示为红色)  
//                Cell checkIn = row.createCell(cellIndex++);  
//                checkIn.setCellValue(obtainCellValue("orde.getInDate",orde));  
//                if(orde.getInDate().compareTo(new Date()) < 0 ){  
//                    CellStyle style = wb.createCellStyle();  
//                    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
//                    style.setFillForegroundColor(HSSFColor.TAN.index);  
//                    checkIn.setCellStyle(style);  
//                }  
         
	
	}
		
		
}
	
	
	
	

