
/*
 * CSCE 146 Exam02 Question03
 * Provided code
 * Make sure this at least compiles
 * You may write additional methods to help
 */

/*
 * Bradley Grose
 */
public class DoubleBinarySearchTree 
{
	//Do not alter---------------------
	public class Node//This is public for testing purposes
	{
		public double data;
		public Node leftChild;
		public Node rightChild;
		public Node(double aData)
		{
			this.data = aData;
		}
	}
	public Node root;//This is public for testing purposes
	public DoubleBinarySearchTree()
	{
		root = null;
	}
	//---------------------------------
	public boolean search(double aData)
	{
		return recursiveSearch(root, aData);
	}

	public boolean recursiveSearch(Node aNode, double aData) {
		if (aNode == null)
			return false;
		if (aNode.data == aData)
			return true;
		else if (aData < aNode.data)
			return recursiveSearch(aNode.leftChild, aData);
		else
			return recursiveSearch(aNode.rightChild, aData);
	}
		
}

