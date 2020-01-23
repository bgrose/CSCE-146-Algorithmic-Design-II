/*
 * Bradley Grose
 */
import java.util.Scanner;
import java.util.Random;

public class Game {

	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Board gameBoard = new Board();
		
		
		//Coordinates Variables
		int x = 0;
		int y = 0;
		
		boolean gameOver = false;
		boolean Turn = false;
		
		System.out.println("Welcome to Tik Tak Toe");
		
		while(gameOver == false)
		{
			gameBoard.drawBoard();
			
			//Human Move
			while(Turn==false)
			{
				HumanPlay(x, y);
				Turn = gameBoard.setMove(x, y, "X");
			}
			
			//Computer Move
			System.out.println("Computer Play");
			
		}
	}
	
	public static void CompPlay(int x, int y)
	{
		Random r = new Random();
		x = r.nextInt(2);
		y = r.nextInt(2);
		
	}
	
	public static void HumanPlay(int x, int y)
	{
		System.out.println("Enter the coordinates to place an \"X\". Row then Column.\nOr enter a negative number to quit");
		x = keyboard.nextInt();
		y = keyboard.nextInt();
	}
}
