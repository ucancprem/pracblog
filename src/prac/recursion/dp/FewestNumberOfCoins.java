package prac.recursion.dp;

import java.util.Arrays;
import java.util.Collections;

/* 
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * Example 4:
 * Input: coins = [9,6,5,1], amount = 11
 * Output: 2
 */
public class FewestNumberOfCoins {
	
	/**
	 * INCORRECT - because does not work for coins = [9, 6, 5, 1] and amount 11.
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	private static int INCORRECT_SOLUTION_calculateFewestNumberOfCoins(int[] coins, int amount){
		if(amount <= 0 || coins == null || coins.length == 0){
			return 0;
		}
		int numOfCoinsUsed = 0;
		Arrays.sort(coins);
		
		int remainingAmount = amount;
		int requiredNumOfCoins = -1;
	
		for(int i=coins.length-1; i>=0 ; i --){
			requiredNumOfCoins = remainingAmount/coins[i]; // 11/5 = 2
			remainingAmount = remainingAmount % coins[i];  // 11 % 5 = 1
			
			if(requiredNumOfCoins > 0){
				numOfCoinsUsed += requiredNumOfCoins;	
			}
			if(remainingAmount == 0){
				return numOfCoinsUsed;
			}
		}
		
		return -1;
	}
	
	public int countNumOfCoinsForRemainer(int[] coins, int amount, int[][] cache, int currentCoin){
		if(cache[amount][currentCoin] > 0 ){
			return cache[amount][currentCoin];
		}
		
		
		
		return -99;
	}
	
	//{9, 6, 5, 1}; // 11
	//TODO: Fix Incomplete 
	public static int countNumOfCoins(int[] coins, int amount, int[][] cache, int currentCoinIndex){//2, 1
		
		if(currentCoinIndex >= coins.length ){
			return 0;
		}
		
		if(cache[amount][currentCoinIndex] > 0 ){
			return cache[amount][currentCoinIndex];
		}
		
		int currCoin = coins[currentCoinIndex]; //3
		int count = 0;
		for(int i=0 ; ( (i*currCoin <= amount)) ; i++){
			int remainder = amount - i*currCoin; // 3
			if(remainder == 0){
				count = count + i;
				cache[amount][currentCoinIndex] = count;
				return count;
			}
			count = countNumOfCoins(coins, remainder, cache, currentCoinIndex+1);
			
			if(count > 0) {
				count = count + i;
			}
		}
		cache[amount][currentCoinIndex] = count; //cache[8][] = 1
		return count;
	}
	
	public static void calculateMinNumOfCoins(int amount, int[] coins){
		int[][] table = new int[amount+1][coins.length+1];
		
	
		for(int i = 0; i<= amount ; i++){
			table[i][0] = Integer.MAX_VALUE;
		}
		
		//need no coins to make 0
		for(int j=0;j <= coins.length; j++){
			table[0][j] = 0;
		}
		
		for(int i=1; i <= amount ; i++){
			for(int j=1; j <= coins.length; j++){
				
				if(coins[j-1] <= i){
					int remainingAmt = i - coins[j-1];
					if(table[remainingAmt][j] == Integer.MAX_VALUE){
						table[i][j] = Math.min( table[remainingAmt][j], table[i][j-1]);
					} else {
						table[i][j] = Math.min( 1 + table[remainingAmt][j], table[i][j-1]);	
					}
						
				} else { //you can't use [j], so how can you make it with j-1
					table[i][j] = table[i][j-1];
				}
				
			}
		}
		
		System.out.println(Arrays.deepToString(table));
		System.out.println(String.format("Fewest number of coins needed are (%s) ", table[amount][coins.length]));
		
	}
	
	public static void main(String[] args) {
		int[] coins = //{1,2,5};
		 {9, 6, 5, 1}; //
		int amount = 11;
		
		//int[][] cache = new int[amount+1][coins.length];
		
        //System.out.println("Count (Memoization): " + FewestNumberOfCoins.countNumOfCoins(coins, amount, cache, 0));
		

		calculateMinNumOfCoins(amount, coins);
		//System.out.println(Arrays.deepToString(cache));		
	}
				
}
