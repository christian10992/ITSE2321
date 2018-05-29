//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 9>
//
//  File Name:            <SavingsAccountTest.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <4/16/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 8>
//
//  Description:
//     <This program is for testing the SavingsAccount class.>
//
//********************************************************************

package program9;

import java.util.Scanner; //program uses Scanner for user input

public class SavingsAccountTest 
{

	public static void main(String[] args) 
	{
		
		// create Scanner object for receiving user input through the keyboard
		Scanner input = new Scanner(System.in); //create new Scanner object
		
		SavingsAccount saver1 = new SavingsAccount(); //instantiate SavingsAccount object for accountholder 1
		SavingsAccount saver2 = new SavingsAccount(); //instantiate SavingsAccount object for accountholder 2
		
		System.out.print("Enter account balance for the first accountholder: $"); //prompt user for accountholder 1 balance
		double savingsBalance = input.nextDouble(); //get user input
		saver1.setSavingsBalance(savingsBalance);//set account balance for accountholder 1
		System.out.print("Enter account balance for the second accountholder: $");//prompt user for accountholder 2 balance
		savingsBalance = input.nextDouble(); //get user input
		saver2.setSavingsBalance(savingsBalance); //set account balance for accountholder 2
		
		System.out.print("Enter annual interest rate: "); //prompt user for annual interest rate
		double interestRate = input.nextDouble(); //get user input
		SavingsAccount.modifyInterestRate(interestRate); //set interest rate
		System.out.println(""); //prints blank line
		
		System.out.println("Monthly balance after interest for accountholder 1: ");
		double monthlyInterest = saver1.calculateMonthlyInterest(); //calculate the amount of monthly interest earner
		for (int month = 1; month < 13; month++) //loops throw all 12 months
		{
			saver1.addMonthlyInterest(monthlyInterest); //adds monthly interest to account balance
			String newBalance = saver1.toString(); //get account balance as string
			System.out.println("Month " + month + ": $" + newBalance); //print current month and total balance
		}
		System.out.println(""); //prints blank line
		
		System.out.println("Monthly balance after interest for accountholder 2: ");
		monthlyInterest = saver2.calculateMonthlyInterest(); //calculate the amount of mothly interest earner
		for (int month = 1; month < 13; month++) //loops throw all 12 months
		{
			saver2.addMonthlyInterest(monthlyInterest); //adds monthly interest to account balance
			String newBalance = saver2.toString(); //get account balance as string
			System.out.println("Month " + month + ": $" + newBalance); //print current month and total balance
		}
		System.out.println(""); //prints blank line

		System.out.print("Enter deposit amount for accountholder 1: $"); //prompt user for deposit amount for accountholder 1
		double depositAmount = input.nextDouble(); //get user input
		saver1.depositAmount(depositAmount); //adds deposit to account total
		System.out.print("Enter deposit amount for accountholder 2: $"); //prompt user for deposit amount for accountholder 2
		depositAmount = input.nextDouble(); //get user input
		saver2.depositAmount(depositAmount); //adds deposit to account total
		System.out.println(""); //prints blank line
		
		System.out.print("Enter withdraw amount for accountholder 1: $"); //prompt user for withdraw amount for accountholder 1
		double withdrawAmount = input.nextDouble(); //get user input
		saver1.withdrawAmount(withdrawAmount); //subtracts withdraw amount from account balance
		System.out.print("Enter withdraw amount for accountholder 2: $"); //prompt user for withdraw amount for accountholder 2
		withdrawAmount = input.nextDouble(); //get user input
		saver2.withdrawAmount(withdrawAmount); //subtracts withdraw amount from account balance
		System.out.println(""); //prints blank line
		
		System.out.print("Enter new interest rate: "); //prompt user for new interest rate
		interestRate = input.nextDouble(); //get user input
		SavingsAccount.modifyInterestRate(interestRate); //set new interest rate
		System.out.println(""); //prints blank line
		
		monthlyInterest = saver1.calculateMonthlyInterest(); //calculate one months interest
		saver1.addMonthlyInterest(monthlyInterest); //adds monthly interest to account
		monthlyInterest = saver2.calculateMonthlyInterest(); //calculate one months interest
		saver2.addMonthlyInterest(monthlyInterest); //adds monthly interest to account
		
		String finalBalance = saver1.toString(); //get balance as string
		System.out.printf("Account balance + 1 month's interest for accountholder 1: $%s%n", finalBalance); //print total balance
		finalBalance = saver2.toString(); //get balance as string
		System.out.printf("Account balance + 1 month's interest for accountholder 2: $%s%n", finalBalance); //print total balance
	}

}
