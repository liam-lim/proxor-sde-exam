
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
    
    private int getRow;
    private int getCol;
    private String[][] getData;
    private int row;
    private int col;
    public String[][] sheet;
    
    public Stats(int getRow, int getCol, String[][] getData){
        this.getRow = getRow;
        this.getCol = getCol;
        this.getData = getData;
        
        //to get real size, dont want extrraaas nullll
        row = getRow-1;
        col = getCol-2;
        
        sheet = new String[row][col];
        computeMedians();
    }
    
    public void computeMedians(){
      

        for(int r=0; r<row; r++){
           for(int c=0; c<col; c++){
               sheet[r][c] = getData[r+1][c+2];
           }
        }
        
        
        //for median first name & second name
        getData[getRow][0] = "";
        getData[getRow][1] = "Median";
        
        
        //looping structure notice!! not c after r, r after c! 
        //to make easier to put data into numArray
        for(int c=0; c<sheet[0].length; c++){           
            
            //using numArray and Arrays.sort to sort ascending order
            int[] numArray = new int[sheet.length];
            double median = 0;
            
            for(int r=0; r<sheet.length; r++){

                numArray[r] = Integer.parseInt(sheet[r][c]);
                System.out.print("numArray[" + c + "] = " + numArray[c] + "  ");

            }
            
            System.out.print("  Before sorting > ");
            for(int i=0; i<numArray.length; i++){
                System.out.print(numArray[i] + ", ");
            }
            
            Arrays.sort(numArray);
            
            System.out.print("  After sorting > ");
            for(int i=0; i<numArray.length; i++){
                System.out.print(numArray[i] + ", ");
            }
            
            
            //if is even
            if(numArray.length % 2 == 0){
                median =  Math.ceil((double)(numArray[numArray.length/2] + numArray[numArray.length/2 - 1])/2) ;
            }
            else{
                median =  Math.ceil((double)numArray[numArray.length/2]);
            }
            
            System.out.print(" median : " + (int)median);
 
            System.out.println();
            getData[getRow][c+2] = String.valueOf((int)median);
            
               
        }
        
       /* 
        
        for(int i=0; i<sheet.length; i++){
            for(int k=0; k<sheet[0].length; k++){
                System.out.print(sheet[i][k] + ", ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        for(int i=0; i<sheetMedian.length; i++){
            for(int k=0; k<sheetMedian[0].length; k++){
                System.out.print(sheetMedian[i][k] + ", ");
            }
            System.out.println();
        } */
        
    }
    
}
