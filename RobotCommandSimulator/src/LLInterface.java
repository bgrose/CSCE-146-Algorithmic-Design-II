/*
 * Bradley Grose
 */

public interface LLInterface<T> {
	public void enqueue(T aData);

	public T dequeue();

	public T peek();

	public void print();
}
