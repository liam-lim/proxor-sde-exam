import com.csvreader.CsvReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadFileWriteToConsole {

    private static final String inFile = "in.csv";
    ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();


    public static void main(String args[]) throws IOException {
        // (add code to implement the following)
        // create a ReadFileWriteToConsole object
        // call method below to read the data from inFile
        // call method below to write the data to the console
        // Do not change the signature of this method.

        ReadFileWriteToConsole readFileWriteToConsole = new ReadFileWriteToConsole();
        readFileWriteToConsole.makeSheet();
        readFileWriteToConsole.writeSheet();

        return;
    }

    public String getCell(int row, int col) {
        // return the value of the spreadsheet at the given row and column
        // Do not change the signature of this method.
        return lines.get(row).get(col);
    }

    public int getRowCount() {
        // return the number of rows in the spreadsheet
        // Do not change the signature of this method.
        return lines.size();
    }

    public int getColCount() {
        // return the number of columns in row
        // Do not change the signature of this method.
        if (lines.size() > 0) {
            return lines.get(0).size();
        }
        return 0;
    }

    public void makeSheet() throws IOException {
        // read the data from inFile
        // Do not change the signature of this method.
        CsvReader csvReader = new CsvReader(inFile, ',');
        while (csvReader.readRecord()) {
            int columnCount = csvReader.getColumnCount();
            ArrayList<String> line = new ArrayList<String>();
            for (int i = 0; i < columnCount; i++) {
                String value = csvReader.get(i);
                line.add(value);
            }
            lines.add(line);
        }
        csvReader.close();
    }

    public void writeSheet() {
        // format data to console
        // Do not change the signature of this method.
        for (ArrayList<String> line : lines) {
            for (String word : line) {
                System.out.print("[" + word + "]");
            }
            System.out.println();
        }
    }
}