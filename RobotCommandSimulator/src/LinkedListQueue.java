/*
 * Bradley Grose
 */

public class LinkedListQueue<T> implements LLInterface<T> {

	// Creates Listnode
	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	// Holders
	private ListNode head;
	private ListNode tail;

	// Creates List
	public LinkedListQueue() {
		head = tail = null;
	}

	// Pushes to top of queue
	public void enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}

	// removed from queue
	public T dequeue() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}

	// gets top of queue
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}

//prints out queue
	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

}
