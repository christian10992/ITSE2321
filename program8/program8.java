//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 8>
//
//  File Name:            <program8.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <4/3/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 7>
//
//  Description:
//     <This program is for an airline company that needs to fill 10 seats on their plane. There are 5 seats in economy and 5 seats in first class 
//      available. The program will ask the user their preference of section. If the choose a seat that is not available, it will ask if they want 
//      the other section instead. If they say no, it will tell them the next plane is leaving in 3 hours. Otherwise, it will tell the user their 
//      seat number and section. Once all 10 seats are filled, the program will end.>
//
//********************************************************************

package program8;

import java.util.Scanner; // program uses Scanner for user input

public class program8 {

	public static void main(String[] args) 
	{
		program8 myObj = new program8(); //create object for class
		
		boolean[] tickets = new boolean[10]; //create an array of type boolean to represent the tickets for the plane
		while (tickets[4] == false || tickets[9] == false) //continues to execute as long as tickets are available
		{
			int choice = myObj.getChoice(); //gets the users choice of section
			int seat = myObj.checkAvailability(choice, tickets); //checks to see if seats are available
			if (seat == 1 || seat == 3) //if seats in selected section are available, it will assign a seat and let the user know which one
			{
				seat = myObj.issueTicket(seat, tickets); //reserves seat
				myObj.printBoardingPass(seat); //displays info to user
			}
			else //if the user selected a section with no seats available, it will let them swap sections or wait for the next flight
			{
				seat = myObj.chooseAlternative(seat, tickets); //gives user option to swap
				if (seat == 1 || seat == 3) // if they accept it will assign a seat for the user
				{
					seat = myObj.issueTicket(seat, tickets); //reserves seat
					myObj.printBoardingPass(seat); //displays info to user
				}
				else
					myObj.displayMessage(); // if they decline it lets user know when next flight is
			}
		}
		System.out.println("Plane full."); //end of program
	}
	
	int getChoice() //gets users choice of section
	{
		Scanner input = new Scanner(System.in); //create Scanner object
		
		System.out.print("Hello. What class would you like to fly? Please enter 1 for first class or 2 for economy: "); //prompt user
		int choice = input.nextInt(); //get user input
		
		return choice;
	}

	int checkAvailability(int choice, boolean[] tickets) // checks to see if ticket is available in the chosen section
	{
		int seat;
		if (choice == 1) //choice for first class
		{
			if (tickets[4] == false) //the tickets are issued in order, if the last seat in first class is unavailable, all tickets in first class are
				seat = 1; //represent available first class seat
			else
				seat = 2; //represents no available first class seats
		}
		else
		{
			if (tickets[9] == false) //the tickets are issued in order, if the last seat in economy is unavailable, all tickets in economy are
				seat = 3; //represents available first class seat
			else
				seat = 4; //represents no available first class seats
		}
		return seat;
	}
	
	int issueTicket(int seat, boolean[] tickets) //this determines the number of the seat for their ticket
	{	
		int seatNumber = 1;
		if (seat == 1) //for users who chose first class
		{
			seatNumber = 1; //starts at seat number 1
			for (int ticket = 0; ticket < 5; ticket++) //loops through tickets 1-5
				{
					if (tickets[ticket] == false) //determines position in array by counter value
					{
						tickets[ticket] = true; //assigns value to true to reserve that ticket
						break; //if a ticket is assigned, it breaks from the loop
					}
					else
						seatNumber++; //increments seat number by 1 for each pass of the loop
				}
		}
		else //for users who chose economy
		{
			seatNumber = 6; //starts at seat number 6
			for (int ticket = 5; ticket < 10 ; ticket++) //loops through tickets 6-10
				{
					if (tickets[ticket] == false) //determines position in array by counter value
					{
						tickets[ticket] = true; //assigns value to true to reserve that ticket
						break; //if a ticket is assigned, it breaks from the loop
					}
					else
						seatNumber++; //increments seat number by 1 for each pass of the loop
				}
		}
		return seatNumber;
	}
	
	int chooseAlternative(int seat, boolean[] tickets) //allows user to opt for an alternate seat if the one they chose is unavailable
	{
		Scanner input = new Scanner(System.in); //create Scanner object
		
		if (seat == 2) //displays message if user originally chose first class
			System.out.print("We're sorry, but first class is full. Would you like to fly economy instead? (y/n) ");
		else //displays a message if user originally chose economy
			System.out.print("We're sorry, but economy is full. Would you like to fly first class instead? (y/n) ");
		char choice = input.next().charAt(0); //get user input
		
		if (choice != 'y') //if they say no, it will display an error message
			seat = 0;
		else if (seat == 2)
			seat += 1; //if the user originally chose a first class seat, this will give them an economy seat
		else
			seat -=3; //if the user originally chose an economy seat, this will give them a first class seat

		return seat;
	}
	
	int printBoardingPass(int seat) // gives the user their seat number and section
	{
		if (seat < 6) //displays message if user chose a seat in first class
			System.out.println("Your seat is number " + seat + " in first class.");
		else //displays message if user chose a seat in second class
			System.out.println("Your seat is number " + seat + " in economy.");
		System.out.println(""); //prints blank line
		return seat;
	}
	
	public void displayMessage() //display meesage letting user know when next flight is
	{
		System.out.println("Next flight leaves in 3 hours.");
		System.out.println(""); //prints blank line
	}
} //end of file
