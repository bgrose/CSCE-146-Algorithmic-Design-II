
/*
 * Bradley Grose
 */
import java.util.*;

public class LLStack<T> implements StackInterface<T> {

	//Builds ListNodes
	private class ListNode {
		private T data;
		private ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	//Variables
	private ListNode head;
	private int size;

	//Creates the Stack
	public LLStack() {
		head = null;
		size = 0;
	}

	//Returns the size
	public int size() {
		return this.size;
	}

	//Pushes node to the top of stack
	public void push(T aData) {
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
	}
	
	//Takes element off top of stack 
	public T pop() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}

	//Displays top of the stack
	public T peek() {
		if (head == null)
			return null;
		return head.data;

	}

	//Prints the stack
	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.data);
		}

	}
}
