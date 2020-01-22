/*
 * Bradley Grose
 */

public class Board {
	public String[][] gameBoard;
	public final int BOARDSIZE = 3;
	
	//Create Board
	public Board() {
		gameBoard = new String[BOARDSIZE][BOARDSIZE];
		
		clear();
	}
	
	//Clears board to new
	public void clear() {
		for(int x=0; x<BOARDSIZE; x++)
			for(int y=0; y<BOARDSIZE; y++)
			{
				gameBoard[x][y] = "";
			}
	}
	
	//Draws Board out
	public void drawBoard() {
		for(int y=0; y<BOARDSIZE; y++)
			for(int x=0; x<BOARDSIZE; x++)
			{
				if(x==0 || x==2)
					System.out.println("|" + gameBoard[x][y] + "|");
				else
					System.out.print(gameBoard[x][y]);
			}
		System.out.println();
	}
	
	/*
	 * 
	 *  VICTORY SCENEARIOS
	 *  -Horizontal
	 *  -Vertical
	 *  -Diagonal
	 */
	
	//Horizonatal
	public boolean HorVic() {
		boolean HorWin=false;
		
		//Top Row
		if(gameBoard[0][0]==gameBoard[0][1] && gameBoard[0][0]==gameBoard[0][2] && gameBoard[0][0] != "")
			HorWin = true;
		
		//Middle Row
		else if(gameBoard[1][0]==gameBoard[1][1] && gameBoard[1][0]==gameBoard[1][2] && gameBoard[1][0] != "")
			HorWin = true;
		
		//Bottom Row
		else if(gameBoard[2][0]==gameBoard[2][1] && gameBoard[2][0]==gameBoard[2][2] && gameBoard[2][0] != "")
			HorWin = true;
		
		return HorWin;
	}
	
	
	//Vertical
	public boolean VerVic() {
		boolean VerWin=false;
		
		//First Col
		if(gameBoard[0][0]==gameBoard[1][0] && gameBoard[0][0]==gameBoard[2][0] && gameBoard[0][0] != "")
			VerWin = true;
		
		//Second Col
		else if(gameBoard[0][1]==gameBoard[1][1] && gameBoard[0][1]==gameBoard[2][1] && gameBoard[0][1] != "")
			VerWin = true;
		
		//Third Col
		else if(gameBoard[0][2]==gameBoard[1][2] && gameBoard[0][2]==gameBoard[2][2] && gameBoard[0][2] != "")
			VerWin = true;
		
		return VerWin;
	}
	
	//Diagonal
	public boolean DiagVic() {
		boolean DiagWin = false;
		
		//First Col
		if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[0][0]==gameBoard[2][2] && gameBoard[0][0] != "")
			DiagWin = true;
				
		//Second Col
		else if(gameBoard[0][2]==gameBoard[1][1] && gameBoard[0][2]==gameBoard[2][0] && gameBoard[0][2] != "")
			DiagWin = true;
		
		return DiagWin;
	}
	
	
	//Checks if any way won
	public boolean checkVictory() {
		boolean win = false;
		if(DiagVic() || VerVic() || HorVic())
		{
			win = true;
		}
		return win;
	}
	
	//Check if Board Filled
	public boolean isFull() {
		boolean full = true;
		for(int y=0; y<BOARDSIZE; y++)
			for(int x=0; x<BOARDSIZE; x++)
			{
				if(gameBoard[x][y]== "")
					full = false;
			}
		return full;
	}
	
	//Sets Move
	public 
}
