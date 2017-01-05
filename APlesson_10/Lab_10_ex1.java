import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Lab_10_ex1
{
	public static void main(String[]args)
	{
		Integer [] numbers = {2, 6, 8, 9, 10, 12, 13, 15, 17, 24, 55, 66, 78, 77, 79};
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
		removePrimes(nums);
	
	}
	
	public static void removePrimes(Integer [] nums)
	{
		for(int i = 0; i <= num.size(); i++)
		{
			if(gFactor(nums[i]) = 0)
			{
				nums.remove(nums[i]);
				i--;
			}
		}
		
		
		
	}
	
	
	public static int gFactor(int n)
	{
		for(int i = 2; i <= n; i++)
		{	
			if(n % i == 0)
			{
				return 1;
			}
			
			else
			{
				return 0;
			}
		}
	}
	
	
	
}