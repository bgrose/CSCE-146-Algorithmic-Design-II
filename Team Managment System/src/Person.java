
public class Person {

	//Instance Variables
	private String name;
	
	//Constructors
	public Person()
	{
		this.name = "none";
	}
	public Person(String aName)
	{
		setName(aName);
	}
	
	//Setters
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	//Getters
	public String getName()
	{
		return this.name;
	}
	
	//Other methods
	public String toString()
	{
		return "Name: "+this.name;
	}
	
	public boolean equals(Person aPerson)
	{
		return aPerson!=null &&
				this.name.equals(aPerson.getName());
	}
	
	
}
