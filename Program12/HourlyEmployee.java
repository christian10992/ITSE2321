//********************************************************************
//
//  Author:               Instructor
//
//  Program #:            Twelve
//
//  File Name:            HourlyEmployee.java
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
//     This program extends the Employee class and contains functions pertinent to hourly users
//
//********************************************************************

package Program12;

public class HourlyEmployee extends Employee 
{
	private double regularHours; //hours <= 40
	private double overtimeHours; //hours > 40
	private double monthlyHours; //months pay divided by 4 weeks
	private double monthlyRegularHours; //total regular hours for a month
	private double monthlyOvertimeHours; //total overtime hours for a month
	private double monthlyRegularPay; //total pay for regular hours
	private double monthlyOvertimePay; //total pay for overtime hours
	private double grossPay; //pay before taxes
	private double monthlyTaxes; //amount of taxes
	
	public HourlyEmployee() //initialize to 0 if no parameters previously exist
	{
		this.regularHours = 0.0;
		this.overtimeHours = 0.0;
		this.monthlyHours = 0.0;
		this.monthlyRegularHours = 0.0;
		this.monthlyOvertimeHours = 0.0;
		this.monthlyRegularPay = 0.0;
		this.monthlyOvertimePay = 0.0;
		this.grossPay = 0.0;
		this.monthlyTaxes = 0.0;
	}
	
	public HourlyEmployee(String firstName, String lastName, double payRate, double totalHours)
	  {
		super(firstName, lastName, payRate, totalHours);
	  } // end constructor
	
	public void setVariables(double totalHours, double payRate)
	{
		setRegularHours(totalHours);
		setOvertimeHours(totalHours);
		setMonthlyHours(totalHours);
		setMonthlyRegularHours(regularHours);
		setMonthlyOvertimeHours(overtimeHours);
		setMonthlyRegularPay(monthlyRegularHours, payRate);
		setMonthlyOvertimePay(monthlyOvertimeHours, payRate);
	}

	private void setRegularHours(double totalHours) //calculate and set regular hours
	{
		if (totalHours >= 40)
			this.regularHours = 40;
		else
			this.regularHours = totalHours;
	}
	
	private void setOvertimeHours(double totalHours) //calculate and set overtime hours 
	{
		if (totalHours >= 40)
			this.overtimeHours = totalHours - 40;
		else
			this.overtimeHours = 0;
	}
	
	private void setMonthlyRegularHours(double regularHours) //calculate and set monthly regular hours 
	{
		this.monthlyRegularHours = monthlyRegularHours + regularHours;
	}
	
	private void setMonthlyOvertimeHours(double overtimeHours) //calculate and set monthly overtime hours 
	{
		this.monthlyOvertimeHours = monthlyOvertimeHours + overtimeHours;
	}

	public void setMonthlyHours(double totalHours) //calculate and set monthly hours 
	{
		this.monthlyHours = monthlyHours + totalHours ;
	}
	
	public void setMonthlyRegularPay(double monthlyRegularHours, double payRate) //calculate and set monthly pay
	{
		this.monthlyRegularPay = monthlyRegularHours * payRate;
	}
	
	public void setMonthlyOvertimePay(double monthlyOvertimeHours, double payRate) //calculate and set monthly overtime pay
	{
		this.monthlyOvertimePay = monthlyOvertimeHours * payRate * 1.5;
	}
	
	public void setMonthlyTaxes(double grossPay) //calculate and set tax amount based on gross pay
	{
		if (grossPay <= 2000)
			this.monthlyTaxes = grossPay * .1;
		else if (grossPay <= 3500)
			this.monthlyTaxes = grossPay * .15;
		else if (grossPay <= 6000)
			this.monthlyTaxes = grossPay * .28;
		else if (grossPay <= 1000)
			this.monthlyTaxes = grossPay * .31;
		else
			this.monthlyTaxes = grossPay * .36;
	}
	
	public double getRegularHours() //return regular hours
	{
		return regularHours;
	}

	public double getOvertimeHours() //return overtime hours 
	{
		return overtimeHours;
	}
	
	public double getMonthlyRegularPay() //return regular pay
	{
		return monthlyRegularPay;
	}
	
	public double getMonthlyOvertimePay() //return overtime pay
	{
		return monthlyOvertimePay;
	}
	
	public double getGrossPay(double monthlyRegularPay, double monthlyOvertimePay) //calculate and return gross pay
	{
		this.grossPay = monthlyRegularPay + monthlyOvertimePay;
		return grossPay;
	}
	
	public double getMonthlyTaxes() //returns tax amount
	{
		return monthlyTaxes;
	}
	
	public double getNetPay(double grossPay, double monthlyTaxes) //calculates and returns net pay
	{
		double netPay = grossPay - monthlyTaxes;
		return netPay;
	}
	
	@Override // indicates that this method overrides a superclass method
	public String toString()                                             
	{                                                                    
	   return String.format("%s: %s %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f",
	      "Employee", getFirstName(), getLastName(),
	      "Pay rate", getPayRate(),
	      "Total hours worked", monthlyHours,
	      "Total regular hours worked", monthlyRegularHours,
	      "Total overtime hours worked", monthlyOvertimeHours,
	      "Monthly Regular Pay", monthlyRegularPay,
	      "Monthly Overtime Pay", monthlyOvertimePay,
	      "Monthly Gross Pay", getGrossPay(monthlyRegularPay, monthlyOvertimePay),
	      "Monthly Taxes", getMonthlyTaxes(),
	      "monthly Net Pay", getNetPay(grossPay, monthlyTaxes));
	}
} // End class Employee
