/*
 * Bradley Grose
 */
public class Fruit implements Comparable<Fruit>{

	private double weight;
	private String type;
	
	public Fruit()
	{
		this.weight = 1.00;
		this.type = "none";
	}
	
	public Fruit(String aT, double aW )
	{
		setWeight(aW);
		setType(aT);
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		if(weight <= 0.0)
			this.weight = 1.0;
		else
			this.weight = weight;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		if(type==null)
			this.type = "none";
		else
			this.type = type;
	}
	
	public String toString()
	{
		return this.type+" "+this.weight;
	}
	
	public int compareTo(Fruit o) {
		if(o == null)
			return 0; //Object is Null
		if(this.weight > o.getWeight())
			return 1;
		else if(this.weight < o.getWeight())
			return -1;
		else
			return 0;
	}
	
	
	
}
