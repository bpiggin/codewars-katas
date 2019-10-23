import java.util.Arrays;

public class NextSmallestNumberSameDigitsKata 
{
	  public static long nextSmaller(long n)
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

		    	//If next digit is larger then return its value and position.
		    	if (digitToLeft > digit)
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
	    	
	    	//Loop and find the largest digit smaller than digitToSwapLeft to the right of digitToSwapLeft
	    	for (int i=positionOfDigitToSwapLeft + 1; i<array.length; i++)
	    	{
	    		char digit = array[i];
	    		if (digit > digitToSwapRight && digit < digitToSwapLeft)
	    		{
	    			digitToSwapRight = digit;
	    			positionOfDigitToSwapRight = i;
	    		}
	    	}
	    	
	    	//Perform the swap.
	    	array[positionOfDigitToSwapLeft] = digitToSwapRight;
	    	array[positionOfDigitToSwapRight] = digitToSwapLeft;
	    	
	    	//Sort the digits to the right of positionOfdigitToSwapLeft. In descending order.
	    	char[] unsortedSection = Arrays.copyOfRange(array, 0, positionOfDigitToSwapLeft + 1);
	    	char[] sectionToSort = Arrays.copyOfRange(array, positionOfDigitToSwapLeft + 1, array.length);
	    	Arrays.sort(sectionToSort);
	    	String sectionToSortReversed = new StringBuilder(new String(sectionToSort)).reverse().toString();
	    	String answer = new String(unsortedSection) + sectionToSortReversed;
	    	
	    	if (answer.startsWith("0")) return -1; //No leading zeros allowed.
	    	if (answer.trim().isEmpty()) return -1; //Weird input?
	    	
	    	return Long.parseLong(answer);
	  }
}
