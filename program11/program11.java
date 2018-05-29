//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 11>
//
//  File Name:            <SavingsAccount.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <5/1/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 1-9, 14, 15>
//
//  Description:
//     <This program allows a user to enter a date in mm/dd/yyyy format and prints it in a different format. 
//      User must enter a validly formatted date.>
//
//********************************************************************

package program11;

import java.util.Scanner;
import java.io.IOException;

public class program11 {

	public static void main(String[] args) throws IOException {
		program11 obj = new program11(); //initialzie class as object

		int[] date = obj.getDate(); //get the date from user
		String month = obj.convertDate(date); //converts the month to a string
		obj.printDate(month, date); //prints the date the user entered, if it is a real date
	}
	
	public int[]  getDate()
	{
		int month = 0; //initialize variable to store the month
		int day = 0; //initialize variable to store the day
		int year = 0; //initialize variable to store the year
		boolean correctFormat = false; //sentinel value for while loop
		
		while (correctFormat == false) //user must enter a date in a valid format
		{
			boolean isNumbers = true; //control value to ensure user entered numbers
			
			System.out.print("Enter a date in mm/dd/yyyy format: "); //prompt user
			Scanner input = new Scanner(System.in); //initialize scanner for keyboard input
			String date = input.nextLine(); //reads input from keyboard
			
			String firstSlash = new String(); //create a value to check that slashes are in the correct position
			String secondSlash = new String();
			
			try
			{
			firstSlash = date.substring(2,3); //first slash after mm
			secondSlash = date.substring(5,6); //second slash after dd
			}
			catch (StringIndexOutOfBoundsException e) //if the user does not enter enough characters the index could be out of bounds
			{
				System.out.print("Invalid format. Please enter a date in the mm/dd/yyyy format.");
			} //end try block
			
			if (firstSlash.equals("/") == false || secondSlash.equals("/") == false) //checks to make sure slashes are in right spot
				System.out.print("Invalid format. Please enter a date in the mm/dd/yyyy format.");
			else
			{
				
				String[] tokens = date.split("/"); //split string on /
				if (tokens[0].length() != 2 || tokens[1].length() != 2 || tokens[2].length() != 4) //makes sure each token is correct length
				{
					System.out.print("Invalid format. Please enter a date in the mm/dd/yyyy format.");
				}
				else
				{
					try
					{
						month = Integer.parseInt(tokens[0]); //converts first token to int
						day = Integer.parseInt(tokens[1]); //converts second token to int
						year = Integer.parseInt(tokens[2]); //converts third token to int
					}
					catch (NumberFormatException e) //if the user has entered something other than digits here, there will be an exception thrown
					{
						System.out.print("Invalid format. Please enter a date in the mm/dd/yyyy format.");
						isNumbers = false; //if the input was not correct, the while loop restarts
					} //end try block
					if (isNumbers == true)
						correctFormat = true; //if everything is correct for the format, the program moves on
				}
			}
		} // end while loop
		int[] validFormatDate = {month, day, year}; //store date as integer array
		return validFormatDate; //return date to convert month to string
	}
	
	public String convertDate(int[] date) throws IOException//convert month to string.
	{
		String monthString = new String(); //intialize a string to store date
		monthString = "";
		switch (date[0]) //switch to assign month as a string
		{
		case 1:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "January";
			break;
		case 2:
			if (date[2] % 4 == 0) //this accounts for leap years
			{
				if (date[1] <= 29 && date[1] > 0)
					monthString = "February";
			}
			else //and for non-leap years
			{
				if (date[1] <= 28 && date[1] > 0)
					monthString = "February";
			}
			break;
		case 3:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "March";
			break;
		case 4:
			if (date[1] <= 30 && date[1] > 0)
				monthString = "April";
			break;
		case 5:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "May";
			break;
		case 6:
			if (date[1] <= 30 && date[1] > 0)
				monthString = "June";
			break;
		case 7:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "July";
			break;
		case 8:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "August";
			break;
		case 9:
			if (date[1] <= 30 && date[1] > 0)
				monthString = "September";
			break;
		case 10:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "October";
			break;
		case 11:
			if (date[1] <= 30 && date[1] > 0)
				monthString = "November";
			break;
		case 12:
			if (date[1] <= 31 && date[1] > 0)
				monthString = "December";
			break;
		}
		if (monthString == "") //if the initial string is unchanged, the date was not a real date
			throw new IOException("This is not a real date.");
		return monthString;
	}
	
	public void printDate (String month, int[] date) //print date
	{
		System.out.printf("The date you entered is %s %d, %d.", month, date[1], date[2]);
	}
}
