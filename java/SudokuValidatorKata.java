import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class SudokuValidatorKata 
{	
    public static boolean check(int[][] sudoku) 
    {
    	for (int i=0; i<sudoku.length; i++)
    	{
    		int[] row = sudoku[i];
    		int[] column = getColumn(sudoku, i);
    		
    		if(!validateColumnOrRow(row)) return false;
    		if(!validateColumnOrRow(column)) return false;
    	}
        return validateBlocks(sudoku);
    }
    
    private static boolean validateBlocks(int[][] matrix)
    {
    	Set<Integer> map = new TreeSet<>();
    	for (int i=0; i<matrix.length; i += 3)
    	{
    		for (int j=i; j<i+3; j++) //Rows
    		{
    			for (int k=i; k<i+3; k++) //Cols
    			{
    				int number = matrix[j][k];
    				if (number > 0 && number < 10) map.add(number);
    			}
    		}
    		if (map.size() != 9) return false;
    	}
    	return true;
    }
    
    private static boolean validateColumnOrRow(int[] set)
    {
    	Set<Integer> map = new TreeSet<>();
    	for (int number : set)
    	{
    		if (number > 0 && number < 10) map.add(number);
    	}
    	return map.size() == 9; //All of 1-9 present.
    }
    
    private static int[] getColumn(int[][] matrix, int column)
    {
    	return IntStream.range(0, matrix.length).map(i -> matrix[i][column]).toArray();
    }
}
