/*
 * Bradley Grose
 */
public class ArrayQueue<T> implements QueueI<T> {

	private T[] queue;
	private int tailIndex; // First null element
	private int headIndex;
	public static final int DEFSIZE = 100;

	public ArrayQueue() {
		init(DEFSIZE);
	}

	public ArrayQueue(int size) {
		init(size);
	}

	@SuppressWarnings("unchecked")
	private void init(int size) {
		if (size <= 0) {
			init(DEFSIZE);
			return;
		}
		tailIndex = headIndex = 0;
		queue = (T[]) (new Object[size]);
	}

	public void enqueue(T aData) {
		if (queue[queue.length - 1] != null && tailIndex == headIndex)
			return;
		queue[tailIndex] = aData;
		tailIndex = (tailIndex + 1) % queue.length;
	}

	public T dequeue() {
		T ret = queue[headIndex];
		headIndex = (headIndex + 1) % queue.length;
		return ret;
	}

	public T peek() {
		return queue[0];
	}

	public void print() {
		for (int i = headIndex; i != tailIndex; i = (i + 1) % queue.length)
			System.out.println(queue[i]);
	}
}
