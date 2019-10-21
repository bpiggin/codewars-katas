import java.util.Arrays;
import java.util.Vector;

public class SnailPathMatrixKata 
{
    public static int[] snail(int[][] array) 
    {
        if (array == null)
        {
        	return new int[] {};
        }
        
        int[][] empty = {{}};
        if (Arrays.deepEquals(array, empty))
        {
        	return new int[] {};
        }

        Vector<Integer> snailTrailPopulated = generateSnailTrail(array, new Vector<>());
        return snailTrailPopulated.stream().mapToInt(i->i).toArray();
    }

	private static Vector<Integer> generateSnailTrail(int[][] array, Vector<Integer> snailTrail) 
	{
		int numberOfElements = array.length * array.length;
		
		//Finished recursing.
        if (numberOfElements == 0)
        {
        	return snailTrail;
        }
        
        //One element remaining.
        if (numberOfElements == 1)
        {
        	snailTrail.add(array[0][0]);
        	return snailTrail;
        }
        	
    	int lengthOfAxis = array.length; //i.e. N in an NxN matrix.
        
    	//Top row
    	for (int i=0; i<lengthOfAxis; i++)
    	{
    		snailTrail.add(array[0][i]);
    	}
    	//Right row
    	for (int i=1; i<lengthOfAxis; i++)
    	{
    		snailTrail.add(array[i][lengthOfAxis - 1]);
    	}
    	//Bottom row
    	for (int i=1; i<lengthOfAxis; i++)
    	{
    		snailTrail.add(array[lengthOfAxis - 1][lengthOfAxis - 1 - i]);
    	}
    	//Left row
    	for (int i=1; i<lengthOfAxis - 1; i++)
    	{
    		snailTrail.add(array[lengthOfAxis - 1 - i][0]);
    	}
    	
    	//Create sub array of all the elements we haven't added yet.
    	int[][] subArray = new int[lengthOfAxis - 2][];
    	for (int i=1; i <lengthOfAxis - 1; i++) 
    	{
    		subArray[i - 1] = Arrays.copyOfRange(array[i], 1, lengthOfAxis - 1);
    	}
    	
    	//Recurse
    	return generateSnailTrail(subArray, snailTrail);
	} 
}