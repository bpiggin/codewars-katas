import java.util.Vector;

public class DirectionReductionKata 
{
	public final static String NORTH = "NORTH";
	public final static String SOUTH = "SOUTH";
	public final static String EAST = "EAST";
	public final static String WEST = "WEST";
	
    public static String[] dirReduc(String[] arr) 
    {
    	if (!validateArray(arr))
    	{
        	return new String[] {};
    	}
    	
    	Vector<String> dirVec = removeOpposingDirections(arr);
    	
    	String[] reducedArr = dirVec.toArray(new String[dirVec.size()]);
    	if (containsOpposingDirections(dirVec))
    	{
    		return dirReduc(reducedArr);
    	}
    	return reducedArr;
    }

	private static boolean containsOpposingDirections(Vector<String> dirVec) 
	{
		for (int i=0; i<dirVec.size(); i++)
		{
			if (i == dirVec.size() - 1)
			{
				continue;
			}
			
			String dir = dirVec.get(i);
			String nextDir = dirVec.get(i+1);
			
			if (areOpposingDirections(dir, nextDir))
			{
				return true;
			}
		}
		return false;
	}

	private static Vector<String> removeOpposingDirections(String[] arr) 
	{
		Vector<String> dirVec = new Vector<>();
    	for (int i=0; i<arr.length; i++)
    	{	
    		String dir = arr[i];
    		
    		if (i == arr.length - 1)
    		{
    			dirVec.add(dir);
    			continue;
    		}
    		
    		String nextDir = arr[i+1];
    		if (!areOpposingDirections(dir, nextDir))
    		{
    			dirVec.add(dir);
    		}
    		else
    		{
    			i++; //Skip the next element.
    		}
    	}
		return dirVec;
	}
    
	private static boolean areOpposingDirections(String dir, String nextDir) 
	{
		return (dir.equals(NORTH) && nextDir.equals(SOUTH)) 
				|| (dir.equals(SOUTH) && nextDir.equals(NORTH))
				|| (dir.equals(EAST) && nextDir.equals(WEST))
				|| (dir.equals(WEST) && nextDir.equals(EAST));
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
