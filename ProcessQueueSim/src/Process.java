/*
 * Bradley Grose
 */
public class Process {

	private String name;
	private double completionTime;

	public Process() {
		this.name = "";
		this.completionTime = 0.0;
	}

	public Process(String aName, Double aComp) {
		setName(aName);
		setCompletionTime(aComp);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the completionTime
	 */
	public double getCompletionTime() {
		return completionTime;
	}

	/**
	 * @param completionTime the completionTime to set
	 */
	public void setCompletionTime(double completionTime) {
		if (completionTime > 0)
			this.completionTime = completionTime;
		else
			this.completionTime = 0.0;
	}

	// Prints out
	public String toString() {
		return "Process Name: " + name + ", Completion Time: " + completionTime;
	}

}
