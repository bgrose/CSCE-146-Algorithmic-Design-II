/*
 * Generic Linked List By Bradley Grose
 */

import java.util.Iterator;

public class GenLL<T> implements Iterable<T> { // implements Iterable<T> allows for each loop

	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	public class ListIterator implements Iterator<T> {
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

	private ListNode head; // First Element
	private ListNode curr; // Current Data Element
	private ListNode prev; // One Node behind current
	// private ListNode tail; //Always Last Element

	public GenLL() {
		head = curr = prev = null;
	}

	// Use to do for each loops
	public Iterator<T> iterator() {
		return new ListIterator(head);
	}

	public void add(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = curr = newNode;
			return;
		}
		ListNode temp = head;
		while (temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}

	public void removeCurrent() {
		if (curr != null && prev == null) {
			head = head.link;
			curr = head;
		} else if (curr != null && prev != null) {
			prev.link = curr.link;
			curr = curr.link;

		}
	}

	public void goToNext() {
		if (curr != null)
			curr = curr.link;
	}

	public void resetCurrent() {
		curr = head;
	}

	public T getCurrent() {
		if (curr != null)
			return curr.data;
		return null;
	}

	public void setCurrent(T aData) {
		if (curr != null)
			curr.data = aData;
	}

	public boolean hasMore() {
		return curr != null;
	}

	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	public static void main(String[] args) {
		GenLL<String> sLL = new GenLL<String>();
		for (int i = 0; i < 10; i++)
			sLL.add("String " + i);
		for (String s : sLL)
			System.out.println(s);

	}
}
