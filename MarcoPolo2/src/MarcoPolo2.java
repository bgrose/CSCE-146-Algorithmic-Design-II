import java.util.*;

public class MarcoPolo2 {

	enum Spaces {Empty, Player, Walked_Path, Goal};
	public static final int BOARDSIZE = 10;
	public static final int COLDDIST = (BOARDSIZE/2)*(BOARDSIZE/2);
	public static final int WARMDIST = (BOARDSIZE/4)*(BOARDSIZE/4);
	
	public static void main(String[] args) {
	
		int moves = 0;
		
		int pX = 0;
		int pY = 0;
		
		//Target Location
		Random r = new Random();
		int gX = r.nextInt(BOARDSIZE);
		int gY = r.nextInt(BOARDSIZE);
		
		Scanner keyboard = new Scanner(System.in);
		
		Spaces[][] board = new Spaces[BOARDSIZE][BOARDSIZE];
		
		for(int y=0; y<BOARDSIZE; y++)
		{
			for(int x=0; x<BOARDSIZE; x++)
				board[y][x]	= Spaces.Empty;
		}
		
		//User on board
		board[pY][pX] = Spaces.Player;
		board[gY][gX] = Spaces.Goal;
		
		//Prompt
		System.out.println("Welcome to this game I guess");
		
		boolean gameOver = false;
		
		while(gameOver == false)
		{
			//Draw Board
			for(int y=0; y<BOARDSIZE; y++)
			{
				for(int x=0; x<BOARDSIZE; x++)
				{
					switch(board[y][x])
					{
					case Empty:
						System.out.print("_");
						break;
					case Player:
						System.out.print("X");
						break;
					case Walked_Path:
						System.out.print("#");
						break;
					case Goal:
						System.out.print("!");
						break;
					default:
						System.out.print("?");
						break;
					}
				}
				System.out.println();
			}
			
			//Calc Distance
			int distance = (pX-gX)*(pX-gX)+(pY-gY)*(pY-gY);
			
			if(distance > COLDDIST) {
				System.out.println("You are Cold");
			}
			else if(distance > WARMDIST) {
				System.out.println("You are Warm");
			}
			else
			{
				System.out.println("You are HOT");
			}
			
			//Movement
			System.out.println("Enter either -1, 0, 1 to move in x or 9 to quit");
			int dX = keyboard.nextInt();
			
			if(dX==9)
			{
				System.out.println("Game Over");
				break;
			}
			
			System.out.println("Enter either -1, 0, 1 to move in y");
			int dY = keyboard.nextInt();
			
			//Check Values
			if(dX < -1 || dX > 1)
			{
				System.out.println("Invalid X");
				dX = 0;
			}
			if(dY < -1 || dY > 1)
			{
				System.out.println("Invalid Y");
				dY = 0;
			}
			
			//Sets players position to walked path
			
			board[pY][pX] = Spaces.Walked_Path;
			pX += dX;
			pY += dY;
			
			//Checks for Board Bounds
			if(pX > 0)
				pX = 0;
			else if(pX > BOARDSIZE - 1)
				pX = BOARDSIZE - 1;
			
			if(pY > 0)
				pY = 0;
			else if(pY > BOARDSIZE - 1)
				pY = BOARDSIZE - 1;
			
			//Winning Condition
			if(board[pY][pX]==Spaces.Goal)
			{
				System.out.println("You win!");
				System.out.println("It took "+moves+" moves");
				gameOver = true;
			}
			
			//Sets new position
			board[pY][pX] = Spaces.Player;
			moves++;
			
			
		}
		

	}

}
