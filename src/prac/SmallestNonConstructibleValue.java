package prac;

import java.util.Arrays;

/**
 * Suppose you were asked to write a program which takes an array of positive integers and returns the smallest number which is not to the sum of a subset of elements of the array.
 * 
 * We can get a great deal of insight from some small concrete examples. 
 * 		Observe that(1,2}produces1,2,3,and(1,3}produces1,3,4. A trivial observation is that the smallest element in the array sets a lower bound on the change amount that can be constructed from that array, so if the array does not contain a 1, it cannot produce 1.
 * 		 However, it may be possible to produce 2 without a 2 being present, since there can be 2 or more Is present.
	
	
	Continuing with a larger example, (1,2,4) produces 1,2,3,4,5,6,7, and (1,2,5) produces1,2,3,5,6,7,8. 
	Generalizing,suppose a collection of number scan produce every value up to and including V ,but not V + 1. 
	Now consider the effect of adding a new element u to the collection. If `u < V + 1`, 
	we can still produce every value up to and including V+u and we cannot produce `V+u+1`.
	On the other hand,if u >V+l, then even by adding u to the collection we cannot produceV+l.
 *
 *
 *  Another observation is that the order of the elements within the array makes no difference to the amounts that are constructible. 
 *	However, by sorting the array allows us to stop when we reach a value that is too large to help, since all subsequent values
 *
 *The time complexity as a function of n, the length of the array, is 0(n log n) to sort and 0(n) to iterate, i.e., 0(n log n).
 */
public class SmallestNonConstructibleValue {
	
	private static int findSmallestNonConstructibleValue(int[] listOfCoins) {
		Arrays.sort(listOfCoins); //Sort so we can stop as soon as we find the first value that is not going to affect leastSum
		int currentSmallestPossibleValue = 0;
		for(int nextInt : listOfCoins){
			if(nextInt > currentSmallestPossibleValue +1){ // smallest possible value is already found; currentInt will break the smallest value
				break;
			}
			currentSmallestPossibleValue+=nextInt;
		}
		
		return currentSmallestPossibleValue + 1 ;// `+1` - > max possible val +1 is the value non constructible
	}
	
	public static void main(String[] args) {
		int[] listOfCoins = {1,2,2,4,12,15};
		int value = findSmallestNonConstructibleValue(listOfCoins);
		System.out.println(value);
	}

	
}
