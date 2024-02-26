package prac.recursion.dp;

import java.util.Arrays;

/**
 * A person walks up a staircase. They can hop either one step, two steps, or three steps at a time. 
 * Count the number of possible ways they can reach the top of the staircase.
 * 
 * Mainly, the nth step can be reached if we do the following:

		n-1 step and hop 1 step
		n-2 step and hop 2 steps
		n-3 step and hop 3 steps
 * </br>
 * <img src="images/staircase.png"></br>
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class StairCase {

	private static int countNumOfOfWaysTo(int stairCaseNum){
		if(stairCaseNum < 0){
			return 0;
		}
		if(stairCaseNum == 0){
			return 1;
		}
		
		return countNumOfOfWaysTo(stairCaseNum-1) + countNumOfOfWaysTo(stairCaseNum-2) + countNumOfOfWaysTo(stairCaseNum-3); 
		
	}
	
	private static int countNumOfOfWaysViaMemoization(int stairCaseNum, int[] cache){
		if(stairCaseNum == 0){
			return 1; //If you're able to make the jump to 0, this is a valid jump 
		}
		if(stairCaseNum < 0){
			return 0;
		}
		if(cache[stairCaseNum] > 0 ){
			return cache[stairCaseNum];
		}
		
		cache[stairCaseNum] = countNumOfOfWaysViaMemoization(stairCaseNum -1, cache) + 
				countNumOfOfWaysViaMemoization(stairCaseNum - 2, cache) +
				countNumOfOfWaysViaMemoization(stairCaseNum - 3, cache);
		
		return cache[stairCaseNum];
	}
	
	public static void main(String[] args) {
		int topStep = 6;
		int numOfWays = countNumOfOfWaysTo(topStep);
		int[] cache = new int[topStep+1];
		countNumOfOfWaysViaMemoization(topStep, cache);
		System.out.println(numOfWays);
		System.out.println(Arrays.toString(cache));
		System.out.println(cache[topStep]);
	}
}
