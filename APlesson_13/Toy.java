public abstract class Toy
{
	private String name;
	private int count;
	
	public Toy()
	{
		this.count = 1;
	}
	
	public Toy(String n)
	{
		this.count = 1;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setCount(int c)
	{
		count = c;
	}
	
	public abstract String getType();
	
	
	public String toString()
	{
		return name + count;
	}
	
	
}