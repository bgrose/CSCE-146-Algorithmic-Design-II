import java.util.Iterator;

public class LinkedListStack<T> implements StackI<T> {

	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;
	private int size;

	public LinkedListStack() {
		head = null;
		size = 0;
	}

	private class ListIterator implements Iterator<T> {
		private ListNode iCurr;

		public ListIterator(ListNode aHead) {
			iCurr = aHead;
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

	public void push(T aData) {
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
		size++;
	}

	public T pop() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}

	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}

	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	public int size() {
		return this.size;
	}

}
