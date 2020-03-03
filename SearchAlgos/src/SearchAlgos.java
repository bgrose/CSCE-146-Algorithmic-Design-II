
public class SearchAlgos {

	public static void main(String[] args) {

		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	}

	// Iterator Search
	public static boolean seqIter(int[] a, int value) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == value)
				return true;
		return false;
	}

	// Recursion Search
	public static boolean seqRecur(int[] a, int value, int index) {
		if (a[index] == value)
			return true;
		else {
			index++;
			if (index >= a.length) // Halting
				return false;
			return seqRecur(a, value, index);
		}
	}

	public static boolean binRecur(int[] a, int value, int min, int max) {
		if (min > max)
			return false;
		int mid = (max + min) / 2;
		if (a[mid] == value)
			return true;
		else {
			if (a[mid] < value)
				return binRecur(a, value, mid + 1, max);
			else
				return binRecur(a, value, min, mid - 1);
		}
	}

}
