package program5;

import java.util.Scanner; //import java Scanner for user input

public class QuantityDiscount 
{

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in); //create Scanner input
		
		//initiate variables
		double softwarePackage = 99.00;
		int orderQuantity = 0;
		double discount = 0.0;
		
		//validate user input so that quantity ordered must be great than 0
		while (orderQuantity < 1)
		{
			System.out.print("Please enter the amount of packages ordered: ");
			orderQuantity = input.nextInt(); //get user input for number of packages ordered
		}
		
		System.out.println(); //print blank line
		
		//begin control structure to determine discount amount
		if (orderQuantity < 10)
			discount = 0.0;
		else if (orderQuantity < 40)
			discount = 10.0;
		else if (orderQuantity < 66)
			discount = 18.0;
		else if (orderQuantity < 91)
			discount = 27.0;
		else if (orderQuantity < 121)
			discount = 35.0;
		else if (orderQuantity < 200)
			discount = 42.0;
		else
			discount = 48.0;
		//end control structure
		
		double grossCost = orderQuantity*softwarePackage; //cost of order before discount is applied
		double discountPercent = discount/100; //discount in a decimal value
		double discountedAmount = grossCost*discountPercent; //value of discount applied to order
		double netCost = grossCost - discountedAmount; //cost of order after the discount is applied
		
		
		//display results
		System.out.printf("The number of units purchased is:\t %d%n", orderQuantity);
		System.out.printf("Discount applied is:\t\t\t %.0f%%%n", discount);
		System.out.printf("Total savings due to discount is:\t $%.2f%n",discountedAmount);
		System.out.printf("Total cost of the purchase is:\t\t $%.2f%n",netCost);
		
	}

}