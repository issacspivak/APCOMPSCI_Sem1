import java.util.Scanner;
public class Lab_08_ex3
{
	static String number;
	
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the number: ");
		number = kb.next();
		
		System.out.println(makeCenter(word1));
		
	} 
	
	public static String luck(String number)
	{
		if(number > 0)
		{
			if(number.substring(0, number.length()) == 7)
				return "1";
				luck();
		}
		else
			return "0";
		
	}
}	