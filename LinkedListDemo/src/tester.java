
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenLL<Integer> iLL = new GenLL<Integer>(); //Creates Integer Linked List
		
		GenLL<String> sLL = new GenLL<String>(); //String Linked List
		
		//Based on the Idea of inheritance using <t> for linked list GenLL
		
		for(int i=0; i<10; i++)
		{
			iLL.add(i);;
			sLL.add(i+"Thing");
		}
		iLL.print();
		sLL.print();
	}

}
