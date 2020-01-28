/*
 * Bradley Grose
 */

import java.io.IOException;
import java.util.Scanner;

public class ShowcaseGame {

	public static void main(String[] args)  {

		Scanner keyboard = new Scanner(System.in);
		Showcase s = new Showcase(); //Builds Showcase
		
		while(true)
		{
			System.out.println("Welcome to the showcase show down!\nYour prizes are:");
			
			//Initialized the prizes
			Prize[] randomPrize = s.randomPrize();
			double prizeValue = 0.0;
			
			for(int i=0; i<randomPrize.length; i++)//Initializes random items
			{
				 System.out.println(randomPrize[i].getName());
				 prizeValue = prizeValue + randomPrize[i].getPrice();
			}
			
			System.out.println("\nYou must guess the total cost of all without going over.\nEnter your guess.");
			double guess = keyboard.nextDouble();
			
			//Determines if win or not
			if(Math.abs(prizeValue - guess) <= 2000) //Finds within 2000
				System.out.println("You guessed "+guess+" the actual price is "+prizeValue+"\nYour guess was under you win!");
			else
				System.out.println("You guessed "+guess+" the actual price is "+prizeValue+"\nThat was incorrect. You lose.");
			
			//Play Again
			System.out.println("Would you like to play again?");
			
			String answer = keyboard.next();
			System.out.println();
			
			if(answer.equalsIgnoreCase("no"))
			{
				System.out.println("Thanks for Playing!!");
				break;
			}
			
		}
	}

}
