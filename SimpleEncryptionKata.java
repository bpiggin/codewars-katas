import java.util.Arrays;

public class SimpleEncryptionKata 
{
	public static String encrypt(final String text, final int n) 
	{
		//Check for silly inputs
		if (!valid(text, n))
		{
			return text;
		}
		
		//Do the char substitution for the required number of iterations.
		String encryptedText = text.toString();
		for (int i=0; i<n; i++)
		{
			encryptedText = performSubstitution(encryptedText);
		}
		return encryptedText;
	}

	private static String performSubstitution(final String text) 
	{
		//Iterate through chars and build up the two strings
		String everySecondCharStr = "";
		String everyOtherCharStr = "";
		
		char[] charArray = text.toCharArray();
		for (int i=0; i<charArray.length; i++)
		{
			char c = charArray[i];
			
			if (i % 2 == 0)
			{
				everySecondCharStr += c;
			}
			else
			{
				everyOtherCharStr += c; 
			}
		}
		
		return everyOtherCharStr + everySecondCharStr;
	}

	public static String decrypt(final String encryptedText, final int n) 
	{
		//Check for silly inputs
		if (!valid(encryptedText, n))
		{
			return encryptedText;
		}
		
		//Do the char substitution for the required number of iterations.
		String decryptedText = encryptedText.toString();
		for (int i=0; i<n; i++)
		{
			decryptedText = performReverseSubstitution(decryptedText);
		}
		return decryptedText;
	}

	private static String performReverseSubstitution(final String encryptedText) 
	{
		char[] charArray = encryptedText.toCharArray();
		int length = charArray.length;
		char[] unsubstitutedArray = new char[length];
		
		char[] firstHalfArray = Arrays.copyOfRange(charArray, 0, (length / 2));
		char[] secondHalfArray = Arrays.copyOfRange(charArray, (length / 2), length);
				
		//First "half" of for loop are the even chars
		for (int i=0; i<firstHalfArray.length; i++)
		{
			unsubstitutedArray[(i * 2) + 1] = firstHalfArray[i];
		}
		
		//Second half are the odd chars
		for (int i=0; i<secondHalfArray.length; i++)
		{
			unsubstitutedArray[i * 2] = secondHalfArray[i];
		}
		
		return new String(unsubstitutedArray);
	}
	
	private static boolean valid(String str, int n)
	{
		return !(str == null || str == "" || n <= 0);
	}
}