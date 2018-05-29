//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 9>
//
//  File Name:            <SavingsAccount.java>
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
//     <This program contains the class for a savings account. This class contains the methods to manipulate the account balance by depositing, withdrawing,
//      and addingn interest, as well as setting the interest rate for the accountholder.>
//
//********************************************************************

package program9;

public class SavingsAccount 
{
	static double annualInterestRate; //yearly interest rate for account
	private double savingsBalance; //current amount in account
	
	public void setSavingsBalance(double savingsBalance) //create setter for account balance
	{ 
		this.savingsBalance = savingsBalance;
	}
	
	public static void modifyInterestRate(double interestRate) //allows user to modify annual interest rate
	{
		if (interestRate < 2) //interest rate must be between 2 and 5
			throw new IllegalArgumentException("Interest rate must be between 2 and 5."); //create exception for invalid input
		else if (interestRate <= 5)
			annualInterestRate = interestRate;
		else //interest rate must be between 2 and 5
			throw new IllegalArgumentException("Interest rate must be between 2 and 5."); //create exception for invalid input
	}
	
	public double calculateMonthlyInterest() //calculates the amount of monthly interest earned
	{
		double annualInterestDecimal = annualInterestRate / 100; //calculates interest in decimal form
		double monthlyInterest = savingsBalance * annualInterestDecimal / 12; //calculates amount of monthly interest
		return monthlyInterest;
	}
	
	public void addMonthlyInterest(double monthlyInterest) //adds mothly interest earned to account balance
	{
			savingsBalance += monthlyInterest;
	}
	
	public void depositAmount(double depositAmount) //method to make a deposit to account balance
	{	
		if (depositAmount >= 0) //amount must be 0 or greater
			savingsBalance += depositAmount; //adds deposit amount to account balance
		else
			throw new IllegalArgumentException("Amount must be positive"); //throw exception for invalid amount
	}
	
	public void withdrawAmount(double withdrawAmount)
	{
		if (withdrawAmount >= 0) //amount must be 0 or greater
			savingsBalance -= withdrawAmount; //subtracts withdraw amount to account balance
		else
			throw new IllegalArgumentException("Amount must be positive"); //throw exception for invalid amount
	}
	
	public String toString() //convert account balance amount to string for test class use
	{
		return String.format("%.02f", savingsBalance);
	}
	
}
