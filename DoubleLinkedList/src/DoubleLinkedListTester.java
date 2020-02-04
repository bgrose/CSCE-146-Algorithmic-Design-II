/*
 * Written by JJ Shepherd
 */
public class DoubleLinkedListTester {
	public static final int[] TEST_VALS_1 = {0,1,2,3,4,5,6,7,8,9};
	public static final int[] TEST_VALS_2 = {1,3,4,5,6,7,8};
	public static final int[] TEST_VALS_3 = {1,3,-4,5,-6,7,-8};
	
	public static final String DEC = "------------------------------------------------------\n";
	public static void main(String[] args) {
		printDecorated("Double Linked List Tester");
		GenDoubleLinkedList<Integer> intList = new GenDoubleLinkedList<Integer>();

		System.out.println("SUCCESS: "+insertAndContainsTest(intList)+"\n");
		System.out.println("SUCCESS: "+deleteTest(intList)+"\n");
		System.out.println("SUCCESS: "+modifyingValuesTest(intList)+"\n");
		
		printDecorated("Printing the list");
		intList.print();
	}
	
	public static boolean insertAndContainsTest(GenDoubleLinkedList<Integer> intList)
	{
		printDecorated("Inserting and Contains Test");
		for(int i=0;i<TEST_VALS_1.length;i++)
			intList.insert(TEST_VALS_1[i]);
		return valuesMatch(intList,TEST_VALS_1);
	}
	public static boolean deleteTest(GenDoubleLinkedList<Integer> intList)
	{
		printDecorated("Removing Test\nRemoving first item, third item, and last item");
		intList.resetCurrent();
		intList.deleteCurrent();
		
		intList.goToNext();
		intList.deleteCurrent();
		
		while(intList.moreToIterate())
		{
			intList.goToNext();
		}
		intList.deleteCurrent();
		return valuesMatch(intList,TEST_VALS_2);
	}
	public static boolean modifyingValuesTest(GenDoubleLinkedList<Integer> intList)
	{
		printDecorated("Modified Values Test\nChanging all even values to negative values");
		intList.resetCurrent();
		while(intList.moreToIterate())
		{
			if(intList.getCurrent() % 2 == 0)
				intList.setCurrent(-intList.getCurrent());
			intList.goToNext();
		}
		//moreToIterate will stop on the last item so this is needed to check the last item
		if(intList.getCurrent() % 2 == 0)
			intList.setCurrent(-intList.getCurrent());
		return valuesMatch(intList,TEST_VALS_3);
	}
	public static boolean valuesMatch(GenDoubleLinkedList<Integer> intList, int[] testVals)
	{
		for(int i=0;i<testVals.length;i++)
			if(!intList.contains(testVals[i]))
				return false;
		return true;
	}
	public static void printDecorated(String str)
	{
		System.out.println(DEC+str+"\n"+DEC);
	}
}