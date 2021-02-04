import java.util.Scanner;
import java.io.*;

public class TeamManager {

	public static final int SIZE = 30;
	
	private Person[] team;
	
	public TeamManager()
	{
		
	}
	
	public TeamManager(int size)
	{
		init(size);
	}
	
	private void init(int size)
	{
		if(size <= 0)
			init(SIZE);
	}
	
	
	public void add(Person p)
	{
		if(team[team.length-1] != null)
			return;
		
		for(int i=0; i<team.length; i++)
		{
			if(team[i] == null)
			{
				team[i] = p;
				break;
			}
		}
	}
	
	public void remove(Person p)
	{
		int rmIndex = getIndex(p);
		if(rmIndex == -1)
			return;
		for(int i=rmIndex; i<team.length-1; i++)
			team[i] = team[i+1];
		team[team.length-1] = null;
	}
	private int getIndex(Person p)
	{
		int ret = -1;
		for(int i=0; i<team.length; i++)
		{
			if(team[i] != null && p.equals(team[i]))
				return i;
		}
		return ret;
	}
	
	public void print()
	{
		for(Person p : team)
			if(p != null)
				System.out.println(p);
			else
				break;
		
	}
	/*
	 * HEADER
	 * Num People\t<<# of people>>\n
	 * BODY 
	 * <<type>>\t<<name>>\n
	 * <<type>>\t<<name>>\t<<id>>\n
	 * <<type>>\t<<name>>\t<<id>>\t<<level>>\n
	 */
	
	public static final String DELIM = "\t";
	public void printToFile(String aFilename)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new File(aFilename));
			//Print Header
			fileWriter.println("Num Perople"+DELIM+team.length);
			//Print Body
			for(Person p : team)
			{
				if(p == null)
					break;
				if(p.getClass().equals("Person:"))
					fileWriter.println(p.getClass()+DELIM+p.getName());
				else if(p.getClass().equals("Student"))
				{
					Student s =(Student)p;
					fileWriter.println(s.getClass()+DELIM+s.getName()+DELIM+s.getId());
				}
			}
			fileWriter.close(); //IMPORTANT
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void readFile(String aFileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFileName));
			String fileLine = fileScanner.nextLine();
			String[] splitLine = fileLine.split(DELIM);
			if(splitLine.length != 2)
			{
				return;
			}
			int size = Integer.parseInt(splitLine[1]);
			init(size);
			while(fileScanner.hasNextLine())
			{
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split(DELIM);
				if(splitLine[0].equals("Students"))
				{
					String name = splitLine[1];
					int id = Integer.parseInt(splitLine[2]);
					//add(new Student(name,id));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
