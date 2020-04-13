//Question 5

public class StringBinarySearchTree {

	private class Node {
		private String data;
		private Node leftChild; // Less than
		private Node rightChild; // Greater than

		private Node root;

		public Node(String aData) {
			data = aData;
			leftChild = rightChild = null;
		}

		public void remove(String aData) {
			root = remove(root, aData);
		}

		private Node remove(Node aNode, String aData) {
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

		private Node findMinInTree(Node aNode) {
			if (aNode == null)
				return null;
			if (aNode.leftChild == null)
				return aNode;
			else
				return findMinInTree(aNode.leftChild);
		}
	}
}
