import java.util.Arrays;
import java.util.Vector;
import java.util.stream.IntStream;

public class ReversingInputStreamKata 
{
	  public static int[] DataReverse(int[] data) 
	  {
		  Vector<int[]> dataVec = new Vector<int[]>();
		  
		  //Extract the data elements from the old array (they are 8 bits in length).
		  for (int i=0; i<data.length / 8; i++)
		  {
			  int[] dataElement = Arrays.copyOfRange(data, i * 8, (i + 1) * 8);
			  dataVec.add(0, dataElement); //Always add at start to reverse the order.
		  }
		  
		  //Create the new array reversing the order of the data elements.
		  int[] reversedArray = dataVec.firstElement();
		  for (int i=1; i<dataVec.size(); i++)
		  {
			  reversedArray = IntStream.concat(Arrays.stream(reversedArray), Arrays.stream(dataVec.get(i))).toArray();  
		  }
		  return reversedArray;
	  }
}