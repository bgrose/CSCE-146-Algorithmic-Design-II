/*
 * Bradley Grose
 */

import java.util.Scanner;

public class RobotFrontEnd {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		RobotSimulation sim = new RobotSimulation();
		System.out.println("Welcome to the Robot Simulator");
		boolean trig = false; //Trig Keep going
		
		while(trig == false)
		{
			//User Input
			System.out.println("Enter file for the Board");
			String fileName = keyboard.nextLine();
			System.out.println("Enter file for the Robot Commands");
			String commName = keyboard.nextLine();
			
			//Construct Board
			System.out.println("Simulation begin");
			sim.printInit(fileName);
			sim.move(commName);
			System.out.println("Simulation End\n\nQuit? Enter \"true\" to quit or hit enter to run another simulation");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("true"))
			{
				System.out.println("Goodbye!");
				break;
			}
		}

	}

}
