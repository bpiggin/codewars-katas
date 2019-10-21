import java.util.*;

public class CountingAtomsInMoleculesKata 
{
    private final static String NUMBER = ".*[0-9].*"; //Number
    private final static String LOWERCASE_LETTER = ".*[a-z].*"; //Lowercase letter
    private final static String UPPERCASE_LETTER = ".*[A-Z].*"; //Uppercase letter
	
    public static Map<String,Integer> getAtoms(String formula) 
    {
        if (!isValidChemicalFormula(formula))
        {
        	throw new IllegalArgumentException();
        }
        
        //For now just make H2O, Fe2SO4, C6H12O6 etc. work.
        char[] formulaArray = formula.toCharArray();
        
        for (int i=0; i<formulaArray.length; i++)
        {
        	//char c = formulaArray[i];
        }
        
        return new HashMap<String,Integer>();
    }
    
    
    /**
     * Helper methods.
     */
    private static boolean containsNumber(String s)
    {
    	return s.matches(NUMBER);
    }
    private static boolean containsLowercaseLetter(String s)
    {
    	return s.matches(LOWERCASE_LETTER);
    }
    private static boolean containsUppercaseLetter(String s)
    {
    	return s.matches(UPPERCASE_LETTER);
    }
    private static boolean isValidChemicalFormula(String formula) 
    {
        return containsNumber(formula) && containsLowercaseLetter(formula) && containsUppercaseLetter(formula);
    }
}
