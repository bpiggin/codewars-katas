import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class HumanReadableTimeKata 
{
	private final static int YEAR_DUR_SEC = (3600 * 24 * 365);
	
	private final static String SPACE = " ";
	private final static String DELIMETER = ", ";
	private final static String AND = "and";
	
	private final static String YEAR = "year";
	private final static String DAY = "day";
	private final static String HOUR = "hour";
	private final static String MINUTE = "minute";
	private final static String SECOND = "second";
	
	public static String makeReadable(int seconds) 
	{
		if (seconds == 0)
		{
			return "now";
		}
		
		int years = seconds / YEAR_DUR_SEC;
		seconds -= years * YEAR_DUR_SEC;
		long days = TimeUnit.SECONDS.toDays(seconds);
		seconds -= TimeUnit.DAYS.toSeconds(days);
		long hours = TimeUnit.SECONDS.toHours(seconds);
		seconds -= TimeUnit.HOURS.toSeconds(hours);
		long minutes = TimeUnit.SECONDS.toMinutes(seconds);
		seconds -= TimeUnit.MINUTES.toSeconds(minutes);
		
		Vector<String> stringsVec = new Vector<>();
		formatTimeAndAddToVectorIfNonZero(years, YEAR, stringsVec);
		formatTimeAndAddToVectorIfNonZero(Math.toIntExact(days), DAY, stringsVec);
		formatTimeAndAddToVectorIfNonZero(Math.toIntExact(hours), HOUR, stringsVec);
		formatTimeAndAddToVectorIfNonZero(Math.toIntExact(minutes), MINUTE, stringsVec);
		formatTimeAndAddToVectorIfNonZero(seconds, SECOND, stringsVec);
		
		String retval = "";
		int size = stringsVec.size();
		//If more than two things to display add these comma delimeted
		if (size > 2)
		{
			for (int i=0; i<size - 2; i++)
			{
				retval += stringsVec.get(i);
				retval += DELIMETER;
			}
		}
		
		if (size > 1)
		{
			retval += stringsVec.get(size - 2);
			retval += SPACE;
			retval += AND;
			retval += SPACE;
		}
		
		retval += stringsVec.get(size - 1);
		
		return retval;
	}

	private static void formatTimeAndAddToVectorIfNonZero(int num, String unit, Vector<String> vec) 
	{
		StringBuilder sb = new StringBuilder();
		if (num != 0)
		{
			sb.append(num);
			sb.append(SPACE);
			sb.append(unit);
			if (num > 1)
			{
				sb.append("s");
			}
		}
		
		String timeStr = sb.toString();
		if (!timeStr.isBlank())
		{
			vec.add(timeStr);
		}
	}
}
