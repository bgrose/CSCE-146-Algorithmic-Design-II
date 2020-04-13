
public class IntMaxHeap {

	private int[] heap;
	private int lastIndex; // First Null

	public int remove() {
		int retVal = heap[0];
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = 0;
		lastIndex--;
		bubbleDown();
		return retVal;
	}

	private void bubbleDown() {
		int index = 0;
		while (index * 2 + 1 < lastIndex) {
			int bigIndex = index * 2 + 1;
			if (index * 2 + 2 < lastIndex && heap[index * 2 + 1] < heap[index * 2 + 2])
				bigIndex = index * 2 + 2;
			if (heap[index] < (heap[bigIndex])) {
				int temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			} else
				break;
			index = bigIndex;
		}
	}
}
