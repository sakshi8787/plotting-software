package Utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Excel {

    public  static FileInputStream f ;
    public static Workbook wb;
    public static Sheet s;
    public static Row r;
    public static Cell c;

    public static int getRowCount(String xlfile, String sheet) throws IOException {
        f = new FileInputStream(xlfile);
      wb =  WorkbookFactory.create(f);
      s= wb.getSheet(sheet);
     int rowcount= s.getLastRowNum();

     wb.close();
     f.close();
     return rowcount;
    }
    public static int getCellCount(String xlfile , String Sheet, int rownum) throws IOException {
        f= new FileInputStream(xlfile);
        wb= WorkbookFactory.create(f);
        s = wb.getSheet(Sheet);
        r= s.getRow(rownum);
        int cellcount = r.getLastCellNum();
        return cellcount;
    }
    public static String getCellData(String xlfile ,String Sheet, int rownum, int cellnum) throws IOException {
        f= new FileInputStream(xlfile);
        wb= WorkbookFactory.create(f);
        s = wb.getSheet(Sheet);
        r= s.getRow(rownum);
        c=r.getCell(cellnum);
        String data;


        try {
            DataFormatter d  = new DataFormatter();
            String Data;
            Data= d.formatCellValue(c);
            return Data;

        }catch (Exception e){
            data= "";
        }
        wb.close();
        f.close();
        return data;

    }



}
