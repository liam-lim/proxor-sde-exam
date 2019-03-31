import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Vector;

import com.csvreader.*;

public class WriteHtml {
    public static final String inFileName = "input.csv";
    public static final String outFileName = "output.html";

    public static void main(String[] args) {
        // ... insert code here ...
    	//  Do not change the signature of this method.
        
        //counter for the longest row
        int counter = 0;
        
        //for escaping special characters
        EscapeHTML escape = new EscapeHTML();
        
        try{
            //reader is for reading first time to determine longest row
            CsvReader reader = new CsvReader(inFileName);
            
            //reader2 is for writing to the output file
            CsvReader reader2 = new CsvReader(inFileName);
            
            //don't use csvWriter, use bufferedWriter to write
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
            
            //initial HTML format
            writer.write("<html>\n\t"
                    + "<head>\n\t\t"
                    + "<title>" + inFileName + "</title>\n\t"
                    + "</head>\n\t"
                    + "<body>\n\t\t"
                    + "<table style=\" text-align: left;\" border=\"1\"\n\t\t"
                    + "cellpadding=\"2\" cellspacing=\"2\">\n\t\t"
                    + "<tbody>\n\t\t\t");
            
            //looping first time using reader to determine longest row
            while(reader.readRecord()){
                    if(counter < reader.getColumnCount()){
                        counter = reader.getColumnCount();
                    }
                    
                    //System.out.println(counter);
            } 
            
            //looping second time using reader2 to write to outputFile
            while(reader2.readRecord()){
                writer.write("<tr>\n\t\t\t");
                
                
                //use escape to parse special characters
                for(int i=0; i<counter; i++){
                    writer.write("\t<td>" + escape.stringToHTMLString(reader2.get(i)) + "<br>\n\t\t\t");
                    writer.write("\t</td>\n\t\t\t");
                    //System.out.println(reader2.get(i));
                }
                
                writer.write("</tr>\n\t\t\t");
            }
            
            
            //The closing html format
            writer.write("\n\t\t</tbody>"
                    + "\n\t\t</table>"
                    + "\n\t\t<br>"
                    + "\n\t</body>"
                    + "\n</html>");
            
            
            //*** MUST CLOSE *** otherwise won't write!!!
            writer.close();
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
