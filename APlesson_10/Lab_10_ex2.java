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
		doEquation(equation);
	}
	
	public static ArrayList doEquation(ArrayList<String> equation)
	{
		int i = 0;
		while(i < equation.size())
		{
			if(equation.get(i).equals("*") || equation.get(i).equals("/"))
			{
				if(equation.get(i).equals("*"))
				{
					equation.set(Integer.parseInt(equation.get(i), Integer.parseInt(equation.get(i-1)) * Integer.parseInt(equation.get(i+1))));
				}
				
				else
				{
					equation.set(Integer.parseInt(equation.get(i), Integer.parseInt(equation.get(i-1)) / Integer.parseInt(equation.get(i+1))));
				}
				equation.remove(i-1);
				equation.remove(i);
			}
			i++;
		}
		
		while(i < equation.size())
		{
			if(equation.get(i).equals("+") || equation.get(i).equals("-"))
			{
				if(equation.get(i).equals("+"))
				{
					equation.set(Integer.parseInt(equation.get(i), Integer.parseInt(equation.get(i-1)) + Integer.parseInt(equation.get(i+1))));
				}
				
				else
				{
					equation.set(Integer.parseInt(equation.get(i), Integer.parseInt(equation.get(i-1)) - Integer.parseInt(equation.get(i+1))));
				}
				equation.remove(i-1);
				equation.remove(i);
			}
			i++;
		}
		
		System.out.println(doEquation(equation));
	}
}