
public class LLStack<T> implements StackI<T> {

	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head;

	public LLStack() {
		head = null;
	}

	public void push(T aData) {
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
	}

	public T pop() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}

	public T peek() {
		if (head == null)
			return null;
		return head.data;

	}

	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.data);
		}

	}

}
