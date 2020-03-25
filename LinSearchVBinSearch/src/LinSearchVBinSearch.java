/*
 * Bradley Grose
 */

import java.util.Random;

public class LinSearchVBinSearch {

	//Sizers
	public static final int MAXTESTS = 20;
	public static final int ARRAYSIZE = 1000;
	
	//Counters
	public static int linCount = 0;
	public static int binCount = 0;
	public static int totalLin = 0;
	public static int totalBin = 0;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the search tester.  We are going to see which algorithm performs the best out of 20 tests");
		for(int i=0; i<MAXTESTS; i++)
		{
			System.out.println("------------------------------\nTest "+i+"\n------------------------------"); //Header
			test();
		}
		System.out.println("------------------------------\nResults\n------------------------------"); //Header
		System.out.println("On average linear search took: "+ totalLin / MAXTESTS + " Checks");
		System.out.println("On average binary search took: "+ totalBin / MAXTESTS + " Checks");
	}

	public static void test()
	{
		linCount = binCount = 0;
		int[] sortedArray = genRandSortArray();
		Random r = new Random();
		int target = r.nextInt(ARRAYSIZE);
		System.out.println("Searching using linear search. Found? " + linSearch(sortedArray, target));
		System.out.println("Searching using binary search. Found? "+ binSearch(sortedArray, target, 0, sortedArray.length - 1));
		System.out.println("Linear Checks: "+linCount);
		System.out.println("Binaey Checks: "+binCount);
		totalLin += linCount;
		totalBin += binCount;
	}
	
	public static int[] genRandSortArray()
	{
		int[] ret = new int[ARRAYSIZE];
		Random r = new Random();
		for(int i=0; i<ret.length; i++)
			ret[i] = r.nextInt(ARRAYSIZE);
		quickSort(ret, 0, ret.length - 1);
		return ret;
	}
	
	public static void quickSort(int[] a, int start, int end)
	{
		int part = partition(a, start, end);
		if(start < part - 1)
			quickSort(a,start,part-1);
		if(part <end)
			quickSort(a,part,end);
	}
	
	public static int partition(int[] a, int start, int end)
	{
		int i = start;
		int j = end;
		int mid = (end+start)/2;
		int piv = a[mid];
		while(i<=j)
		{
			while(a[i] < piv)
				i++;
			while(a[j] > piv)
				j--;
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static boolean linSearch(int[] a, int target)
	{
		for(int i=0; i< a.length; i++)
		{
			linCount++;
			if(a[i] == target)
				return true;
		}
		return false;
	}
	
	public static boolean binSearch(int[] a, int target, int start, int end)
	{
		if(start > end)
			return false;
		int mid = (start+end) / 2;
		binCount++;
		if (a[mid] == target)
			return true;
		else if(target < a[mid])
			return binSearch(a, target, start, mid -1);
		else
			return binSearch(a, target, mid + 1, end);
	}
}
