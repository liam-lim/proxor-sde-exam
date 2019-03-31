import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;

public class ReadFileWriteToConsole {
	
    private static final int MAXROW = 3;
    private static final int MAXCOL = 3;
    private static final String inFile = "in.csv";
	   
    public String[][] sheet = new String[MAXROW][MAXCOL];
	   
    public static void main(String args[]) throws IOException {
    	// create a ReadWriteToConsole object
        ReadFileWriteToConsole a = new ReadFileWriteToConsole();
    	//  Do not change the signature of this method.
    	// ... insert code here ...
        
        
    	// invoke readSheet()
        a.readSheet();
    	// ... insert code here ...
    	// invoke writeSheet()
        a.writeSheet();
    	// ... insert code here ...
    }	
	   
    public void readSheet() throws IOException {
        // ... insert code here ...
        //  Do not change the signature of this method.
        CsvReader csvReader = new CsvReader(inFile);
        int counter = 0;
        while(csvReader.readRecord()){
            for(int i=0; i<csvReader.getColumnCount(); i++){
                sheet[counter][i] = csvReader.get(i);
            }
            counter++;
        }
    }

    public void writeSheet(){
        // ... insert code here ...
        //  Do not change the signature of this method.
        for(int r=0; r<sheet.length; r++){
            for(int c=0; c<sheet[0].length; c++){
                System.out.print("[" + sheet[r][c] + "]");
            }
            System.out.println();
        }
    }
}
