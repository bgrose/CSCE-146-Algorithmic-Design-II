/*
 * Bradley Grose
 */
import java.util.Random;

public class MineCounter {

	//Creates Sizes and Amounts
	public static final int BOARDSIZE = 10;
	public static final int MINEAMOUNT = 10;
	public static Random random;
	
	//Makes Board
	public static String[][] board;
	
	
	//Runs the three boards
	public static void main(String[] args) {
		random = new Random();
		emptyboard();
		addmines();
		countmines();
	}
	
	//Creates an Empty Board
	public static void emptyboard() 
	{
		System.out.println("Creating an Empty Board");
		
		board = new String[BOARDSIZE][BOARDSIZE];
		for(int i=0; i<BOARDSIZE; i++)
		{
			for(int j=0; j<BOARDSIZE; j++)
			{
				board[i][j] = "-";
			}
		}
		
		printboard();
	}
	
	//Prints out Board
	public static void printboard() 
	{
		for(int i=0; i<BOARDSIZE; i++)
		{
			for(int j=0; j<BOARDSIZE; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	//Adds 10 mines to board random
	public static void addmines() 
	{
		System.out.println("Placing mines");
		
		int minecount = 0; //Counter
		
		do {
			int randX = random.nextInt(BOARDSIZE); //Creates Cord
			int randY = random.nextInt(BOARDSIZE);
			
			//Checks Position
			if(board[randX][randY].equals("*")) continue;
			board[randX][randY] = "*";
			minecount++;
			
		}while(minecount < MINEAMOUNT);
		
		printboard();
	}
	
	//Adds count to board
	public static void countmines() 
	{
		/*			Positioning for count
		 * 
		 *       NW N NE
		 *        W * E
		 *       SW S SE
		 * 
		 */
		System.out.println("Performing mine count");
		
		
		//Checks Each Spot
		for(int x=0; x<BOARDSIZE; x++)
		{
			for(int y=0; y<BOARDSIZE; y++)
			{
				if(board[x][y].equals("*"))continue;
				
				//Adds for Mines using binary T/F check
				int N= y != 0 && board[x][y - 1].equals("*") ? 1 : 0;
				int S = y != BOARDSIZE - 1 && board[x][y + 1].equals("*") ? 1 : 0;
				int E = x != BOARDSIZE - 1 && board[x + 1][y].equals("*") ? 1 : 0;
				int W = x != 0 && board[x - 1][y].equals("*") ? 1 : 0;
				int NE = y != 0 && x != BOARDSIZE - 1 && board[x + 1][y - 1].equals("*") ? 1 : 0;
				int NW = y != 0 && x != 0 && board[x - 1][y - 1].equals("*") ? 1 : 0;
				int SE = y != BOARDSIZE - 1 && x != BOARDSIZE - 1 && board[x + 1][y + 1].equals("*") ? 1 : 0;
				int SW = y != BOARDSIZE - 1 && x != 0 && board[x - 1][y + 1].equals("*") ? 1 : 0;

				
				board[x][y] = "" + (N+W+E+S+NE+NW+SE+SW);
			}
		}
		printboard();
		
	}
	

}
