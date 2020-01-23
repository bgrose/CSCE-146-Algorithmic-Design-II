/*
 * Bradley Grose
 */

import java.util.Scanner;

public class Game {

	public final int BOARDSIZE = 3;
	
	public void printBoard(char[][] board)
	{
		System.out.println("   |     0    |     1    |    2     |");
	       System.out.println("_____________________________________");
	       System.out.println("0  |     "+board[0][0]+"    |     "+board[1][0]+"    |    "+board[2][0]+"     |");
	       System.out.println("_____________________________________");
	       System.out.println("1  |     "+board[0][1]+"    |     "+board[1][1]+"    |    "+board[2][1]+"     |");
	       System.out.println("_____________________________________");
	       System.out.println("2  |     "+board[0][2]+"    |     "+board[1][2]+"    |    "+board[2][2]+"     |");
	       System.out.println();
	}
	
	//Clears board to new
		public void clear(char[][] board) {
			for(int x=0; x<BOARDSIZE; x++)
				for(int y=0; y<BOARDSIZE; y++)
				{
					board[x][y] = ' ';
				}
		}
		
		//Checks all the ways to win the game
		
		/*
		 * True = Win
		 * False = No Win
		 */
		public boolean winWays(char i, char[][] board)
		{
			
			//Verticle Wins
		    if(board[0][0] == i && board[1][0] == i && board[2][0] == i)
				return true;
		    else if(board[0][1] == i && board[1][1] == i && board[2][1] == i)
				return true;
		    else if(board[0][2] == i && board[1][2] == i && board[2][2] == i)
				return true;
		    
		    //Horizontal Wins
		    if(board[0][0] == i && board[0][1] == i && board[0][2] == i)
				return true;
		    else if(board[1][0] == i && board[1][1] == i && board[1][2] == i)
				return true;
		    else if(board[2][0] == i && board[2][1] == i && board[2][2] == i)
				return true;
		    
		    
		    //Diagonal Wins
		    if(board[0][0] == i && board[1][1] == i && board[2][2] == i)
				return true;
		    else if(board[0][2] == i && board[1][1] == i && board[2][0] == i)
				return true;
		    else //No Wins found
		    return false;
		}
		public int winCheck(int winCount, char[][] board)//Checks for Wins/Loss by Human or CAT (Tie)
		{
			Scanner keyboard = new Scanner(System.in);
			
			boolean HumanWin = winWays('X', board);
			if(HumanWin)
			{
				printBoard(board);
				System.out.println("You win!\nThe computer demands a rematch!");
				winCount++;
				clear(board);
				return winCount;
			}		
			
			//If Computer Wins then the game allows the user to quit or reset 
			
			boolean CompWin = winWays('O', board);
			if(CompWin) 
			{
				printBoard(board);
				System.out.println("You lost but you won "+winCount+" in a row.\n\nWould you like to play again? Yes or No?");
				String answer = keyboard.nextLine();
				if(answer.equalsIgnoreCase("Yes")) //Play Again Reset
				{
					winCount = 0;
					clear(board);
					return winCount;
				}
				else //Quits Game
				{
					System.out.println("Goodbye!");
					System.exit(0);
				}
			}
			
			boolean tie = tieCond(board); //Tie Condition (No open spaces)
			if(tie)
			{
				System.out.println("Tie Game! Try again.");
				clear(board);
				printBoard(board);
				return winCount;
			}
			return winCount;  //Fail Safe for if user wins or if doesnt pick up
					
		}
		
		public boolean tieCond(char[][] board)
		{
			for(int y=0; y<BOARDSIZE; y++)
				for(int x=0; x<BOARDSIZE; x++)
					if(board[y][x] == ' ')
						return false;
			return true;
		}
		
}
