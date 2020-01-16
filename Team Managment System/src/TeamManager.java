public class TeamManager {

	public static final int SIZE = 30;
	
	private Person[] team;
	
	public TeamManager()
	{
		
	}
	
	public TeamManager(int size)
	{
		init(size);
	}
	
	private void init(int size)
	{
		if(size <= 0)
			init(SIZE);
	}
	
	public void add(Person p)
	{
		if(team[team.length-1] != null)
			return;
		
		for(int i=0; i<team.length; i++)
		{
			if(team[i] == null)
			{
				team[i] = p;
				break;
			}
		}
	}
	
	public void remove(Person p)
	{
		int rmIndex = getIndex(p);
		if(rmIndex == -1)
			return;
		for(int i=rmIndex; i<team.length-1; i++)
			team[i] = team[i+1];
		team[team.length-1] = null;
	}
	private int getIndex(Person p)
	{
		int ret = -1;
		for(int i=0; i<team.length; i++)
		{
			if(team[i] != null && p.equals(team[i]))
				return i;
		}
		return ret;
	}
}
