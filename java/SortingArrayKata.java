import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class SortingArrayKata 
{
	public static int[] sortArray(int[] array) 
	{
		HashMap<Integer, Integer> evens = new HashMap<Integer, Integer>(); //Map of index to number.
		Vector<Integer> sortedNumbers = new Vector<Integer>();
		
		//Loop through array and add even numbers to map for later and odds to vector for sorting.
		for (int i=0; i<array.length; i++)
		{
			int value = array[i];
			if (value % 2 == 0)
			{
				evens.put(i, value);
			}
			else
			{
				sortedNumbers.add(value);
			}
		}
		
		//Sort the vector of odds.
		Collections.sort(sortedNumbers);
		
		//Loop round again and add the even numbers back in at the correct indices.
		List<Integer> sortedKeys = new ArrayList<>(evens.keySet());
		Collections.sort(sortedKeys);
		for (Integer key : sortedKeys) 
		{
		    Integer value = evens.get(key); //Value of even number
		    
		    sortedNumbers.add(key, value);
		}
		
		//Convert back to int array.
		int size = sortedNumbers.size();
		int[] result = new int[size];
		Integer[] temp = sortedNumbers.toArray(new Integer[size]);
		for (int n = 0; n < size; ++n) 
		{
		    result[n] = temp[n];
		}
		
		return result;
	}
}
