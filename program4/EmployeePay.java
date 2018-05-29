//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 4>
//
//  File Name:            <EmployeePay.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <2/16/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 4>
//
//  Description:
//     <Calculates an employee's salary, overtime, and deductions based on user
//      input, then displays the results>
//
//********************************************************************

package program4;

import java.util.Scanner; //import Scanner for getting user input from keyboard

public class EmployeePay 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in); //create Scanner input
		
		// initiate variables
		int employeeID = 0;
		double hourlyRate = 0.0;
		int totalHours = 0;
		double overtimeRate = 0.0;
		int overtimeHours = 0;
		double incomeTax = 0.0;
		int parkingCharge = 20;
		
		System.out.print("Enter the employee ID number: ");
		employeeID = input.nextInt(); //get employee number from user
		
		System.out.print("Enter the employee's houly rate: ");
		hourlyRate = input.nextFloat(); //get hourly rate from user
		
		System.out.print("Enter the number of hours worked: ");
		totalHours = input.nextInt(); //get hours worked from user
		System.out.println(); //print blank line 
		
		int regularHours = totalHours; //initial regular hours to total hours
		
		if (totalHours > 40) 
		{
			overtimeHours = totalHours - 40; //calculate amount of overtime hours
			overtimeRate = hourlyRate * 1.5; //calculate overtime payrate
			regularHours = totalHours - overtimeHours; //calculate amount of normal hours worked if there was overtime
		}
		
		double regularPay = hourlyRate*regularHours; //calculate pay for regular hours worked
		double overtimePay = overtimeRate*overtimeHours; //calculate pay for overtime hours worked
		
		double grossPay = regularPay + overtimePay; //calculate gross pay
		double netPay = grossPay - parkingCharge; //initiate net pay to gross pay - parking charge
		
		if (grossPay > 500)
		{
			incomeTax = grossPay*.15; //calculate deduction
			netPay -= incomeTax; //calculate net pay if there was a deduction
		}
		
		//print results
		System.out.printf("ID number:\t %d%n", employeeID);
		System.out.printf("Pay rate:\t $%.2f%n", hourlyRate);
		System.out.printf("Regular hours:\t %d%n", regularHours);
		System.out.printf("Overtime hours:\t %d%n", overtimeHours);
		System.out.printf("Total hours:\t %d%n", totalHours);
		System.out.printf("Regular pay:\t $%.2f%n", regularPay);
		System.out.printf("Overtime pay:\t $%.2f%n", overtimePay);
		System.out.printf("Gross pay:\t $%.2f%n", grossPay);
		System.out.printf("Deductions:\t $%.2f%n", incomeTax);
		System.out.printf("Net pay:\t $%.2f%n", netPay);
	}

}
