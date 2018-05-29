//********************************************************************
//
//  Author:               Instructor
//
//  Program #:            Twelve
//
//  File Name:            HourlyEmployeeTest.java
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             5/09/2018
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              9
//
//  Description:
//     This program test the HourlyEmployee class
//
//********************************************************************

package Program12;

import java.util.Scanner;

public class HourlyEmployeeTest {
	
	Scanner input = new Scanner(System.in); //program uses keyboard input
	
	public static void main(String[] args) {
		HourlyEmployeeTest myObj = new HourlyEmployeeTest(); //initialize test class
		String firstName = new String(); //initialize first name
		String lastName = new String();//initialize last name
		double payRate = 0.0; //initialize hourly rate
		double totalHours = 0.0; //initialize hours worked
		String continueProgram = "yes"; //initialize sentinel
		
		firstName = myObj.userFirstName(firstName); //get first name from user
		lastName = myObj.userLastName(lastName); //get last name from user
		payRate = myObj.userPayRate(payRate); //get pay rate from user
		
		HourlyEmployee worker = new HourlyEmployee(firstName, lastName, payRate, totalHours); //initialize new employee
		
		do
		{
			totalHours = myObj.userTotalHours(totalHours); //get total hours worked from user
			
			worker.setTotalHours(totalHours);
			worker.setVariables(totalHours, payRate);
			
			continueProgram = myObj.continuePrompt(continueProgram); //ask user if they wish to continue
			System.out.println(""); //prints blank line
			
		} while (continueProgram.equals("no") == false); //user chooses to start program over or not
		
		double monthlyRegularPay = worker.getMonthlyRegularPay(); //get monthly regular hours
		double monthlyOvertimePay = worker.getMonthlyOvertimePay(); //get monthly overtime hours
		double grossPay = worker.getGrossPay(monthlyRegularPay, monthlyOvertimePay); //calculate gross pay
		worker.setMonthlyTaxes(grossPay); //calculate taxes
		String result = worker.toString(); //convert results to a string to print
		System.out.print(result); //print results
	}
	
	public String userFirstName(String firstName) //get first name from user
	{
		System.out.print("Enter the employee's first name: ");
		firstName = input.nextLine();
		return firstName;
	}
	
	public String userLastName(String lastName) //get last name from user
	{
		System.out.print("Enter the employee's last name: ");
		lastName = input.nextLine();
		return lastName;
	}
	
	public double userPayRate(double payRate) //get pay rate from user
	{
		System.out.print("Enter the employee's hourly pay rate: ");
		payRate = input.nextDouble();
		return payRate;
	}
	
	public double userTotalHours(double totalHours) //get pay rate from user
	{
		System.out.print("Enter the employee's number of hours worked per week: ");
		totalHours = input.nextDouble();
		return totalHours;
	}
	
	public String continuePrompt(String continueProgram) //prompt user if they wish to continue
	{
		System.out.print("Would you like to enter another weeks hours? (yes/no) ");
		input.nextLine();
		continueProgram = input.nextLine();
		return continueProgram;
	}
}
