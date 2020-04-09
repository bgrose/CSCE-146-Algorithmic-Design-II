/*
 * Bradley Grose
 */
public class Process implements Comparable<Process> {

	private int priority;
	private double time;
	private String name;

	public Process() {
		this.priority = 0;
		this.time = 0.0;
		this.name = "none";
	}

	public Process(String aN, int aP, double aT) {
		this.setName(aN);
		this.setPriority(aP);
		this.setTime(aT);
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		if (priority >= 0)
			this.priority = priority;
		else
			this.priority = 0;
	}

	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(double time) {
		if (time >= 0.0)
			this.time = time;
		else
			this.time = 0.0;
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
		if (name == null)
			this.name = "none";
		else
			this.name = name;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + " Time: " + this.time + " Priority: " + this.priority;
	}

	@Override
	public int compareTo(Process aP) {
		if (aP == null)
			return 0;
		if (this.priority < aP.getPriority()) // Less than other
			return -1;
		else if (this.priority > aP.getPriority()) // Greater than
			return 1;
		else // equal to
			return 0;

	}

}
