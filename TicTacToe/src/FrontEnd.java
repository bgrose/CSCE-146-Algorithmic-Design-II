/*
 * Bradley Grose
 */

import java.util.*;

public class FrontEnd {
	
	//BOARD SIZE
	public static final int BOARDSIZE = 3;
	
	public static void main(String[] args) {
		
		//Scanners
		Scanner keyboard = new Scanner(System.in);
		
		Game ttt = new Game(); //Creates the instance of the game
		
		//Makes the Board and Win Count
		int wins = 0;
		char[][] board = new char[BOARDSIZE][BOARDSIZE];
		
		System.out.println("Welcome to this Tik Tak Toe Game");
		
		try { //Human Control with Input
			ttt.clear(board); //clears board
			ttt.printBoard(board); //Prints empty
			
			while(true) //Runs Until game quits
			{
				System.out.println("Enter the coordinates to place an \"X\". Row then Column.\nOr enter a negative number to quit.");
				int humX = keyboard.nextInt();
				int humY = keyboard.nextInt();
				
				//Checks for Player quit
				if(humX < 0 || humY < 0)
				{
					System.out.println("Thanks For Playing!");
					break;
				}
				else //Human Played
				{
					if(board[humX][humY] != ' ')
					{
						System.out.println("There is already a play there!");
						ttt.printBoard(board);
					}
					else
					{
						board[humX][humY] = 'X';
						wins = ttt.winCheck(wins, board); //Checks for win
						
						boolean comp = false;
						
						while(!comp) //RUns until a valid move is made
						{
							//Creates random location for the piece
							Random r = new Random();
							int randX = r.nextInt(BOARDSIZE);
							int randY = r.nextInt(BOARDSIZE);
							
							//Checks if spot is open
							if(board[randX][randY] != 'X' && board[randX][randY] != 'O')
							{
								board[randX][randY] = 'O';
								System.out.println("Computers Turn!");
								comp = true; //Breaks as it found a valid move
							}
							
							
						}
						
						wins = ttt.winCheck(wins, board); //Checks for Computer win
						ttt.printBoard(board); //Shows computer move
						
						
					}
				}
			}
		}
		catch(Exception e) //Error Check
		{
			e.printStackTrace();
		}
		
		
	}
}
