public class FindTheParityOutlierKata 
{
	static int find(int[] integers)
	{
		if (!validateArray(integers))
		{
			return 0;
		}
		
		if (majorityEven(integers))
		{
			for (int element : integers)
			{
				if (element % 2 != 0)
				{
					return element;
				}
			}
		}
		else
		{
			for (int element : integers)
			{
				if (element % 2 == 0)
				{
					return element;
				}
			}
		}
		//Should never happen.
		return 0;
	}
	
	private static boolean majorityEven(int[] array)
	{
		int count = 0;
		
		for (int i=0; i<3; i++)
		{
			int element = array[i];
			
			if (element % 2 == 0)
			{
				count++;
			}
		}
		return count > 1;
	}
	
	private static boolean validateArray(int[] array)
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