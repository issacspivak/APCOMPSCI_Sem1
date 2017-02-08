public class Car extends Toy
{
	Car object = new Car();
	
	public Car()
	{
		super();
	}
	
	public Car(String n)
	{
		super(n);
	}
	
	public String getType()
	{
		return "Car";
	}
}