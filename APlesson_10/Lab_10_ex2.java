import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Lab_10_ex2
{
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter an equation: ");
		String expression = kb.nextLine();
		
		ArrayList<String>equation = new ArrayList<>(Arrays.asList(expression.split(" ")));
	}
	
	public static void doEquation()
	{
		int i = 0;
		while(i < equation.size())
		{
			if(i < equation.size() && equation.get(i-1).equals("+"))
			{
				equation.set(i, "" + (Integer.parseInt(equation.get(i-1)) + Integer.parseInt(equation.get(i+1))));
				equation.remove(i-1);
				equation.remove(i);
			}
			else
				i++;
		}
	}
}