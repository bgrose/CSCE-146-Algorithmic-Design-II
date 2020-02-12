
public class Tester {

	public static void main(String[] args) {
		//QueueI<String> sQ = new ArrayQueue<String>();
		QueueI<String> sQ = new LLQueue<String>();
		for (int i = 0; i < 10; i++) {
			sQ.enqueue("String" + i);
		}
		sQ.print();
	}
}
