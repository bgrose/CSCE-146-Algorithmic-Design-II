/*
 * Bradley Grosr
 */
public class GenCircLinkedList <T> {

	//Class for ListNode
	class ListNode{
		T data;
		ListNode link;
		
		public ListNode(T data, ListNode link)
		{
			this.data = data;
			this.link = link;
		}
	}
	
	//Define Values
	private ListNode head, prev, curr, tail;
	private int size;

	//Make List
	public GenCircLinkedList()
	{
		head = new ListNode(null, null);
		curr = head = tail;
	}
	
	//Goes to Next Value
	public void goToNext() {
	
		if(curr != null && curr == tail) //Loops if at tail
		{
			prev = curr;
			curr = head;
		}
		else if(curr != null) //Continues
		{
			prev = curr; 
			curr = curr.link; 
		}
	}
	
	
	
	
}
