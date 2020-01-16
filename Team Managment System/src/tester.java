
public class tester {

	public static void main(String[] args) {
		
		Person p;
		p = new Person();
		p.setName("Bob");
		System.out.println(p.getName());
		Person p1 = p;
		p1.setName("JJ");
		System.out.println(p.getName());
		System.out.println(p.getName());

		TeamManager tm = new TeamManager();
		tm.add(p1);
		tm.add(new Student());
	}

}
