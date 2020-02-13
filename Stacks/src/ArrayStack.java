
public class ArrayStack<T> implements StackI<T> {

	private T[] stack;
	public static final int SIZE = 100;
	private int headIndex;

	public ArrayStack() {

	}

	public ArrayStack(int size) {

	}

	private void init(int size) {
		if (size <= 0) {
			init(SIZE);
			return;
		}
		headIndex = 0;
		stack = (T[]) (new Object[size]);

	}

	public void push(T aData) {
		if (stack[stack.length - 1] != null)
			return;
		stack[headIndex] = aData;
		headIndex++;
	}

	public T pop() {
		if (headIndex == 0)
			return null;
		T ret = stack[headIndex - 1];
		headIndex--;
		return ret;
	}

	public T peek() {
		if (headIndex == 0)
			return null;
		return stack[headIndex - 1];
	}

	public void print() {
		for (int i = headIndex - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
}
