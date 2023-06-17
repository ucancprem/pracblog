package euler;

import java.util.stream.IntStream;

public class SumMultiplesOf3Or5 {

	private static int getSumMultiplesOf3Or5Java8(int maxValue){
		return IntStream.range(1, maxValue).filter(i->(i%3==0 || i%5==0)).limit(maxValue).sum();
	}
	
	private static int getSumMultiplesOf3Or5(int maxValue){
		int i=1;
		int sum=0;
		while(i<maxValue){
			if(i%3==0 || i%5==0){
				sum=sum+i;
			}
			i++;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(getSumMultiplesOf3Or5(10));
		System.out.println(getSumMultiplesOf3Or5Java8(10));
		System.out.println(getSumMultiplesOf3Or5(1000));
		System.out.println(getSumMultiplesOf3Or5Java8(1000));
	}
}
