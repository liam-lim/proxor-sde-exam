// StatsCsv.java -- add greatest values to spreadsheet
//
// This is NOT a working program. This is a "skeleton" that
// should be modified and extended to meet the specifications.

import com.csvreader.*;
import java.io.IOException;


public class StatsCsv {
    
    private static final int MAXROW = 16;
    private static final int MAXCOL = 16;
    private int rowsUsed = 0;
    private int colsUsed = 0;
    private static final String inFile = "Data01.csv";
    private static final String outFile = "Data02.csv"; 
   
    public String[][] sheet = new String[MAXROW][MAXCOL];
    
    public static void main(String[] args) throws IOException {

        StatsCsv a = new StatsCsv();
        a.readSheet();
        // a.getRows() is the row count before adding greatest values
        Stats s = new Stats(a.getRows(), a.getCols(), a.getData());
        a.setRows(a.getRows() + 1); // because we added a row of greatest values
        a.writeSheet();
        s.writeData(a.getRows(), a.getCols(), a.getData());
    }
    
    public void writeSheet() throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
        CsvWriter csvWriter = new CsvWriter(outFile);
        for(int r=0; r<rowsUsed; r++){
            for(int c=0; c<colsUsed; c++){
                csvWriter.write(sheet[r][c]);
            }
            csvWriter.endRecord();
        }
        csvWriter.close();
    }

    public void readSheet() throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
        CsvReader csvReader = new CsvReader(inFile);
        
        int counterRow = 0;
        int counterCol = 0;
        
        while(csvReader.readRecord()){
            counterCol = csvReader.getColumnCount();
            for(int i=0; i<counterCol; i++){
                sheet[counterRow][i] = csvReader.get(i);
            }
            counterRow++;
        }
        
        rowsUsed = counterRow;
        colsUsed = counterCol;
        
        csvReader.close();
        
        //System.out.println(rowsUsed);
        //System.out.println(colsUsed);
        
        /* Test instance var storing input data
        for(int r=0; r<sheet.length; r++){
            for(int c=0; c<sheet[0].length; c++){
                System.out.print(sheet[r][c] + ", ");
            }
            System.out.println();
        }
        */
            
    }

    public int getRows() {
    	return rowsUsed;
    }
    
    public int setRows(int r) {
        rowsUsed = r;
        return rowsUsed;
    }

    public int getCols() {
    	return colsUsed;
    }
    
    public String[][] getData() {
    	return sheet;
    }
}
