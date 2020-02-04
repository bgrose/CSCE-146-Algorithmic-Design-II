
/*
 * Bradley Grose
 */
public class GenDoubleLinkedList <T>{

	private class ListNode {
		private T data;
		private ListNode nextLink;
		private ListNode prevLink;
		
		
		public ListNode() { //Constructor
			data = null;
			nextLink = null;
			prevLink = null;
		}
		
		//Paramaterized
		public ListNode(T aData, ListNode aNextLink, ListNode aPrevLink)
		{
			data = aData;
			nextLink = aNextLink;
			prevLink = aPrevLink;
		}
	}
	
	//Spot Holders
	private ListNode head;
	private ListNode curr;
	
	//Constructor of List
	public GenDoubleLinkedList()
	{
		head = curr = null;
	}
	
	//Moves forward
	public void goToNext() {
		if(curr == null || curr.nextLink == null)
			return;
		curr = curr.nextLink;
	}
	
	//Goes to previous
	public void goToPrev()
	{
		if(curr == null)
			return;
		curr = curr.prevLink;
	}
	
	//Is there another one
	public boolean moreToIterate()
	{
		return curr != null &&
				curr.nextLink != null;
	}
	
	//Resets counter
	public void resetCurrent() 
	{
		curr = head;
	}
	
	//Sets data type
	public void setCurrent(T aData)
	{
		if(curr != null)
		{
			curr.data = aData;
		}
	}
	
	//Get data
	public T getCurrent()
	{
		if(curr == null)
			return null;
		return curr.data;
	}
	
	//Insert Data
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData,null, null);
		if(head == null) //Means List is empty
		{
			head = curr = newNode; //Creates pointer to head of list and adds newNode
			return;
		}
		
		
		ListNode temp = head; //Temp Pointer
		while(temp.nextLink != null)
		{
			temp = temp.nextLink;
		} 
		temp.nextLink = newNode; //Creates a Node at the End
		newNode.prevLink = temp;
	}
	
	//Insert After Current
	public void insertAfterCurrent(T aData)
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData, curr.nextLink, null);
		newNode.nextLink = curr.nextLink;
		newNode.prevLink = curr;
		curr.nextLink = newNode;
	}
	
	//Deletes current slot
	public void deleteCurrent()
	{
		if(curr == null)
			return;
		if(curr == head)
		{
			head = head.nextLink;
			head.prevLink = null;
			curr = head;
			return;
		}
		
		//Continued
		curr.prevLink.nextLink = curr.nextLink;
		if(curr.nextLink != null)
		{
			curr.nextLink.prevLink = curr.prevLink;
		}
		curr = curr.nextLink;
	}
	
	public void print() //Runs a While loop to print with a linked list
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.nextLink;
		}
	}
	
	//Checks to see if the data is contained
	public boolean contains(T aData)
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.data.equals(aData))
				return true;
			temp = temp.nextLink;
		}
		return false;
	}
}
