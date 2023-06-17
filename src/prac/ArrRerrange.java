package prac;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Take Array A and arrange into a new array B such that B[0] <= B[1] >= B[2] <= B[3] >= B[4]
public class ArrRerrange {
	
	// 1, 3, 5, 2, 6, 8, 4
	// 1, 3, 2, 6, 5, 8, 4 
	

	/**
	 * you may notice that the desired ordering is very local, and realize that it is not necessary to find the median.
	 *  Iterating through the array and swapping A[i\ and A[i + 1] when i is even and A[i] > A[i + 1] or
	 *   i is odd and A[i] < A[i + 1] achieves the desired configuration.
	 *   
	 * @param originalList
	 * @return
	 */
	
	private static List<Integer> reArrange(List<Integer> originalList) {
		// TODO Auto-generated method stub
		for(int i=0 ; i <= originalList.size() - 2 ; i++){
			if((i%2 == 0 && originalList.get(i) >= originalList.get(i+1)) ||
					(i%2 == 1 && originalList.get(i) <= originalList.get(i+1))){
				Collections.swap(originalList, i, i+1);
			}
		}
		
		return originalList;
	}
	

	private static List<Integer> reArrangeByMedian(List<Integer> originalList) {
		Integer[] arr =  originalList.toArray(new Integer[originalList.size()]);
				
		double median = MedianHelper.getMedian(arr);
		
		for(int i=0 ; i <= originalList.size() - 2 ; i++){
			if(i%2 == 0 && originalList.get(i).intValue() > median || 
				i%2 != 0 && originalList.get(i).intValue() < median){
				Collections.swap(originalList, i, i+1);
			}
		}
		
		return originalList;
	}
	
	

	public static void main(String[] args) {
		List<Integer> originalList = Arrays.asList(1,3,5,2,6,8,4);
		System.out.println(reArrange(originalList));
		System.out.println(reArrangeByMedian(originalList));
		
		originalList = Arrays.asList(10,53,5,62,16,80,4);
		System.out.println(reArrange(originalList));
		System.out.println(reArrangeByMedian(originalList));
	}

}
