/*
 * Bradley Grose
 */

//Imports
import java.util.Random;
import java.io.*;

public class Showcase {
	
	//Declarations
	public Prize prizes[];
	public static final int POOL = 50;
	public static final int PRIZE = 5;
	
	//Constructor
	public Showcase() { //Creats array with all the prizes
		prizes = new Prize[POOL];
		readfile();
	}
	
	
	@SuppressWarnings("null")
	public void readfile()
	{
		BufferedReader fileScanner = null; //Allows to use read line
		int count = 0; //Counter
		
	try {
		fileScanner = new BufferedReader(new FileReader("prizeList.txt"));
		String line;
		while((line = fileScanner.readLine()) != null)

		{
			if(!line.trim().contentEquals("")) //Makes sure there is content
			{
				String input[] = line.split("\\s+"); //Splits
				String prizeName = input[0]+" ";
				
				for(int i=1; i<input.length - 1; i++)
					prizeName = prizeName + input[i]+" ";
				double prizePrice = Double.parseDouble(input[input.length -1]);
				prizes[count++] = new Prize(prizePrice, prizeName); //Adds to counter
				
				if(count == PRIZE)
					break;
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
	
	public Prize[] randomPrize() //Creates an array with 5 random prizes
	{
		Random r = new Random();
		Prize randomPrizes[] = new Prize[PRIZE];
		for(int i=0; i<PRIZE; i++)
		{
			int ran = r.nextInt(POOL);
			randomPrizes[i] = prizes[ran];
		}
		
		return randomPrizes;
	}
	
}
