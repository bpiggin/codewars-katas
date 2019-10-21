import java.util.Collections;
import java.util.Vector;

public class LengthOfMissingArrayKata 
{
	  public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
	  {
		  Vector<Integer> subArraySizes = new Vector<Integer>();
		  
		  if (!validateArray(arrayOfArrays))
		  {
			  return 0;
		  }
		  
		  int lengthOfPrimaryArray = arrayOfArrays.length;
		  for (int i=0; i<lengthOfPrimaryArray; i++)
		  {
			  Object[] subArray = arrayOfArrays[i];
			  
			  if(!validateArray(subArray))
			  {
				  return 0;
			  }
			  
			  subArraySizes.add(subArray.length);
		  }
		  
		  Collections.sort(subArraySizes);
		  
		  for (int i=0; i<subArraySizes.size(); i++)
		  {
			  Integer size = subArraySizes.get(i);
			  Integer nextSize = subArraySizes.get(i+1);
			  if (nextSize != (size + 1))
			  {
				  return (size + 1);
			  }
		  }
		  
		  //Should never happen.
		  return 0;
	  }
	  
	  private static boolean validateArray(Object[] array)
	  {
		  if (array == null)
		  {
			  return false;
		  }
		  
		  int lengthOfArray = array.length;
		  
		  if (lengthOfArray == 0)
		  {
			  return false;
		  }
		  
		  return true;
	  }
}