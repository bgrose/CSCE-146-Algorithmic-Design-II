/*
 * Bradley Grose
 */
import java.util.*;

public class ReversePolishCalculator {

	public StackInterface<Integer> valueStack;
	
	//Constructor
	public ReversePolishCalculator()
	{
		valueStack = new LLStack<Integer>();
	}
	
	//Calculate the Values
	public int calculate(String input)
	{
		Scanner scan = new Scanner(input);
		
		while(scan.hasNext())
		{
			String str = scan.next();
			if(str.equals("+")) //adds the numbers
			{
				if(check())
					return 0;
				int num1 = valueStack.pop();
				int num2 = valueStack.pop();
				valueStack.push(num1+num2);
			}
			else if(str.equals("-")) //subtract number
			{
				if(check())
					return 0;
				int num1 = valueStack.pop();
				int num2 = valueStack.pop();
				valueStack.push(num2-num1);
			}
			else if(str.equals("*")) //multiplies numbers
			{
				if(check())
					return 0;
				int num1 = valueStack.pop();
				int num2 = valueStack.pop();
				valueStack.push(num1*num2);
			}
			else if(str.equals("/")) //Divides numbers
			{
				if(check())
					return 0;
				int num1 = valueStack.pop();
				int num2 = valueStack.pop();
				if(num2 ==0)
				{
					System.out.println("Cant divide by 0");
					return 0;
				}
				valueStack.push(num1/num2);
			}
			else
			{
				try
				{
					valueStack.push(Integer.parseInt(str));
				}
				catch(Exception e)
				{
					return 0;
				}
			}
		}
		if(valueStack.size() == 1)
			return valueStack.pop();
		System.out.println("This was not properly formatted. There were too many numbers and not enough operators.");
		clearStack();
		return 0;
	}
	
	public boolean check()//Checks to find valid operation
	{
		if(valueStack.size()>=2)
			return false;
		System.out.println("This was not properly formatted. There were too many operators and not enough numbers");
		return true;
	}
	public void clearStack()//Clears to restart the stack
	{
		while(valueStack.peek() != null)
		{
			valueStack.pop();
		}
	}
}
