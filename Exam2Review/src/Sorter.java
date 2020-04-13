//Question 3

public class Sorter {

	public static void main(String[] args) {
		String[] s = { "asdf", "asdfasdf", "as", "a", "asdfasdfasdf" };
		sort(s);
	}

	public static void sort(String[] a) {
		int size = a.length;
		if (size < 2)
			return;
		int mid = size / 2;
		int leftSide = mid;
		int rightSide = size - mid;
		String[] left = new String[leftSide];
		String[] right = new String[rightSide];
		for (int i = 0; i < mid; i++)
			left[i] = a[i];
		for (int i = mid; i < size; i++)
			right[i - mid] = a[i];
		sort(left);
		sort(right);
		merge(left, right, a);
	}

	private static void merge(String[] left, String[] right, String[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < leftSize && j < rightSize) {
			if (left[i].length() <= right[j].length()) {
				a[k] = left[i];
				i++;
				k++;
			} else {
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while (i < leftSize) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			a[k] = right[j];
			k++;
			j++;
		}
	}
}
