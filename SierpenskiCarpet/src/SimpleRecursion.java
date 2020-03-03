
public class SimpleRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countDown(5);
	}
	public static void countDown(int num) {
		System.out.println(num);
		if (num <= 0) { // Halting condition
			return;
		}
		else{
			countDown(num-1); // Recursive Step
		}
	}
	public static int factorial(int num){
		if (num <= 0) {
			return 1;
		}
		else {
			return num * factorial(num-1);
		}
	}
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
	public static int fibbo(int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		else {
			return fibbo(num-1) + fibbo(num-2);
		}
	}
	

}
