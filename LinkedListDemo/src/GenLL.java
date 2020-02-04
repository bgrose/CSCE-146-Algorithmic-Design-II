/*
 * Bradley Grose From 1/30/2020 Class Example
 */

import java.util.Iterator;

//T is an Object Type
public class GenLL<T> {  //<T> Allows for Generic Link List of Type T

	private class ListNode{  //Creates Linked List
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	
	private class ListIterator implements Iterator<T> //OverRides and needs hasNext and next
	{
		private ListNode iCurr;
		public ListIterator(ListNode head) {
			iCurr = head;
		}
		
		public boolean hasNext() {
			return iCurr != null;
		}
		
		public T next() { //Moves to next
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
		
	}
	
	
	public Iterator<T> iterator()
	{
		return new ListIterator(head);
	}
	
	
	private ListNode head; //Always first element
	private ListNode curr; //Current node of interest
	private ListNode prev; //Last node position
	
	public GenLL() //sets Empty list with 1 Node
	{
		head = curr = prev = null;
	}
	
	public T getCurrect() //Gets Current
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	
	public void setCurrent(T aData) //Sets data if the spot is not null
	{
		if(curr != null)
			curr.data = aData;
	}
	
	public void gotoNext() //Sets up the positioning
	{
		if(curr != null)
		{
			prev = curr; //Moves prev pointer to current
			curr = curr.link; //Sets to next
		}
	}
	
	public void reset() //Goes to the Start
	{
		curr = head;
		prev = null;
	}
	
	public boolean hasMore()
	{
		return curr != null;
	}
	
	//Adds to the end
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData,null);
		if(head == null) //Means List is empty
		{
			head = curr = newNode; //Creates pointer to head of list and adds newNode
			return;
		}
		
		//This is all the same as using a tail function to track the last position.
		
		
		ListNode temp = head; //Temp Pointer
		while(temp.link != null)
		{
			temp = temp.link;
		} //It will end when we are poitning to nothing
		
		temp.link = newNode; //Creates a Node at the End
	}
	
	public void addAfterCurrent(T aData) //Adds to middle and link it in
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData, curr.link);
		curr.link = newNode;
	}
	
	//If you lose the reference point, the compiler will clear it out of the system
	
	public void removeCurrent()
	{
		if(curr != null && prev != null) //Makes sure u dont delete the head
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) //Removes the head
		{
			//curr = curr.link; //Needs to use the head if it is head position
			head = head.link;
			curr = head;
		}
	}
	
	public void print() //Runs a While loop to print with a linked list
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	
}
