//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 3>
//
//  File Name:            <SalaryTest.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <2/12/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 3>
//
//  Description:
//     <Program to test the Salary class>
//
//********************************************************************

package program3;

import java.util.Scanner;

public class SalaryTest 
{

	public static void main(String[] args) 
	{
		// create Scanner object for receiving user input through the keyboard
		Scanner input = new Scanner(System.in);
		
		// create Salary objects for both employee's
		Salary employee1 = new Salary();
		Salary employee2 = new Salary();
		
		// display initial values for variables in the Salary class
		System.out.printf("The intial first name is: %s%n", employee1.getFirstName());
		System.out.printf("The intial last name is: %s%n", employee1.getLastName());
		System.out.printf("The intial salary is: %s%n%n", employee1.getSalary());
		
		// get user input and set variables for employee names
		System.out.println("Please enter two employee's names.");
		
		System.out.print("Please enter the first employee's first name: ");
		String first1 = input.nextLine(); //employee 1 first name
		employee1.setFirstName(first1);
		
		System.out.print("Please enter the first employee's last name: "); 
		String last1 = input.nextLine(); //employee 1 last name
		employee1.setLastName(last1);
		
		System.out.print("Please enter the second employee's first name: "); 
		String first2 = input.nextLine(); //employee 2 first name
		employee2.setFirstName(first2);
		
		System.out.print("Please enter the second employee's last name: "); 
		String last2 = input.nextLine(); //employee 2 last name
		employee2.setLastName(last2);
		System.out.println();
		
		// get user input for each employee's salary
		System.out.printf("Please enter " + first1 + " " + last1 +"'s monthly salary: ");
		double salary1 = input.nextDouble(); //salary for employee 1
		employee1.setSalary(salary1);
		
		System.out.print("Please enter " + first1 + " " + last2 +"'s monthly salary: ");
		double salary2 = input.nextDouble(); //salary for employee 2
		employee2.setSalary(salary2);
		System.out.println();
		
		double yearSalary1 = salary1*12; //calculate yearly salary for employee 1
		double yearSalary2 = salary2*12; //calculate yearly salary for employee 2
		
		// display salary for each employee
		System.out.printf(first1 + " " + last1 +"'s yearly salary is $%.2f.%n", yearSalary1);
		System.out.printf(first2 + " " + last2 +"'s yearly salary is $%.2f.%n%n", yearSalary2);
		
		// calculate a 15% raise for each employee
		double raise1 = employee1.giveRaise(yearSalary1);
		double raise2 = employee2.giveRaise(yearSalary2);
		
		// display each employee's salary if they received a raise
		System.out.println("If each employee received a 15% raise...");
		System.out.printf(first1 + " " + last1 +"'s yearly salary would be $%.2f.%n", raise1);
		System.out.printf(first2 + " " + last2 +"'s yearly salary would be $%.2f.%n", raise2);
	}
	
}
