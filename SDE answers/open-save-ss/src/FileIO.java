// FileIOBase.java -- template for FileIO.java.
//
// this file should be modified to implement
// open, save, and save as... commands for SpreadSheet.java
// 
// Do not modify the signatures of these methods.


import com.csvreader.*;
import java.io.File;
import java.io.IOException;

public class FileIO {
    
    private static String[][] sheet;
    private static int usedRow;
    private static int usedCol;
     
    public static boolean open(SpreadSheet ss, File file) {
    	System.out.println("Open " + file);
        readFile(file, ss);
    	return true;
    }
	
    public static boolean saveAs(SpreadSheet ss, File file) {
    	System.out.println("SaveAs " + file);
        //ss.evaluate();
        readSheet(ss);
        writeSheet(file);
    	return true;
    }
    
    public static void readSheet(SpreadSheet ss){
        
        int maxRow = ss.maxRows;
        int maxCol = ss.maxCols;        
        
        sheet = new String[maxRow][maxCol];
        
        for(int r=0; r<maxRow; r++){
            
            
            for(int c=0; c<maxCol; c++){
                String cellFormula = ss.getCellFormula(r, c);
                String cellText = ss.getCellText(r, c);
                if(!cellFormula.isEmpty()){ // if cell formula exits 
                    sheet[r][c] = cellFormula;
                    if(usedRow < r+1) usedRow = r+1;
                    if(usedCol < c+1) usedCol = c+1;
                    System.out.println("r : " + r + "c : " + c);
                    
                }else if(!cellText.isEmpty()){ // if cell text exists
                    sheet[r][c] = ss.getCellText(r, c);
                    if(usedRow < r+1) usedRow = r+1;
                    if(usedCol < c+1) usedCol = c+1;
                    System.out.println("r : " + r + "c : " + c);
                }else{
                    sheet[r][c] = "";
                }
                
            }

        }
        
        for(int r=0; r<sheet.length; r++){
            for(int c=0; c<sheet[0].length; c++){
                System.out.print(sheet[r][c] + ",");
            }
            System.out.println();
        }
        
        System.out.println("usedRow " + usedRow);
        System.out.println("usedCol " + usedCol);
    }
    
    
    
    public static void writeSheet(File file){
        CsvWriter csvWriter = new CsvWriter(""+file);
        
        try{
            for(int r=0; r<usedRow; r++){
                for(int c=0; c<usedCol; c++){
                    csvWriter.write(sheet[r][c]);
                }
                csvWriter.endRecord();
            }
            csvWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void readFile(File file, SpreadSheet ss){
        try{
            CsvReader csvReader = new CsvReader(""+file);
            
            //SpreadSheet ss = new SpreadSheet("SpreadSheet");
            //ss.addComponentsToPane(ss.getContentPane());
            //ss.pack();
            //ss.setVisible(true);
            
            
            // following for loop > cleansing the previous opened file with empty string 
            int maxRow = ss.maxRows;
            int maxCol = ss.maxCols; 
            
            for(int r=0; r<maxRow; r++){
                for(int c=0; c<maxCol; c++){
                    ss.setCell(r, c, "");
                }
            }
            
            // Now filling data by reading the file
            int r = 0;
            while(csvReader.readRecord()){
                int columnCount = csvReader.getColumnCount();
                for(int c=0; c<columnCount; c++){
                    System.out.print(r + "," + c + " " + csvReader.get(c) + "| ");
                    ss.setCell(r, c, csvReader.get(c));
                    //ss.evaluate();
                }
                System.out.println();
                r++;
            }
            
            csvReader.close();
            ss.evaluate();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
