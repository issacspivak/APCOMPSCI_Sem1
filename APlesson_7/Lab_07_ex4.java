import java.util.Scanner;
public class Lab_07_ex4
{
	static String sentence;
	static int num;
	static int i;
	
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		sentence = kb.next();
		replace();
	}
	
	public static void replace()
	{
		i = sentence.indexOf("a");
		while (i >= 0)
		{
			num = sentence.indexOf("a") + 1;
			System.out.println(sentence.substring(0, sentence.indexOf("a")) + "@" + sentence.substring(num));
			i--;
		}
			
	}
}