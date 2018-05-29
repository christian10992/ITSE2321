//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 6>
//
//  File Name:            <program6.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <3/11/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 15>
//
//  Description:
//     <A program that reads input to a file to calculate raises to give to an employee, and saves that data to another file>
//
//********************************************************************

package program6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class program6
{
	
   private Scanner input;
   private static Formatter output; //outputs text to a file

   public static void main(String[] args)
   {
	   program6 myObject = new program6();
	   
	   myObject.openInFile(); //open input file
	   myObject.openOutFile(); //open file for output
       myObject.readRecords(); //reads initial records from input file
       
       myObject.openInFile(); //opens the input file
	   myObject.giveRaise(); //calculates raise based off of salary
	   myObject.closeOutFile(); //closes output file
   } 

   
   public void openInFile()
   {
      try //open file for reading
      {
         input = new Scanner(Paths.get("E:\\Workspace\\ITSE 2321\\Program6.txt"));
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1); //terminate the program
      } //end try block
   }
   
   public void openOutFile()
   {
      try //open file for writing
      {
    	  output = new Formatter("E:\\Workspace\\ITSE 2321\\Program6-out.txt"); //open the file
      }
      catch (SecurityException securityException)
      {
         System.err.println("Write permission denied. Terminating.");
         System.exit(1); //terminate the program
      }
      catch (FileNotFoundException fileNotFoundException)
      {
      System.err.println("Error opening file. Terminating.");
      System.exit(1); //terminate the program
      }  //end try block
   }
   
   public void readRecords()  
   {
	  // initialize variables
	  double count = 0.0;
	  double salary = 0.0;
	  double total = 0.0;
	  
	  try //prints employess initial salaries
	  {
	     System.out.println("List of employee salaries before raise: ");
	     // write each salary to the output file
	     
		 try //write header to file
		 {
			 output.format("List of employee salaries before raise: %n");
		 }
		 catch (FormatterClosedException formatterClosedException)
		 {
		    System.err.println("Error writing to file. Terminating.");
		 }
		 catch (NoSuchElementException elementException)
		 {
		    System.err.println("Invalid input. Please try again.");
		    input.nextLine(); // discard input so user can try again
		 } //end nested try block
	     
	     while (input.hasNext()) // while there is more to read
	     {
	    	 salary = input.nextDouble();
	         // display record contents                     
	         System.out.printf("%10.2f%n", salary);
	   
	         // get running totals for average
        	 count += 1.0; //counts number of salaries
        	 total += salary; //creates running total of salaries
        	 
        	 // write each salary to the output file
    		 try
    		 {
    			 output.format("%10.2f%n", salary);
    		 }
    		 catch (FormatterClosedException formatterClosedException)
    		 {
    		    System.err.println("Error writing to file. Terminating.");
    		    break;
    		 }
    		 catch (NoSuchElementException elementException)
    		 {
    		    System.err.println("Invalid input. Please try again.");
    		    input.nextLine(); // discard input so user can try again
    		 } //end nested try block
	     } //end while block
	     
	     System.out.println(""); //prints blank line
	     double average = total/count; //calculate average salary before raise
         System.out.printf("The average salary before the raise is: $%,.2f%n", average);
         System.out.printf("The total cost of payroll before the raise is: $%,.2f%n%n", total);
         
		 try //write average
		 {
			 output.format("The average salary before the raise is: $%,.2f%n", average);
			 output.format("The total cost of payroll before the raise is: $%,.2f%n%n", total);
		 }
		 catch (FormatterClosedException formatterClosedException)
		 {
		    System.err.println("Error writing to file. Terminating.");
		 }
		 catch (NoSuchElementException elementException)
		 {
		    System.err.println("Invalid input. Please try again.");
		    input.nextLine(); // discard input so user can try again
		 } //end nested try block
	   } //end try block
	   catch (NoSuchElementException elementException)
	   {
	      System.err.println("File improperly formed. Terminating.");
	   } 
	   catch (IllegalStateException stateException)
	   {
	      System.err.println("Error reading from file. Terminating.");
	   } 
   }
   
   public void giveRaise()
   {
	  // initialize variables
      double count = 0.0;
      double salary = 0.0;
      double oldTotal = 0.0;
	  double newTotal = 0.0;
	  double raise = 0.0;
	  
      try //prints salaries of employees after raise
	  {  
    	  System.out.println("List of employee salaries after raise: ");
    	  
 		 try //write header to file
 		 {
 			 output.format("List of employee salaries after raise: %n");
 		 }
 		 catch (FormatterClosedException formatterClosedException)
 		 {
 		    System.err.println("Error writing to file. Terminating.");
 		 }
 		 catch (NoSuchElementException elementException)
 		 {
 		    System.err.println("Invalid input. Please try again.");
 		    input.nextLine(); // discard input so user can try again
 		 } //end nested try block
    	  
	      while (input.hasNext()) //while there is more to read
	      {	 
	    		 salary = input.nextDouble(); //determine percentage for raise
	    		 if (salary < 50000)
	    			 raise = 5.5;
	    		 else if (salary < 70000)
	    			 raise = 7.0;
	    		 else
	    			 raise = 4;
	         
	    		 double salaryAfterRaise = salary + salary*raise/100; //calculate salary after raise
	         
	    		 System.out.printf("%,10.2f%n", salaryAfterRaise);
	         
	    		 count += 1.0; // creates a running total of salaries in file
	    		 oldTotal += salary;
	    		 newTotal += salaryAfterRaise; //creates sum of all new salaries
	    		 
	    		 // write each new salary to the output file
	    		 try
	    		 {
	    			 output.format("%,10.2f%n", salaryAfterRaise);
	    		 }
	    		 catch (FormatterClosedException formatterClosedException)
	    		 {
	    		    System.err.println("Error writing to file. Terminating.");
	    		    break;
	    		 }
	    		 catch (NoSuchElementException elementException)
	    		 {
	    		    System.err.println("Invalid input. Please try again.");
	    		    input.nextLine(); // discard input so user can try again
	    		 } //end nested try block
	      } //end while block
	      
	      double average = newTotal/count; //calculate the average of the salaries after the raise
	      System.out.println("");
	      // display new average
	      System.out.printf("The average salary after the raise is: $%,.2f%n", average);
	      
	      // display total cost
	      System.out.printf("The total cost of payroll is: $%,.2f%n", newTotal);
	      
	      double costOfRaise = newTotal - oldTotal; //calculate the cost of the raises
	      // display cost
	      System.out.printf("The cost of the giving the raises is: $%,.2f%n", costOfRaise);
	      
	      double avgRaise = costOfRaise/count; //calculate the avg cost of the raises
	      // display average raise
	      System.out.printf("The average cost of a raise is: $%,.2f%n", avgRaise);
	      
		  try //write new average and cost of raises
		  {
		     output.format("The average salary after the raise is: $%,.2f%n", average);
		     output.format("The total cost of payroll is: $%,.2f%n", newTotal);
		     output.format("The cost of the giving the raises is: $%,.2f%n", costOfRaise);
		     output.format("The average cost of a raise is: $%,.2f%n", avgRaise);
		  }
		  catch (FormatterClosedException formatterClosedException)
		  {
		     System.err.println("Error writing to file. Terminating.");
		  }
		  catch (NoSuchElementException elementException)
		  {
			 System.err.println("Invalid input. Please try again.");
			 input.nextLine(); // discard input so user can try again
		  } //end nested try block
	  } //end try block
	  catch (NoSuchElementException elementException)
	  {
	      System.err.println("File improperly formed. Terminating.");
	  }
	  catch (IllegalStateException stateException)
	  {
	      System.err.println("Error reading from file. Terminating.");
	  } 
   }
 
   public void closeOutFile() // close the output file
   {
      if (output != null)
    	  output.close();   
   }
   
} //end of file
