import java.util.Vector;

public class RemoveCommentsKata 
{
	public static String stripComments(String text, String[] commentSymbols) 
	{
		String lines[] = text.split("\\n");
		Vector<String> linesWithoutComments = new Vector<>();
		
		for (String line : lines)
		{
			//Find the index of any comment markers.
			int index = findIndexOfEarliestMarker(commentSymbols, line);
			
			if (index == Integer.MAX_VALUE)
			{
				linesWithoutComments.add(line.stripTrailing());
				continue;
			}
			
			linesWithoutComments.add(line.substring(0, index).stripTrailing());
		}
		
		//Append strings back together with newline markers.
		return String.join("\n", linesWithoutComments);
	}

	private static int findIndexOfEarliestMarker(String[] commentSymbols, String line) 
	{
		int indexOfEarliestMarker = Integer.MAX_VALUE;
		for (String symbol : commentSymbols)
		{
			int index = line.indexOf(symbol);
			if (index < indexOfEarliestMarker && index != -1)
			{
				indexOfEarliestMarker = index;
			}
		}
		return indexOfEarliestMarker;
	}
}
