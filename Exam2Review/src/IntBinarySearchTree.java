//Question 4

public class IntBinarySearchTree {

	private class Node {
		private int data;
		private Node leftChild; // Less than
		private Node rightChild; // Greater than

		public Node(int aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}

	private Node root;

	public void add(int aData) {
		if (root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}

	private Node add(Node aNode, int aData) {
		if (aNode == null) // Found a Leef
			aNode = new Node(aData);
		else if (aData < aNode.data) // Go left
			aNode.leftChild = add(aNode.leftChild, aData);
		else if (aData > aNode.data) // Go Right
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;

	}
}
