/*
 * Bradley Grose
 */
public class ProcessHeap {

	private Process[] heap;
	public static final int DEFSIZE = 127;
	private int size; //last null index
	
	public ProcessHeap()
	{
		init(DEFSIZE);
	}
	
	public ProcessHeap(int aS)
	{
		init(aS);
	}
	
	private void init(int aS)
	{
		if(aS > 0)
		{
			heap = new Process[aS];
			this.size = 0;
		}
		else
			init(DEFSIZE);
	}
	
	public void add(Process aP)
	{
		if(size >= heap.length)
			return;
		heap[size] = aP;
		this.bubbleUp();
		size++;
	}
	private void bubbleUp()
	{
		int index = this.size;
		while(index > 0 && 
				heap[(index-1)/2].compareTo(heap[index]) > 0)
		{
			Process temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	
	public Process peek()
	{
		return heap[0];
	}
	
	public Process remove()
	{
		if(peek() == null) //No Element
			return null;
		Process ret = peek();
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		this.bubbleDown();
		return ret;
	}
	
	private void bubbleDown()
	{
		int index = 0;
		while(index*2+1 < size)
		{
			int bigIndex = index*2+1;
			if(index*2+2 < size &&
					heap[index*2+2].compareTo(heap[index*2+2]) > 0)
				bigIndex = index*2+2;
			if(heap[index].compareTo(heap[bigIndex]) < 0)
			{
				Process temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;
			index = bigIndex;	
		}
	}
	
	public void printHeap()
	{
		for(Process p: heap)
		{
			if(p == null)
				break;
			System.out.println(p);
		}
	}
	
	public boolean isEmpty()
	{
		return heap[0] == null;
		
	}
	
}
