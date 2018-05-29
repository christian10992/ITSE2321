//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 10>
//
//  File Name:            <HouseHold.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <4/24/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapters 1-9, 14, 15>
//
//  Description:
//    <This class contains methods to print family household income data from a file, then display/write to external file 
//     the average income, households above the average, households below peoverty level, and percentage of households below poverty level>
//
//********************************************************************

package program10;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;


public class HouseHold {
	

	private static Formatter output;
	   
	   public void openOutFile()
	   {
	      try //open file for writing
	      {
	    	  output = new Formatter("E:\\Workspace\\ITSE 2321\\Program10-out.txt"); //open the file
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

	   public void printRecords(ArrayList<Integer> id, ArrayList<Double> income, ArrayList<Integer> members) //print each household info
	   {
		   System.out.print("Data for households on file: \n"); //print header
		   try //write header to file
		   {
			   	output.format("Data for households on file: \r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
		   System.out.print("ID number\tIncome\t\tNumber of Household Members\n"); //print header
		   try //write header to file
		   {
			   	output.format("ID number\tIncome\t\tNumber of Household Members\r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
		   
		   for (int x = 0; x < id.size(); x++) //iterate for length of ArrayList
		   {	
			   System.out.printf("%d\t\t$%,-7.2f\t%d\n", id.get(x), income.get(x), members.get(x)); //prints each household
			   try //write each household to file
			   {
				   	output.format("%d\t\t$%,-7.2f\t%d\r\n", id.get(x), income.get(x), members.get(x));
			   }
				 	catch (FormatterClosedException formatterClosedException)
			   {
				    System.err.println("Error writing to file. Terminating.");
			   } //end try block
		   }
		   
		   System.out.println(""); //prints blank line
		   try //write bank line to file
		   {
			   	output.format("\r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
	   }
	   
	   public double printAverage (ArrayList<Double> income) //prints average income of households
	   {
		   double totalIncome = 0; //initialize accumulator
		   for (int x = 0; x < income.size(); x++) //iterate for length of ArrayList
		   {
			   totalIncome += income.get(x); //accumulate incomes
		   }
		   double average = totalIncome/income.size(); //calculate average"
		   System.out.printf("The average household income is $%,.2f", average); //print average
		   try //write average to file
		   {
			   	output.format("The average household income is $%,.2f\r\n", average);
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
		   System.out.println(""); //prints blank line
		   return average; //return average for further use
	   }
	   
	   public void printHigh (double average, ArrayList<Integer> id, ArrayList<Double> income) //prints households above the average income
	   {
		   System.out.println("Households above the average income: ");
	   	   try //write header to file
	       {
		    	output.format("Households above the average income: \r\n");
	       }
		 	    catch (FormatterClosedException formatterClosedException)
	       {
		        System.err.println("Error writing to file. Terminating.");
	       } //end try block
		   System.out.print("ID number\tIncome\n"); //print header
	   	   try //write header to file
	       {
		    	output.format("ID number\tIncome\r\n");
	       }
		 	    catch (FormatterClosedException formatterClosedException)
	       {
		        System.err.println("Error writing to file. Terminating.");
	       } //end try block
	   	   
		   for (int x = 0; x < income.size(); x++) //iterate for length of ArrayList
		   {
			   if (income.get(x) > average) //if income of household is higher than average
			   {	   
				   System.out.printf("%d\t\t$%,-7.2f\n", id.get(x), income.get(x)); //prints households above average
			   	   try //write households higher than average to file
			       {
				    	output.format("%d\t\t$%,-7.2f\r\n", id.get(x), income.get(x));
			       }
				 	    catch (FormatterClosedException formatterClosedException)
			       {
				        System.err.println("Error writing to file. Terminating.");
			       } //end try block
			   }
		   }
		   
		   System.out.println(""); //prints blank line
		   try //write bank line to file
		   {
			   	output.format("\r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
	   }
	   
	   public int povertyAmount(ArrayList<Integer> id, ArrayList<Double> income, ArrayList<Integer> members)
	   {
		   System.out.println("Households below the poverty level: ");
		   try //write header to file
		   {
			   	output.format("Households below the poverty level: \r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
		   System.out.print("ID number\tIncome\n"); //print header
		   try //write header to file
		   {
			   	output.format("ID number\tIncome\r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
		   
		   int counter = 0;
		   for (int x = 0; x < income.size(); x++) //iterate for length of ArrayList
		   {
			 int numberOfMembers = members.get(x); //get number of members in household
			 double povertyLevel = 16460.00 + 4320.00 * (numberOfMembers - 2); //determine poverty level for household
			 if (income.get(x) < povertyLevel)
			 {
				 System.out.printf("%d\t\t$%,-7.2f\n", id.get(x), income.get(x)); //prints households below national poverty level
				 try //write households below poverty line to file
				 {
				   	output.format("%d\t\t$%,-7.2f\r\n", id.get(x), income.get(x));
				 }
					catch (FormatterClosedException formatterClosedException)
				 {
				    System.err.println("Error writing to file. Terminating.");
				 } //end try block
				 counter++;
			 }
		   }
		   
		   System.out.println(""); //prints blank line
		   try //write bank line to file
		   {
			   	output.format("\r\n");
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
		   return counter;
	   }
	   
	   public void povertyPercent(int homesUnder, ArrayList<Integer> members) //calculate and display percentage of homes under poverty level
	   {
		   double percentage = (double)(homesUnder)/members.size(); //get percentage
		   percentage *= 100; //convert percentage from decimal
		   System.out.printf("%.1f%% homes are below the national poverty level", percentage); //print percentage
		   try //write percentage to file
		   {
			   	output.format("%.1f%% homes are below the national poverty level", percentage);
		   }
			 	catch (FormatterClosedException formatterClosedException)
		   {
			    System.err.println("Error writing to file. Terminating.");
		   } //end try block
	   }
	   
	   public void closeOutFile() // close the output file
	   {
	      if (output != null)
	    	  output.close();   
	   }
}
