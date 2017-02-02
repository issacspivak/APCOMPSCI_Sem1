import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab_10_1
{
    public static void main(String[] args)
    {
        Integer[] numbers = {2,6,8,9,10,12,13,15,17,24,55,66,78,77,79};
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
		
        System.out.println(nums);
        
        removePrimes(nums);
        System.out.println(nums);        
        
    }
    
    public static boolean gFactor(Integer n)
    {
        boolean Prime = true; 
        for(int i = 2; i < n; i++)
        {
            if (n % i == 0) 
			{
                Prime = false;
            }
        }
        return Prime;        
    }
   
   public static void removePrimes(ArrayList<Integer> nums)
    {
                
        for(int i = 0; i < nums.size(); i++)
        {
            if (gFactor(nums.get(i))){
                nums.remove(i);
                i = i-1;
            }           
            
        }
        
    }
}