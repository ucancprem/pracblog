package prac.recursion.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all the valid combinations of n pairs of curly braces. 
 * A valid combination is when the curly braces are properly opened and closed. 
 * For n=3, the valid combinations are as follows:
	{{{}}},{{}{}},{{}}{},{}{{}},{}{}{}
	
 * @author premkumarnarayanappavenkatesh
 *
 */
public class CurlyBraces {
	
	private static List<String> combinationOfBraces =  new ArrayList<>();
	private static final char LEFT_BRACE = '{';
	private static final char RIGHT_BRACE = '}';
	private static final int numberOfBraces = 3;
	
	private static void combinationOfBraces(int remainingLeftBraces, int remainingRightBraces, String currentCombination){
						
		if(remainingRightBraces < remainingLeftBraces ||  remainingLeftBraces < 0){ //Prevent cases of adding a left brace after all right braces are added.
			return;
		}
		if(currentCombination.length() == numberOfBraces * 2){
			combinationOfBraces.add(currentCombination);
			return;
		}
		//if(remainingLeftBraces > 0) //moved to initial check
			combinationOfBraces(remainingLeftBraces - 1, remainingRightBraces, currentCombination + LEFT_BRACE);

		//if(remainingRightBraces > 0)
			combinationOfBraces(remainingLeftBraces, remainingRightBraces - 1, currentCombination + RIGHT_BRACE);
		
	}
	
	public static void main(String[] args) {
		combinationOfBraces(numberOfBraces, numberOfBraces, "");
		System.out.println(combinationOfBraces);
	}

}
