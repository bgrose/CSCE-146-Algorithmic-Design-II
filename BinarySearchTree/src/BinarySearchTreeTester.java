
public class BinarySearchTreeTester {

	public static void main(String[] args) {

		BinarySearchTree<Integer> iTree = new BinarySearchTree<Integer>();

		iTree.add(5);
		iTree.add(7);
		iTree.add(2);
		iTree.add(1);
		iTree.add(6);
		iTree.add(3);

		iTree.printPreOrder();
		System.out.println();
		iTree.printInOrder();
	}
}
