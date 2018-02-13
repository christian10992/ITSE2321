//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 3>
//
//  File Name:            <Salary.java>
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
//     <Program to create an employee profile containing their full name and salary>
//
//********************************************************************

package program3;

public class Salary 
{
	private String firstName; // initialize variable for employee's first name
	private String lastName; // initialize variable for employee's last name
	private double salary; // initialize variable for employee's salary
	
	public String getFirstName() //create getter for first name
	{ 
		return firstName;
	}
	public void setFirstName(String firstName) //create setter for first name
	{ 
		this.firstName = firstName;
	}
	public String getLastName() //create getter for last name
	{ 
		return lastName;
	}
	public void setLastName(String lastName) //create setter for last name
	{ 
		this.lastName = lastName;
	}
	public double getSalary() //create getter for salary
	{ 
		return salary;
	}
	public void setSalary(double salary) //create setter for salary
	{ 
		if (salary > 0.0) // salary must be greater than 0.0 to be valid
			this.salary = salary;
	}
	
	public double giveRaise(double salary)
	{
		this.salary = salary*1.15;
		return this.salary;
	}
}
