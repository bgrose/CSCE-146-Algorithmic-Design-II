/*
 * BRadley Grose
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grader {
	public static void main(String[] args) throws FileNotFoundException
	{
	
		System.out.println("Welcome to the Grader Program");
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			System.out.println("Enter a file name or \"quit\" to exit");
			Student stud = new Student();
			String input = keyboard.nextLine();
					if(input.contentEquals("quit"))
						break;
			stud.readValues(input);
			System.out.println(stud.toString());
			
		}
	}
	
}
