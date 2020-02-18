
public interface StackI<T> extends Iterable<T> {

	public void push(T aData);
	public T pop();
	public T peek();
	public void print();
	public int size();
	
}
