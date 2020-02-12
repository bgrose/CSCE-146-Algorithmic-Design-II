
/*
 * Bradley Grose
 */
public class LinkedListQueue<T> {

	// Create ListNodes
	public class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			this.data = aData;
			this.link = aLink;
		}
	}

	private ListNode head;
	private ListNode tail;
	private int size;

	// Constructor
	public LinkedListQueue() {
		head = tail = null;
	}

	// Process Head
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}

	// Adds to head
	public void enqueue(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = newNode;
			tail = head;
			size = 1;
			return;
		}
		this.tail.link = newNode;
		this.tail = newNode;
		size++;
	}

	// Dequeue from head
	public T dequeue() {
		if (head == null)
			return null;
		ListNode temp = head;
		head = head.link;
		size--;
		return temp.data;
	}

	// Prints data
	public void print() {
		ListNode tempNode = head;
		while (tempNode != null) {
			System.out.println(tempNode.data.toString());
			tempNode = tempNode.link;
		}
	}

}
