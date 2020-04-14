/*
 * CSCE 146 Exam02 Question01
 * Provided code
 * Make sure this at least compiles
 * You may write additional methods to help
 */

/*
 * Bradley Grose
 */
public class SearchAlgorithm {
	// Do not alter------------------------------------------
	public static double[] doubleArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	// ------------------------------------------------------

	public static boolean search(double[] a, double target) {
		int min = 0;
		int max = a.length;
		return recurSearch(a, target, min, max);
	}

	public static boolean recurSearch(double[] a, double target, int min, int max) {
		int mid = (max + min) / 2;
		if (min > max) // Not found in whole array
			return false;
		if (a[mid] == target)
			return true; // Found
		else {
			if (target > a[mid]) // larget half
				return recurSearch(a, target, mid + 1, max);
			else // Smaller half
				return recurSearch(a, target, min, mid - 1);
		}
	}
}
