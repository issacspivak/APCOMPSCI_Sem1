import java.util.Scanner;
public class Lab_06_ex2
{
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int num = kb.nextInt();
		
		for(int i = 1; i < num; i++)
		{
			System.out.println(num*i);
		}
		
	}
}