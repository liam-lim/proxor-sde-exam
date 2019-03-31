
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kyawhtetsoe
 */
public class Stats {
    
    private int rowUsed;
    private int colUsed;
    private String[][] sheet;
    
    public Stats(int getRow, int getCol, String[][] getData){
        rowUsed = getRow;
        colUsed = getCol;
        sheet = getData;
        greatestValues();
    }
    
    public void greatestValues(){
        int[] numArray = new int[colUsed-2];
        sheet[rowUsed][0] = "Greatest";
        sheet[rowUsed][1] = "Value";
        
        for(int c=2; c<colUsed; c++){
            for(int r=1; r<rowUsed; r++){
                numArray[r-1] = Integer.parseInt(sheet[r][c]);
            }
            
            Arrays.sort(numArray);
            int greatestVal = numArray[numArray.length-1];
            sheet[rowUsed][c] = String.valueOf(greatestVal);
            
            System.out.println(greatestVal);
        }
    }
    
    public void writeData(int getRow, int getCol, String[][] getData){
        
    }
}
