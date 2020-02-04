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
	
	//Resets to head
	public void resetCurrent()
	{
		curr = head;
		prev = tail;
	}
	
	public T getDataAtCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	
	public void setDataAtCurr(T data)
	{
		if(curr!=null)
			curr.data = data;
	}
	
	//Add Player
	public void add(T data)
	{
		ListNode newNode = new ListNode(data, null);
		
		if(head == null || head.data == null)
		{
			head = curr = tail = newNode;
			size++;
			return;
		}
		if (head!= tail) 
			tail.link = newNode;
		else
			head.link = newNode;
		
		tail = newNode;
		newNode.link = head;
		size ++;
	}
	
	//Used to Delete and relink circle
	public void goToPrev()
	{
		if(curr != null && prev != null)
		{
			ListNode probe = head;
			while(probe.link != prev && probe.link != curr)
			{
				probe = probe.link;
			}
			
			prev = probe;
			curr = prev;
		}
			
	}
	
	//Deletes Current Player
	public void delete(){
		if(curr == null)
			return;
		if(curr != head && curr != tail)
		{
			ListNode temp = curr.link;
			curr.link = null;
			goToPrev();
			curr.link = temp;
		}
		else if (curr == head)
		{
			ListNode temp = head.link;
			tail.link = temp;
			head = curr = temp;
		}
		else if (curr == tail)
		{
			tail.link = null;
			goToPrev();
			curr.link = head;
		}
		
		size--;
	}
	
	//Getters
	public ListNode getCurrent() {
		return curr;
	}
	
	public int getSize() {
		return this.size;
	}
	
	
	
	
	
	
}
