package prac.recursion.dp;

import java.util.Arrays;

public class MagicIndex {

	private static int findMagicIndex(int[] arr, int low, int high){
		
		if(low > high){
			return -1;
		}
		
		int mid = (low+high)/2;

		/* THIS WILL NOT WORK; COMMON MISTAKE INLCUDING IN BOOKS, SEE EXAMPLE 1
		 * The code never goes past this if the midvalue==index.
		 */
//	    int value = arr[mid];
//	    if (value == mid) {                                     
//	        return mid;
//	    }
		
		
	    int retVal = findMagicIndex(arr, low, Math.min(mid-1, arr[mid])); // Since the array is ordered, we can pick the lowest number (Math.min)
	    																 //  0,1,1,1,1,1,6,8,9	- since the arr[4] =1, the magic number will not appear until arr[1]
	    																//	without this, we really gain no efficiency. 
	    if(retVal > -1){
	    	return retVal;
	    }
	    
	    if (arr[mid] == mid) {                                     
	    	return mid;
	    }
	  

	    return findMagicIndex(arr, Math.max(mid+1, arr[mid]), high);// Since the array is ordered, we can pick the lowest number  (Math.mzx)
																	 //  -5,-1,-1,-1,8,8,8,9,9	- since the arr[4] =1, the magic number will not appear until arr[1]
																	//	without this, we really gain no efficiency. 
	    
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,1,1,14,15,16};
		int magicIndex = findMagicIndex(arr, 0, arr.length-1);
		System.out.println(String.format("Magic index of (%s) is (%s)", Arrays.toString(arr), magicIndex));
		
		int[] arr1 = {1,4,4,4,5,5,6,6,6,11,12,12,12,15,17,20,21,21};
		magicIndex = findMagicIndex(arr1, 0, arr1.length-1);
		System.out.println(String.format("Magic index of (%s) is (%s)", Arrays.toString(arr1), magicIndex));
		

		int[] arr2 = {-6,-5, -4, -3, -2, 8,8,8,9,9};
		magicIndex = findMagicIndex(arr2, 0, arr2.length-1);
		System.out.println(String.format("Magic index of (%s) is (%s)", Arrays.toString(arr2), magicIndex));
	}
}
