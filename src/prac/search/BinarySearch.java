package prac.search;

public class BinarySearch {

	private static int search(int[]arr, int numberToFind, int lIndex, int rIndex){
		
		if( lIndex > rIndex){
			return -1;
		}
		
		int mid = (lIndex + rIndex)/2;
		if(arr[mid] == numberToFind){
			return mid; //found at index mid
		}
		if( numberToFind < arr[mid] ){
			return search(arr, numberToFind, lIndex, mid-1);
		}
		else {
			return search(arr, numberToFind, mid+1, rIndex);
		}

	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		
		//test left
		int num = 1;
		int index = search(arr, num, 0, arr.length-1);
		System.out.println(String.format("Number (%d) found at (%d)", num, index));
		
		//test right
		num = 6;
		index = search(arr,num, 0, arr.length-1);
		System.out.println(String.format("Number (%d) found at (%d)", num, index));
		
		//test number not in array.
		num = 99;
		index = search(arr,num, 0, arr.length-1);
		System.out.println(String.format("Number (%d) found at (%d)", num, index));
	}
}

