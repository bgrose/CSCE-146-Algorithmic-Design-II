
public class BinarySearchTree <T extends Comparable<T>> {

	private class Node
	{
		private T data;
		private Node leftChild; //Less than
		private Node rightChild; //Greater than
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	
	private Node root;
	public BinarySearchTree()
	{
		root = null;
	}
	public void add(T aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}
	
	private Node add(Node aNode, T aData) {
		if (aNode == null) // Found a Leef
			aNode = new Node(aData);
		else if (aData.compareTo(aNode.data) < 0) // Go left
			aNode.leftChild = add(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0) // Go Right
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;

	}
	
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	
	private void printPreOrder(Node aNode)
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data); //Process
		printPreOrder(aNode.leftChild); //Go Left
		printPreOrder(aNode.rightChild); //Go Right
		
	}
	
	public void printInOrder()
	{
		printInOrder(root);
	}
	
	public void printInOrder(Node aNode)
	{
		if(aNode == null)
			return;
		printInOrder(aNode.leftChild);
		System.out.println(aNode.data);
		printInOrder(aNode.rightChild);
	}
	
	
	
}
