/*
 * Bradley Grose
 */
public class ProcessScheduler {

	private LinkedListQueue<Process> processes; // Creates Queue LL
	private Process currProcess;

	public ProcessScheduler() {
		this.processes = new LinkedListQueue<Process>();
		this.currProcess = null;
	}

	// Returns Current Process
	public Process getCurrentProcess() {
		return currProcess;
	}

	// Adds a Process to Queue
	public void addProcess(Process aProcess) {
		if (currProcess == null)
			currProcess = aProcess;
		else
			processes.enqueue(aProcess);
	}

	// Dequeues a Process
	public void runNextProcess() {
		currProcess = processes.dequeue();
	}

	// Cancel current Process
	public void cancelCurrentProcess() {
		currProcess = processes.dequeue();
	}

	// Prints all Dats
	public void printProcessQueue() {
		processes.print();
	}
}
