package prac;

import java.util.PriorityQueue;

public class PriorityQueuePrac {
	
	private static void fillInPriorityQueue(PriorityQueue<Integer> pQueue){
		for(int i=0; i < 5; i++){
			pQueue.add(i);
			pQueue.add(i-1);
		}
	}
	
	private static void familiarizeWithPriorityQueueUsingInt(){
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		fillInPriorityQueue(pQueue);
		
		System.out.println("Printing the queue shows no order "+pQueue);
		System.out.println("-------------------------------------------");
		System.out.println("Polling the queue shows the expected order ");
		for(int i=0; i < 5; i++){
			int first = pQueue.poll();
			assert first == i-1; //reverser order due to priority being maintained.
			System.out.println(first);
			
			int next = pQueue.poll();
			assert next == i;
			System.out.println(next);
		}
		
		fillInPriorityQueue(pQueue);
		System.out.println("-------------------------------------------");
		System.out.println("Iterating PriorityQueue WON't work if looking for order");
		for(int next: pQueue){
			System.out.println(next);
		}
		
	}
	
	public static void main(String[] args) {
		familiarizeWithPriorityQueueUsingInt();
	}

}
