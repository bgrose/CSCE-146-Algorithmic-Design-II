/*
 * Written By JJ Shepherd
 */
public interface StackInterface<T> {
	public void push(T data);

	public T pop();

	public T peek();

	public void print();
}