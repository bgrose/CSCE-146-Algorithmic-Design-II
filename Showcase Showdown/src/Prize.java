/*
 * Bradley Grose
 */
public class Prize {
	
	//Instance Variables
	private double price;
	private String name;
	
	//Constructors
	public Prize() {
	
	}
	
	public Prize(double price, String name) {
		this.price = price;
		this.name = name;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
