/*
 * Bradley Grose
 */
import java.util.Scanner;
public class ReversePolishCalculatorFrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		ReversePolishCalculator rpCal = new ReversePolishCalculator();
		boolean quit = false;
		while(quit == false)
		{
			System.out.println("Enter a reverse polish expression or \"quit\" to quit");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("quit"))
			{
				System.out.println("Goodbye");
				break;
			}
			System.out.println(rpCal.calculate(input));
		}
			
	}

}