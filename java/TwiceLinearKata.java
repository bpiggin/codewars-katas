import java.util.List;
import java.util.Vector;

public class TwiceLinearKata 
{
    public static int dblLinear (int n) 
    {
    	List<Integer> u = new Vector<>();
    	u.add(1);
    	int indexY = 0;
    	int indexZ = 0;
    	int requiredIterations = n;
    	
    	for (int i=0; i<requiredIterations; i++)
    	{	
    		int y = 2 * u.get(indexY) + 1;
    		int z = 3 * u.get(indexZ) + 1;
    		
    		if (y < z)
    		{
    			u.add(y);
    			indexY++;
    		}
    		
    		else if (y == z)
    		{
    			indexZ++;
    			requiredIterations++;
    		}
    		
    		else
    		{
    			u.add(z);
    			indexZ++;
    		}
    	}
    	return u.get(n);
    }
}
