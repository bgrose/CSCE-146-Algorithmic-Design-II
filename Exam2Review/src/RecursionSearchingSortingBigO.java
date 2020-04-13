//Exam Review

//Using https://cse.sc.edu/~shephejj/csce146/Other/PracticeExams/CSCE146PracticeExam2NOAnswersCOVID19Update.pdf
public class RecursionSearchingSortingBigO {

	// Question 1
	public static int fibonacci(int number) {
		if (number == 1 || number == 2)
			return 1;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

	// Question 2
	public static boolean binarySearchRecursive(int[] a, int value, int minIndex, int maxIndex) {

		int midIndex = (maxIndex + minIndex) / 2;
		if (minIndex > maxIndex)
			return false;
		if (a[midIndex] == value)
			return true;
		else {
			if (value > a[midIndex])
				return binarySearchRecursive(a, value, midIndex + 1, maxIndex);
			else
				return binarySearchRecursive(a, value, midIndex, maxIndex - 1);
		}
	}

	// Question 3 in Sorter

}
