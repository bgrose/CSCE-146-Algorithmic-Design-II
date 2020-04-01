/*
 * Bradley Grose
 */

import java.io.File;
import java.util.Scanner;

public class FruitTreeTester {

	public static void main(String[] args) {
		System.out.println("Welcome to the fruit tree!\r\nPlease enter a Fruit File Name");
		Scanner key = new Scanner(System.in);
		String name = key.nextLine();
		System.out.println("Populating tree file");

		BinarySearchTree<Fruit> tree = new BinarySearchTree<Fruit>();

		try {
			Scanner fileScan = new Scanner(new File(name));
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				String[] split = line.split("\t");
				if (split.length == 2) {
					String type = split[0];
					double weight = Double.parseDouble(split[1]);
					Fruit f = new Fruit(type, weight);
					tree.add(f);
				}
			}
			fileScan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Output
		System.out.println("Printing the in-order traversal\n");
		tree.printInOrder();
		System.out.println("\nPrinting the pre-order traversal\n");
		tree.printPreOrder();
		System.out.println("\nPrinting the post-order traversal\n");
		tree.printPostOrder();
		System.out.println("\nDeleting Apple 0.4859853412170728\n");
		tree.remove(new Fruit("Apple", 0.4859853412170728));
		System.out.println("Printing the in-order traversal\n");
		tree.printInOrder();
	}

}
