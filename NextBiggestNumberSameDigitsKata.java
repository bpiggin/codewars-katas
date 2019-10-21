import java.util.Arrays;

public class NextBiggestNumberSameDigitsKata 
{
    public static long nextBiggerNumber(long n)
    {
    	char[] array = String.valueOf(n).toCharArray();
    	char digitToSwapLeft = '\0';
    	int positionOfDigitToSwapLeft = 0;
    	char digitToSwapRight = '\0';
    	int positionOfDigitToSwapRight = 0;
    	
    	//Search for consecutive swappable digits.
    	for (int i=array.length - 1; i>0; i--) 
    	{
    	    char digit = array[i];
	    	char digitToLeft = array[i - 1];

	    	//If next digit is smaller then return its value and position.
	    	if (digitToLeft < digit)
	    	{
	    		digitToSwapLeft = digitToLeft;
	    		positionOfDigitToSwapLeft = i - 1;
	    		digitToSwapRight = digit;
	    		positionOfDigitToSwapRight = i;
	    		break;
	    	}
	    	
	    	//Reached the end of the loop without finding a swap.
	    	if (i == 1)
	    	{
	    		return -1; //No possible swaps.
	    	}
    	}
    	
    	//Loop and find the smallest digit greater than digitToSwapRight to the right of digitToSwapRight
    	for (int i=positionOfDigitToSwapLeft + 1; i<array.length; i++)
    	{
    		char digit = array[i];
    		if (digit < digitToSwapRight && digit > digitToSwapLeft)
    		{
    			digitToSwapRight = digit;
    			positionOfDigitToSwapRight = i;
    		}
    	}
    	
    	//Perform the swap.
    	array[positionOfDigitToSwapLeft] = digitToSwapRight;
    	array[positionOfDigitToSwapRight] = digitToSwapLeft;
    	
    	//Sort the digits to the right of positionOfdigitToSwapLeft.
    	Arrays.parallelSort(array, positionOfDigitToSwapLeft + 1, array.length);
    	
    	return Long.parseLong(new String(array));
    }
}
