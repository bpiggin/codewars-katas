import java.util.Arrays;

public class IntToIvP4Kata 
{
	public static String longToIP(long ip) 
	{
		int octet1Int = 0;
		int octet2Int = 0;
		int octet3Int = 0;
		int octet4Int = 0;
		
		String binary = Long.toBinaryString(ip);
		
		//Pad with zeroes if necessary.
		if (binary.length() < 32)
		{
			int length = 32 - binary.length();
			char[] padArray = new char[length];
			Arrays.fill(padArray, '0');
			String padString = new String(padArray);
			binary = padString + binary;
		}
		String octet1 = binary.substring(0, 8);
		octet1Int = Integer.parseInt(octet1, 2);
		
		if (binary.length() > 8)
		{
			String octet2 = binary.substring(8, 16);
			octet2Int = Integer.parseInt(octet2, 2);
		}
		
		if (binary.length() > 16)
		{
			String octet3 = binary.substring(16, 24);
			octet3Int = Integer.parseInt(octet3, 2);
		}
		
		if (binary.length() > 24)
		{
			String octet4 = binary.substring(24, 32);
			octet4Int = Integer.parseInt(octet4, 2);
		}
		
		return octet1Int + "." + octet2Int + "." + octet3Int + "." + octet4Int;
	}
}
