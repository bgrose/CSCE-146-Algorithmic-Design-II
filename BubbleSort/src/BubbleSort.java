import java.util.*;

public class BubbleSort {

	public static final int RANDOMRANGE = 10;
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] a = new int[5];
		
		for(int i=0; i<a.length; i++)
			a[i] = r.nextInt(RANDOMRANGE);
		printArray(a);
		
		//Bubble Sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0; i<a.length-1; i++)
			{
				if(a[i] > a[i+1])
				{
					hasSwapped=true;
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					
				}
			}
		}
		printArray(a);
	}
	
	public static void printArray(int[] cat)
	{
		for(int i : cat)
		{
			System.out.println(i);
		}
		System.out.println();
	}

}
