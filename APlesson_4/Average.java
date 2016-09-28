import java.util.Scanner;
public class Average
{
	static int num1;
	static int num2;
	static int num3;
	static int ave;
	
	public static void main(String[]args)
	{
		Average form = new Average();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your first number:");
		num1 = kb.nextInt();
		System.out.println("Enter your second number:");
		num2 = kb.nextInt();
		System.out.println("Enter your third number:");
		num3 = kb.nextInt();
		
		calcAverage();
		print();
	}
	
	public static void calcAverage()
	{
		ave = ((num1+num2+num3)/3);
	}
	
	public static void print()
	{
		System.out.print("The average of " + num1 + ", "+ num2 + ", " + num3 + " is " + ave);
	}
}