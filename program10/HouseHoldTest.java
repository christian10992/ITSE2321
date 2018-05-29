//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 10>
//
//  File Name:            <HouseHoldTest.java>
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
//     <This program is for testing the HouseHold class.>
//
//********************************************************************

package program10;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class HouseHoldTest 
{
	
	private Scanner input;
	
	static ArrayList<Integer> id = new ArrayList<Integer>(); //initialize integer ArrayList to store ids
	static ArrayList<Double> income = new ArrayList<Double>(); //initialize double ArrayList to store incomes
	static ArrayList<Integer> members = new ArrayList<Integer>(); //initialize integer ArrayList to store number of household members

	public static void main(String[] args) 
	{
		
		HouseHold obj = new HouseHold(); //create object for class HouseHold
		HouseHoldTest test = new HouseHoldTest(); //create object for class HouseHoldTest
		
		test.openInFile(); //open input file
		obj.openOutFile(); //open file for output
		
		test.writeArrays(); //writes the contents of the file into their respective arrays
		obj.printRecords(id, income, members); //print contents of file from arrays
		double average = obj.printAverage(income); //print average household income
		obj.printHigh(average, id, income); //print households above the average
		int homesUnder = obj.povertyAmount(id, income, members);
		obj.povertyPercent(homesUnder, members);
		
		obj.closeOutFile(); //close file for output

	}
	
		public void openInFile()
		{
			try //open file for reading
			{
				input = new Scanner(Paths.get("E:\\Workspace\\ITSE 2321\\Program10.txt"));
			} 
			catch (IOException ioException)
			{
				System.err.println("Error opening file. Terminating.");
				System.exit(1); //terminate the program
			} //end try block
		}
	   
	   public void writeArrays()
	   {
		   int position = 1; //initialize variable for starting position
		   while (input.hasNext()) //while there is more to read
		     {
			   if (position == 1) //if the cursor is at the first record in each row
				   id.add(input.nextInt()); //write record to array
			   else if (position == 2) //if the cursor is at the second record in each row
				   income.add(input.nextDouble()); //write record to array
			   else //if the cursor is at the third record in each row
				   members.add(input.nextInt()); //write record to array
			   position++; //increase position
			   if (position > 3) //if the position is greater than the number of rows
				   position = 1; //position will return to 1
		     }
	   }
}
