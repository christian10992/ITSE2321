//********************************************************************
//
//  Author:               <Christian Harris>
//
//  Program #:            <Program 7>
//
//  File Name:            <program7.java>
//
//  Course:               ITSE 2321 Objected-Oriented Programming (Java)
//
//  Due Date:             <3/25/2018>
//
//  Instructor:           Fred Kumi 
//
//  Chapter:              <Chapter 6>
//
//  Description:
//     <This program will ask a student multiplication questions. If the student answers correctly, it will display a message
//		with a randomly selected response. If it is answered incorrectly, the student will be given as many tries to answer it
//      correctly as needed, with a statement randomly selected from another group of statements for incorrect answers. After
//		answering 5 questions correctly, after each question the student will be given th eoption to exit the program.>
//
//********************************************************************

package program7;

import java.security.SecureRandom; //for generating random numbers
import java.util.Scanner; //for reading user input

public class program7 {
		
	public static void main(String[] args)
	{	
		program7 myObject = new program7(); //create object from class
		
		char continueOption = 'y'; //initialize sentinel value
		int correctAnswers = 0; //initialize number of questions answered correctly
		
		while (continueOption != 'n') //begin sentinel loop
		{
			
			myObject.createQuestion(); //ask question
			correctAnswers++; //and 1 to number of questions answered correctly
			if (correctAnswers > 4) // check to see if the student has 5 or more correct answers
			{
				char option = myObject.askToContinue(); //ask student if the would like to continue
				if (option == 'n') //if the student says no, the program will end
					continueOption = 'n';
			}
		} //end sentinel loop
		System.out.print("Goodbye!"); //print goodbye message
	} 
	
	public void createQuestion ()
	{
		SecureRandom randomNumbers = new SecureRandom(); //new random number object
		Scanner input = new Scanner(System.in); //new scanner object
		
		int userAnswer = 0; //initialize variable for user input
		int firstNumber = 1 + randomNumbers.nextInt(9); //generate number from 1 to 9
		int secondNumber = 1 + randomNumbers.nextInt(9); //generate number from 1 to 9
		int answer = firstNumber*secondNumber; //calculate the product of the two randomly generated numbers
		
		while (answer != userAnswer) //student will be allowed to attempt the question until they get it right
		{
			System.out.print("What is " + firstNumber + " x " + secondNumber + "? "); //print question
			userAnswer = input.nextInt(); //get user input
			if (answer != userAnswer) //check to see if answer is correct
				answeredIncorrectly(); //if incorrect, print a message letting the student know they answered incorrectly
		}
		answeredCorrectly(); //else print a message letting them know it was correct
	}
	
	public void answeredCorrectly() //possible responses for a correct answer
	{
		SecureRandom randomNumbers = new SecureRandom(); //new random number object
		int declaration = 1 + randomNumbers.nextInt(5); //generate number from 1 to 5
		switch (declaration) //randomly select a statement to display
		{
			case 1:
				System.out.println("Excellent!\n");
				break;
			case 2:
				System.out.println("Very good!\n");
				break;
			case 3:
				System.out.println("Nice work!\n");
				break;
			case 4:
				System.out.println("Way to go!\n");
				break;
			case 5:
				System.out.println("Keep up the good work!\n");
				break;
		} //end switch
	}
	
	public void answeredIncorrectly() //possible responses for an incorrect asnwer
	{
		SecureRandom randomNumbers = new SecureRandom(); //new random number object
		int declaration = 1 + randomNumbers.nextInt(5); //generate number from 1 to 5
		switch (declaration) //randomly select a statement to display
		{
			case 1:
				System.out.println("That is incorrect!\n");
				break;
			case 2:
				System.out.println("No. Please try again!\n");
				break;
			case 3:
				System.out.println("Wrong, Try once more!\n");
				break;
			case 4:
				System.out.println("Don’t give up!\n");
				break;
			case 5:
				System.out.println("No. Keep trying!\n");
				break;
		} //end switch
	}
	
	public char askToContinue()
	{
		Scanner input = new Scanner(System.in); //new scanner object
		System.out.print("Would you like to continue? (y/n)"); //ask student if they'd like to continue answering questions
		char userAnswer = input.next().charAt(0); //get student input
		System.out.println(""); //prints blank line
		
		return userAnswer; //returns students answer
	}
}
