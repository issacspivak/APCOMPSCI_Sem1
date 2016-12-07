public class Lab_09_1_ex1
{
	
	public static void main(String[]args)
	{
		int [] numbers = new int[10];
		fillArray(numbers);
		
	}
	
	public static void fillArray(int [] numbers)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = (int)(Math.random() * 100) + 1;
		}
		printArray(numbers);
	}
	
	public static void printArray(int [] numbers)
	{
		for(int number : numbers)
		{
			System.out.print(number + " ");
		}
	}
	
	public static void getOdds(int [] numbers)
	{
		String odds;
		for(int number : numbers)
		{
			if(number % 2 == 0)
			{
	
			}
			else 
			{
				System.out.print(number);
			}
		}
	}
	
}