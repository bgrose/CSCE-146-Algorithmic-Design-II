/*
 * CSCE 146 Exam02 Question04
 * Provided code
 * Make sure this at least compiles
 * You may write additional methods to help
 */

/*
 * Bradley Grose
 */
public class StringMaxHeap 
{
	//Do not alter---------------------
	public String[] heap;
	public static final int DEF_SIZE = 127;//This is public for testing purposes
	private int lastIndex;//First null element
	public StringMaxHeap()
	{
		heap = new String[DEF_SIZE];
		this.lastIndex = 0;//Assume tree is rooted at index 0
	}
	//---------------------------------
	public void add(String aData)
	{
		if (lastIndex >= heap.length)
			return;
		heap[lastIndex] = aData;
		bubbleUp();
		lastIndex++;
	}

	private void bubbleUp() {
		int index = lastIndex;
		while (index > 0 && heap[(index - 1) / 2].compareTo(heap[index]) < 0) {
			// Swap
			String temp = heap[(index - 1) / 2];
			heap[(index - 1) / 2] = heap[index];
			heap[index] = temp;
			index = (index - 1) / 2;
		}
	}		
}

