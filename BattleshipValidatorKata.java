import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BattleshipValidatorKata 
{	
    public static boolean fieldValidator(int[][] field) 
    {
    	int[][] labelled = generateLabelledMatrix(field);
    	return extractAndValidateBlobs(labelled);
    }

	private static int[][] generateLabelledMatrix(int[][] field) 
	{
		int[][] labels = new int[field.length][field[0].length];
		fillWithMinusOne(labels); //Default label array value is -1.
    	List<Set<Integer>> linked = new ArrayList<>();
    	
    	int NextLabel = 0;
    	
    	//First pass (of the two pass algorithm). This adds labels to connected elements.
    	for (int y=0; y<field.length; y++) 
    	{
            for (int x=0; x<field[0].length; x++) 
            {
            	//i.e. Element is part of a ship. Not in the background.
                if (field[y][x] != 0)
                {
                	//Loop round the neighbouring elements.
                	ArrayList<Integer> neighbors = new ArrayList<Integer>();
                    for (int ni=-1; ni<=1; ni++) 
                    {
                        for (int nj=-1; nj<=1; nj++) 
                        {
                        	//May not be neighbouring elements in certain places if we are on the outer edge of the matrix.
                        	//Don't count the element we are currently on.
                            if (y + ni < 0 
                    		  || x + nj < 0 
                    		  || y + ni > labels.length - 1 
                    		  || x + nj > labels[0].length - 1
                    		  || ni == 0 && nj == 0) 
                            {
                                continue;
                            }
                            
                            //Something to do with corners? Want to leave this out I think since we disallow corners.
                            /*if(x + ni == 0 && y + nj == 0) 
                            {
                            	continue;
                            }*/
                            
                            //Add the neighbour to the list if it has been labelled.
                            if (labels[y + ni][x + nj] != -1)
                            {
                            	neighbors.add(labels[y + ni][x + nj]);
                            }
                        }
                    }
                    
                    //No labelled neighbours. 
                    if (neighbors.isEmpty()) 
                    {
                        Set<Integer> tempSet = new HashSet<Integer>();
                        tempSet.add(NextLabel);
                        linked.add(tempSet);
                        labels[y][x] = NextLabel;
                        NextLabel++;
                    }
                    
                    //Found labelled neighbour(s).
                    else 
                    {
                        labels[y][x] = Integer.MAX_VALUE;
                        for (int neighbor : neighbors) 
                        {
                            if (neighbor < labels[y][x])
                            {
                            	labels[y][x] = neighbor;
                            }
                        }

                        for (int neighbor : neighbors) 
                        {
                        	linked.get(neighbor).addAll(neighbors);
                        }
                    }
                }
            }
        }
    	
    	//Second pass
    	for (int y=0; y<field.length; y++) 
    	{
            for (int x=0; x<field[0].length; x++) 
            {
            	if (labels[y][x] < 0)
            	{
            		continue;
            	}
            		
                Set<Integer> equivalentLabels = linked.get(labels[y][x]);
                labels[y][x] = Integer.MAX_VALUE;
                for (int label : equivalentLabels) 
                {
                    if (label < labels[y][x]) 
                    {
                    	labels[y][x] = label;
                    }
                }
            }
        }
    	return labels;
	}

	private static void fillWithMinusOne(int[][] labels) 
	{
		for (int[] row : labels)
		{
			Arrays.fill(row, -1);
		}
	}
	
	private static boolean extractAndValidateBlobs(int[][] labels)
	{
		Vector<Integer> shipCounts = new Vector<>();
		
		int max = Collections.max(Stream.of(labels)
				   			 .map(a -> Collections.max(Arrays.stream(a).boxed()
				   			 .collect(Collectors.toList())))
				   			 .collect(Collectors.toList()));
		if (max != 9)
		{
			return false; //Should be 10 ships (9 since adjusted for index).
		}
		
		for (int i=0; i<=max; i++)
		{
			int xMin = Integer.MAX_VALUE;
			int xMax = 0;
			int yMax = 0;
			int yMin = Integer.MAX_VALUE;
			
	    	for (int y=0; y<labels.length; y++) 
	    	{
	            for (int x=0; x<labels[0].length; x++) 
	            {
	            	if (labels[y][x] == i)
	            	{
	            		if (x < xMin) xMin = x;
	            		if (x > xMax) xMax = x;
	            		if (y > yMax) yMax = y;
	            		if (y < yMin) yMin = y;
	            	}
	            }
	    	}
	    	int length = xMax - xMin + 1;
	    	int height = yMax - yMin + 1;
	    	
	    	if (length != 1 && height != 1)
	    	{
	    		return false; //Boat is the wrong shape.
	    	}
	    	
	    	shipCounts.add(Math.max(length, height)); //Add the ship size to the vector.
		}
		
		//Validate the number of ships of each size.
		Vector<Integer> referenceVec = new Vector<Integer>();
		List<Integer> l = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
		referenceVec.addAll(l);
		Collections.sort(shipCounts);
		
		return shipCounts.equals(referenceVec);
	}
}
