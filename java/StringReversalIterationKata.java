import java.util.ArrayList;

public class StringReversalIterationKata 
{
	public static String stringFunc(String s, long x)
	{
		String result = s;
		int length = s.length();
		//Use a stringbuilder
		StringBuilder sb = new StringBuilder();
		
		//Store iterations in a list.
		ArrayList<String> list = new ArrayList<>(length);
		list.add(s);
		
		for (int i=0; i<x; i++)
		{
			result = performIteration(result, sb, length);
			list.add(result);
			
			if (result.equals(s))
			{
			    long requiredIterations = x;
			    if (x > i + 1) requiredIterations = x % (i + 1);
			    return list.get((int)requiredIterations);
			}
		}
		return list.get((int)x);
	}
	
	private static String performIteration(String input, StringBuilder sb, int length)
	{
		char[] inputArray = input.toCharArray();
		sb.setLength(0);
		
		//Strings with a non-even number of entries will have a middle char.
		int numberOfIterations = 0;
		if (length % 2 == 0) numberOfIterations = length / 2;
		else numberOfIterations = (length / 2) + 1;
		
		for (int i=0; i<numberOfIterations; i++)
		{
			if (length % 2 != 0 && i == numberOfIterations - 1)
			{
				char middleChar = inputArray[numberOfIterations - 1];
				sb.append(middleChar);
				break;
			}
			
			char second = inputArray[length - 1 - i];
			char first = inputArray[i];
			sb.append(second);
			sb.append(first);
		}
		return sb.toString();
	}
}
