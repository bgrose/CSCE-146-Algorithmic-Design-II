
/*
 * Bradley Grose
 */
import java.util.*;

public class LLStack<T> implements StackInterface<T> {

	// Builds ListNodes
	private class ListNode {
		private T data;
		private ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	// iterator
	private class ListIterator implements Iterator<T> {
		private ListNode iCurr;

		public ListIterator(ListNode head) {
			iCurr = head;
		}

		public boolean hasNext() {
			return iCurr != null;
		}

		public T next() {
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
	}

	public Iterator iterator() {
		return new ListIterator(head);
	}

	// Variables
	private ListNode head;
	private int size;

	// Creates the Stack
	public LLStack() {
		head = null;
		size = 0;
	}

	// Returns the size
	public int size() {
		return this.size;
	}

	// Pushes node to the top of stack
	public void push(T aData) {
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
		size++;
	}

	// Takes element off top of stack
	public T pop() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}

	// Displays top of the stack
	public T peek() {
		if (head == null)
			return null;
		return head.data;

	}

	// Prints the stack
	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}

	}
}
