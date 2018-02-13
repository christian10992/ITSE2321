//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 2>
//
//  File Name:            <christianharris_program2.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <2/05/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 2>
//
//  Description:
//     <Program to calculate user's daily cost of driving>
//
//********************************************************************

package program2;

import java.util.Scanner; //import scanner for reading input

public class program2 
{

	public static void main(String[] args) 
	{
		// create a scanner to read user input
		Scanner input = new Scanner(System.in);
		
		float totalMiles; //total miles driven
		float costOfGas; //cost of a gallon of gasoline
		float avgMPG; //average miles per gallon
		float parkingFees; //cost of parking fees
		float tollsPerDay; //cost of tools per day
		
		System.out.print("Enter total number of miles driven per day: "); //prompt
		totalMiles = input.nextFloat(); //user input miles driven per day
		
		System.out.print("Enter the cost of a gallon of gas: ");
		costOfGas = input.nextFloat(); //user input cost of a gallon of gas
		
		System.out.print("Enter the average miles per gallon of gas driven: ");
		avgMPG = input.nextFloat(); //user input the average number of miles driven per gallon of gas
		
		System.out.print("Enter the cost of parking fees per day: ");
		parkingFees = input.nextFloat(); //user input amount of parking fees per day
		
		System.out.print("Enter the cost of tollss per day: ");
		tollsPerDay = input.nextFloat(); //user input the cost of tolls per day
		
		// divide total miles driven by average MPG, then multiply by cost of gas to find out the cost of gas used per day
		// then add parking and tolls to get total cost
		float costPerDay = totalMiles / avgMPG * costOfGas + parkingFees + tollsPerDay;
		
		System.out.printf("The daily cost of driving is: $%.2f%n", costPerDay); //show result
	}

}
