package prac.recursion.dp;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  Consider a group of n men arranged in a circle (1, 2, 3, ..., n). 
 *  Every kth man will be killed around the circle until only one survivor remains. 
 *  Write an algorithm that finds the position of this survivor. This is known as the Josephus problem
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class JosephusProblem {
	
	private Queue<Integer> initializeQueue(int n) {
		Queue<Integer> queue =  new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++){
			queue.add(i);
		}
		return queue;
	}
	
	private int getSurvivorPoistion(int n, int k){
		if(n <= 0 || k <= 0 ){
			return 0;
		}
		Queue<Integer> queue = initializeQueue(n);
		while(queue.size() != 1){
			for(int i = 1; i <= k; i++){
				Integer nextPerson = queue.poll();
				if(i == k){
					System.out.println(String.format("Next person executed is (%d)", nextPerson.intValue()));
					break;
				}
				queue.add(nextPerson);
			}
		}
		
		return queue.peek().intValue();
		
	}
	
	public static void main(String[] args) {
		int n = 15;
		int k = 3;
		JosephusProblem josephusProblem = new JosephusProblem();
		int survivor = josephusProblem.getSurvivorPoistion(n, k);
		System.out.println("-----------------------------------");
		System.out.println(String.format("Surviving positiong is (%d)", survivor));
		System.out.println("-----------------------------------");
	}
}
