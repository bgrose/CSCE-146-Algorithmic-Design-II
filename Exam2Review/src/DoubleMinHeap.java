
public class DoubleMinHeap {
	
	private double[] heap;
	private int lastIndex; // First Null
	
	public void add(double aData) {
		if (lastIndex >= heap.length)
			return;
		heap[lastIndex] = aData;
		bubbleUp();
		lastIndex++;
	}

	private void bubbleUp() {
		int index = lastIndex;
		while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
			// Swap
			double temp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = heap[index];
			heap[index] = temp;
			index = (index - 1) / 2;

		}

	}
}
