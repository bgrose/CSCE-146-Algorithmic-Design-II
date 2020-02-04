/*
 * Bradley Grose
 */

import java.util.Random;
import java.util.Scanner;

public class GameFrontEnd {

	//Wait Time
	public static final int MAXTIME = 178; //Minus 2 to account for min
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		
		//Creates Linked List
		GenCircLinkedList<String> players = new GenCircLinkedList<String>();

		
		//Game Mechanics
		System.out.println("Welcome to the Hot Potato Game!");
		
		while(true) {
			int duration = 2  + r.nextInt(MAXTIME);
			
			System.out.println("Enter the number of players (2-10 Players).");
			int playerstot = keyboard.nextInt();
			if(playerstot < 2)
			{
				playerstot = 2;
				System.out.println("At least two players are needed to play; defaulting to 2 players.");
			}
			if(playerstot > 10)
			{
				playerstot = 10;
				System.out.println("Too Many Players, you are only allowed 10!");
			}
			
			keyboard.nextLine(); //Fix
			
			for (int i = 0; i < playerstot; i++) {
				System.out.println("Enter Player " + (i + 1) + "'s name:");
				players.add(keyboard.nextLine());
			}
			
			players.resetCurrent(); //Starts new counters

			
			//Mechanics
			while(players.getCurrent()!=null && players.getSize() > 1) //Will escape with 1 person left
			{
				System.out.println(players.getDataAtCurrent() + ", enter an amount of seconds from 1-10 to hold the potato for:");
				int HoldTime = Integer.parseInt(keyboard.nextLine());
				if(HoldTime < 1 || HoldTime > 10)
				{
					System.out.println("You have entered an invalid value; defaulting to 10 seconds.");
					HoldTime = 10;
				}
				
				//Game Over catch
				if(HoldTime > duration)
				{
					System.out.println("HOT POTATO "+players.getDataAtCurrent()+ " has been eliminated.");
					players.delete();
					duration = 2  + r.nextInt(MAXTIME);
				}
				else
					System.out.println(players.getDataAtCurrent() + " is safe.");
				
				duration -= HoldTime;
				players.goToNext();
			}
			
			System.out.println(players.getDataAtCurrent() + " has won the game");
			System.out.println("Would You like to play again? (y/n)");
			String answer = keyboard.nextLine();
			
			if(answer.equalsIgnoreCase("y"))
			{
				System.out.println();
				continue;
			}
			else if(answer.equalsIgnoreCase("n"))
			{
				System.out.println("Thanks for playing");
				break;
			}
			else {
				System.out.println("Not a valid answer, so you're playing again.");
				continue;
			}
			
		}
	}

}
