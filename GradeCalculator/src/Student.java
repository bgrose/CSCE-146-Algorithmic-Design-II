/*
 * Bradley Grose
 */

import java.util.*;
import java.io.*;

public class Student {
	
	
	//Instance Variables
	private double labSum;
	private double labCount;
	private double labRSum;
	private double labRCount;
	private double hwSum;
	private double hwCount;
	private double exam01;
	private double exam02;
	private double finalExam;
	
	//Contructor
	public Student()
	{
		 labSum = 0;
		 labCount = 0;
		 labRSum = 0;
		 labRCount = 0;
		 hwSum = 0;
		 hwCount = 0;
		 exam01 = 0;
		 exam02 = 0;
		 finalExam = 0;
	}
	
	//Getters
	public double getLabAverage()
	{
		return this.labSum/this.labCount;
	}
	public double getLabReportAverage()
	{
		return this.labRSum/this.labRCount;
	}
	public double getHomeworkAverage()
	{
		return this.hwSum/this.hwCount;
	}
	public double getExam01()
	{
		return this.exam01;
	}
	public double getExam02()
	{
		return this.exam02;
	}
	public double getFinal()
	{
		return this.finalExam;
	}
	
	//Add Grades
	public void addGrade(String aSection, double aGrade)
	{
		if(aSection.equalsIgnoreCase(AssignmentType.LABS))
		{
			this.labSum += aGrade;
			this.labCount++;
		}
		else if(aSection.equalsIgnoreCase(AssignmentType.LAB_REPORTS))
		{
			this.labRSum += aGrade;
			this.labRCount++;
		}
		else if(aSection.equalsIgnoreCase(AssignmentType.HOMEWORK))
		{
			this.hwSum += aGrade;
			this.hwCount++;
		}
		else if(aSection.equalsIgnoreCase(AssignmentType.FINAL))
		{
			this.finalExam = aGrade;
		}
		else if(aSection.equalsIgnoreCase(AssignmentType.EXAM01))
		{
			this.exam01 = aGrade;
		}
		else if(aSection.equalsIgnoreCase(AssignmentType.EXAM02))
		{
			this.exam02 = aGrade;
		}
			
	}
	
	//Get Grades
	public double getGradeNumeric()
	{
		double ret = 0;
		ret += (this.getLabAverage()*.10)+
				(this.getLabReportAverage()*.10)+
				(this.getHomeworkAverage()*.20);
		
		//Find highest grade
		if(this.getFinal()>=this.getExam01() && this.getExam02() >= this.getExam01())
		{
			ret+=(this.getFinal()*.30)+(this.getExam02()*.30);
		}
		else if(this.getExam01()>this.getExam02() && this.getFinal()>this.getExam02())
		{
			ret+=(this.getExam01()*.30)+(this.getFinal()*.30);
		}
		else
		{
			ret+=(this.getExam02()*.30)+(this.getExam01()*.30);
		}
		
		return ret;
	}
	
	public double getGradeRounded()
	{
		return Math.ceil(this.getGradeNumeric());
	}
	
	public String getGradeLetter()
	{
		String ret = "F";
		double grade = getGradeRounded();
		
		if(grade>=90)
			ret = "A";
		else if(grade>=85)
			ret = "B+";
		else if(grade>=80)
			ret = "B";
		else if(grade>=75)
			ret = "C+";
		else if(grade>=70)
			ret = "C";
		else if(grade>=65)
			ret = "D+";
		else if(grade>=60)
			ret = "D";
		else
			ret = "F";
		
		
		return ret;
	}
	
	public void readValues(String path) throws FileNotFoundException 
	{
		Scanner filein = new Scanner(new File(path));
		String currLine;
		
		while(filein.hasNextLine())
		{
			currLine = filein.nextLine();
			String [] grades = currLine.split("\t");
			
			addGrade(grades[0], Double.parseDouble(grades[1]));
			
		}
		
		
		filein.close();
	}
	
	private double parseDouble(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString()
	{
		return "Lab Average: "+this.getLabAverage()+"\nLab Report Average: "+this.getLabReportAverage()+
				"\nHomework Average: "+this.getHomeworkAverage()+"\nExam 1 Score: "+this.getExam01()+
				"\nExam 2 Score: "+this.getExam02()+"\nFinal Exam: "+this.getFinal()+"\nRaw Total: "+
				this.getGradeNumeric()+"\nAdjusted: "+this.getGradeRounded()+"\n Grade: "+this.getGradeLetter();
	}
}
