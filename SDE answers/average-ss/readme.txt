readme.txt -- for average-ss

THE TASK
Modify SpreadSheet.java so that a formula can compute the average 
       of either a row or a column.
       
 Syntax: =AVG(C1:C2) where C1 and C2 are the first and last cells of the
     row or column data to be averaged.

 Semantics: 
     1. If C1 and C2 are within either a row or column of numbers compute
        and return the average.
        Note: Do this regardless of the direction in which the sum runs.
        Note: The sum can run right to left, left to right, top to bottom, or
              bottom to top.
     2. If an error occurs while evaluating a formula, display "!!!" in the
        cell. Errors include the following:
        A. C1 and C2 fail to fall in the same row or column.
        B. One or more cells in the range are not numbers (or are not
           formulas that evaluate without error to numbers).
        C. The AVG formula depends either directly or indirectly on its 
           own value; that is, a cycle is detected.
           
A video demonstration of a solution for this task can be found at:
http://www.softwaredevelopercertification.com/sdc-pilot-exam/solution-demos#TOC-Average
or as average-ss.html in the "Solution Demonstration Videos"
folder on the desktop in the exam delivery environment.
