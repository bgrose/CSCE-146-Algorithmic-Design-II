/*
 * Bradley Grose
 */
import java.util.Random;

public class MineCounter {

	public static final int BOARDSIZE = 10;
	public static final int MINEAMOUNT = 10;
	public static Random random;
	//Makes Board
	public static String[][] board = new String[BOARDSIZE][BOARDSIZE];
	
	public static void main(String[] args) {
		random = new Random();
		emptyboard();
		addmines();
		countmines();
		
		
	}
	
	
	public static void emptyboard() //Empty Board
	{
		System.out.println("Creating an Empty Board");
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<0; j++)
			{
				board[i][j] = "-";
			}
		}
		
		printboard();
	}
	
	public static void printboard() //Prints out Board
	{
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<0; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void addmines() //Adds 10 mines to board random
	{
		
	}
	
	public static void countmines() //Adds count to board
	{
		
	}
	

}
