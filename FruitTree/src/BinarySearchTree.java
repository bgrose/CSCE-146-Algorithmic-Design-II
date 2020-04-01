
/*
 * Bradley Grose
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private class Node {
		private T data;
		private Node leftChild; // Less than
		private Node rightChild; // Greater than

		public Node(T aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(T aData) { // Adds Element to the tree
		if (root == null)
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

	public boolean search(T aData) { // Calls for search
		return recursiveSearch(root, aData);
	}

	public boolean recursiveSearch(Node aNode, T aData) { // Searches for data
		if (aNode == null)
			return false;
		if (aNode.data.compareTo(aData) == 0)
			return true;
		else if (aData.compareTo(aNode.data) < 0)
			return recursiveSearch(aNode.leftChild, aData);
		else
			return recursiveSearch(aNode.rightChild, aData);
	}

	// Prints before sorted
	public void printPreOrder() {
		printPreOrder(root);
	}

	// Goes through branches presort
	private void printPreOrder(Node aNode) {
		if (aNode == null)
			return;
		System.out.println(aNode.data); // Process
		printPreOrder(aNode.leftChild); // Go Left
		printPreOrder(aNode.rightChild); // Go Right

	}

	// Prints in Order
	public void printInOrder() {
		printInOrder(root);
	}

	// Goes through branches post sort
	private void printInOrder(Node aNode) {
		if (aNode == null)
			return;
		printInOrder(aNode.leftChild);
		System.out.println(aNode.data);
		printInOrder(aNode.rightChild);
	}

	// Prints the Post Order
	public void printPostOrder() {
		printPostOrder(root);
	}

	// Functions that goes through
	private void printPostOrder(Node aNode) {
		if (aNode == null)
			return;
		printPostOrder(aNode.leftChild);
		printPostOrder(aNode.rightChild);
		System.out.println(aNode.data);
	}

	// Removes Function
	public void remove(T aData) {
		root = remove(root, aData);
	}

	// Removes recursivly the elements
	private Node remove(Node aNode, T aData) {
		if (aNode == null)
			return null;
		if (aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0)
			aNode.rightChild = remove(aNode.rightChild, aData);
		else {
			// Case 1
			if (aNode.rightChild == null)
				return aNode.leftChild;
			// Case 2
			if (aNode.leftChild == null)
				return aNode.rightChild;
			// Case 3
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}

	// Finds min for remove
	private Node findMinInTree(Node aNode) {
		if (aNode == null)
			return null;
		if (aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}

}
