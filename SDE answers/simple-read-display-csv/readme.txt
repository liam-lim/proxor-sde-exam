readme.txt -- for simple-read-display-csv

THE TASK
Create a class named "ReadFileWriteToConsole" that imports
com.csvreader.CsvReader (found in the "javacsv" project
or directory) and uses CsvReader to read csv files into a
two-dimensional array and then writes the array out to the
console (System.out) with square brackets enclosing each
value. Assume that the size of the csv file is 3x3, and assume
that the file is a valid csv file that can be read without
any errors.

SAMPLE INPUT FILE
1,2,3
Hello World,=A1+B1*C1,foo
,,perfect

SAMPLE OUTPUT TO CONSOLE
[1][2][3]
[Hello World][=A1+B1*C1][foo]
[][][perfect]

Your program should be based on ReadFileWriteToConsole.java, 
which already declares three methods:
 1. main is the entry point when running as an application.
 2. readSheet reads the file in.csv from the current working
        directory into the two-dimensional String array named sheet.
 3. writeSheet writes sheet to the console.
The variable sheet and its dimensions are also declared.

You should modify ReadFileWriteConsole.java to implement the 
behavior described above. You must not alter the names of 
methods or variables already declared.

A video demonstration of a solution for this task can be found at:
http://www.softwaredevelopercertification.com/sdc-pilot-exam/solution-demos#TOC-Simple-Read-Display
or as simple-read-display-csv.html in the "Solution Demonstration Videos"
folder on the desktop in the exam delivery environment.
