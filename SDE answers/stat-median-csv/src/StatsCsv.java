// StatsCsv.java -- add greatest values to spreadsheet
//
// This is NOT a working program. This is a "skeleton" that
// should be modified and extended to meet the specifications.

/*
when calling stats, statscsv pass sheet, and when
stats calculated median and added medians to getData, when
it comes back, sheet also have medians! both uses same var.


Don't forget to close reader and writer!

csvWrite.endRecord to do println

sheet is 16 x 16, rowsUsed and colsUsed are the real size!

don't change input data, otherwise Junit test will fail
*/

import java.io.IOException;
import com.csvreader.*;

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
        // a.getRows() is the row count before adding medians
        Stats s = new Stats(a.getRows(), a.getCols(), a.getData());
        a.setRows(a.getRows() + 1); // because we added a row of medians
        a.writeSheet();
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

    public void readSheet( ) throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
        CsvReader csvReader = new CsvReader(inFile);
        
        //csvReader.readHeaders();
        
        int row = 0;
        int col = 0;
        
        while(csvReader.readRecord()){
            String[] currentRow = csvReader.getValues();
            for(int i=0; i<currentRow.length; i++){
                sheet[row][i] = csvReader.get(i);
            }
            row++;
            col = csvReader.getColumnCount();
        }
        
        csvReader.close();
        
        rowsUsed = row;
        colsUsed = col;
//        
//        System.out.println(rowsUsed);
//        System.out.println(colsUsed);
//        
//        for(int i=0; i<sheet.length; i++){
//            for(int k=0; k<sheet[0].length; k++){
//                System.out.print(sheet[i][k] + ", ");
//            }
//            System.out.println();
//        }
    }

    public int getRows(){
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
