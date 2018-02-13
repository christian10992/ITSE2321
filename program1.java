//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 1>
//
//  File Name:            <christianharris_program1.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <1/30/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 1>
//
//  Description:
//     <Calculate an employee's paycheck for twice-monthly and bi-weekly pay given the employee's salary.>
//
//********************************************************************

package program1;

public class program1 {

	public static void main(String[] args) {
		double salary = 32500.0;
		double twiceMonthlyPay = salary/24;
		double biWeeklyPay = salary/26;
		System.out.println("If paid twice monthly, this employee's paycheck will be $" + twiceMonthlyPay);
		System.out.println("If paid bi-weekly, this employee's paycheck will be $" + biWeeklyPay);
	}

}
