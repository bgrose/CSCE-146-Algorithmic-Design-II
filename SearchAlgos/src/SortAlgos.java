
public class SortAlgos {

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	}

	public static void bubbleSort(int[] a) {
		boolean hasSwapped = true;
		while (hasSwapped) {
			hasSwapped = false;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					hasSwapped = true;
				}
			}
		}
	}

	public static void mergeSort(int[] a) {
		int size = a.length;
		if (size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for (int i = 0; i < mid; i++)
			left[i] = a[i];
		for (int i = mid; i < size; i++)
			right[i - mid] = a[i];
		mergeSort(left);
		mergeSort(right);
		//todo merge

	}

}
