package prac;

import java.util.Arrays;

/**
 * - Median is an important measure (compared to mean) for distorted data,
 * 		 because median is not so easily distorted. For example, median of {1, 2, 2, 5, 100) is 2 and mean is 22.
	- If user add a constant to every value, the mean and median increase by the same constant.
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class MedianHelper {

	public static double getMedian(Integer[] arr){
		int[] arr1 = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
		return getMedian(arr1);
	}
	
	public static double getMedian(int[] arr){
		Arrays.sort(arr);
		int arrLen = arr.length;
		if( arrLen %2 == 0){
			int midpoint = arrLen/2;
			return (double)(arr[midpoint-1] + arr[midpoint])/2;
		} else {
			return arr[arrLen/2];
		}
	
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 6, 5, 8, 7}; // 1, 2, 3, 4, 5, 6, 7, 8 = 4.5
		int[] arr1 = {1, 3, 4, 2, 6, 5, 8}; // 1, 2, 3, 4, 5, 6, 7 = 4
		
		System.out.println(getMedian(arr));
		System.out.println(getMedian(arr1));
	}
}
