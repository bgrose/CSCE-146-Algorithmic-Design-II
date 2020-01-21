/*
 * Bradley Grose
 */

import java.util.*;

public class WordHelper {
	
	//Sorts by Vowels
	public static String[] sortByVowels(String[] words)
	{
		String[] wordsVowels = new String[words.length];
		
		//Makes a copy
		for(int i=0; i<words.length; i++)
		{
			wordsVowels[i] = words[i];
		}
		
		//Bubble Sort for Vowels
		boolean hasSwapped = true;
		while(hasSwapped==true)
		{
			hasSwapped = false; //Runs as a check
				
				//Checks Each index
				for(int i=0; i<wordsVowels.length-1; i++)
				{
					if(numVow(wordsVowels[i]) > numVow(wordsVowels[i+1]))
					{
						String temp = wordsVowels[i];
						wordsVowels[i] = wordsVowels[i+1];
						wordsVowels[i+1] = temp;
						hasSwapped=true;
					}
				}
		}
	
		return wordsVowels;
	}
	
	//Sort by consonants
	public static String[] sortByConsonants(String[] words)
	{
		String[] wordsCon = new String[words.length];
		
		//Makes a copy
		for(int i=0; i<words.length; i++)
		{
			wordsCon[i] = words[i];
		}
		
		//Bubble Sort for Consonants
		boolean hasSwapped = true;
		while(hasSwapped==true)
		{
			hasSwapped = false; //Runs as a check
				
				//Checks Each index
				for(int i=0; i<wordsCon.length-1; i++)
				{
					if(numCon(wordsCon[i]) > numCon(wordsCon[i+1]))
					{
						String temp = wordsCon[i];
						wordsCon[i] = wordsCon[i+1];
						wordsCon[i+1] = temp;
						hasSwapped=true;
					}
				}
		}
	
		return wordsCon;
	}
	
	//Sorts by Length
	public static String[] sortByLength(String[] words)
	{
		String[] wordsLength = new String[words.length];
		
		//Makes a copy
		for(int i=0; i<words.length; i++)
		{
			wordsLength[i] = words[i];
		}
		
		//Bubble Sort for Length
		boolean hasSwapped = true;
		while(hasSwapped==true)
		{
			hasSwapped = false; //Runs as a check
				
				//Checks Each index
				for(int i=0; i<wordsLength.length-1; i++)
				{
					if(wordsLength[i].length() > wordsLength[i+1].length())
					{
						String temp = wordsLength[i];
						wordsLength[i] = wordsLength[i+1];
						wordsLength[i+1] = temp;
						hasSwapped=true;
					}
				}
		
		}
		return wordsLength;
	}
	
	//Counts vowel numbers
	public static int numVow(String aWord)
	{
		int vowels = 0;
		for(int i=0; i<aWord.length(); i++)
		{
			if(aWord.charAt(i) == 'a' ||
					aWord.charAt(i) == 'e' ||
					aWord.charAt(i) == 'i' ||
					aWord.charAt(i) == 'o' ||
					aWord.charAt(i) == 'u' ||
					aWord.charAt(i) == 'y')
			{
				vowels++;
			}
				
		}
		
		return vowels;
	}
	
	//Counts consonants
	public static int numCon(String aWord)
	{
		int con = 0;
		for(int i=0; i<aWord.length(); i++)
		{
			if(aWord.charAt(i) != 'a' ||
					aWord.charAt(i) != 'e' ||
					aWord.charAt(i) != 'i' ||
					aWord.charAt(i) != 'o' ||
					aWord.charAt(i) != 'u' ||
					aWord.charAt(i) != 'y')
			{
				con++;
			}
				
		}
		
		return con;
	}
}

