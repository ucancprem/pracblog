package prac;

import java.util.Arrays;

public class ArrayCopy {
	
	private static void singleArrayCopy(){
		int[] arr = {1, 2, 3, 4, 5};
		int[] copy = new int[arr.length];
		
		copy = Arrays.copyOf(arr, arr.length);
		copy[0]=-99;
		copy[1]=-99;
		arr[4] = 999;
		
		System.out.println("For a 1D array changes in the copy of the array will not affect the source array and vice-versa");
		System.out.println("Source: "+ Arrays.toString(arr));
		System.out.println("Copy : "+ Arrays.toString(copy));
	}
	
	private static void twoDimensionalArrayCopy(){
		int[][] arr =  
			   {{5,4,3,4,5},
				{4,1,1,3,4},
				{4,1,1,3,3},
				{3,2,2,3,2},
				{2,1,1,2,1}};
		int[][] copy = new int[arr.length][arr[0].length];
		
		copy = Arrays.copyOf(arr, arr.length);
		copy[0][0]=-99;
		copy[1][0]=-99;
		arr[4][4] = 999;
		
		
		System.out.println("-------------------------------------");
		
		System.out.println("With a 2D array you'll see that copyOf makes only copy of the first level/shallow copy");
		System.out.println("So changes in one array will affect another");
		System.out.println("Source: "+ Arrays.deepToString(arr));
		System.out.println("Copy : "+Arrays.deepToString(copy));
	}
	
	private static void twoDimensionalArrayBetterCopy(){
		int[][] arr =  
			   {{5,4,3,4,5},
				{4,1,1,3,4},
				{4,1,1,3,3},
				{3,2,2,3,2},
				{2,1,1,2,1}};
		int[][] copy = new int[arr.length][arr[0].length];
		
		for(int i =0;i<arr.length; i++){
			copy[i] = Arrays.copyOf(arr[i], arr[i].length);	
		}
		
		
		copy[0][0]=-99;
		copy[1][0]=-99;
		arr[4][4] = 999;
		
		
		System.out.println("-------------------------------------");
		
		System.out.println("Better way of copying and avoid shallow copy issues are to copy at the row level");
		System.out.println("Now changes in one array will NOT affect another");
		System.out.println("Source: "+ Arrays.deepToString(arr));
		System.out.println("Copy : "+Arrays.deepToString(copy));
	}


	public static void main(String[] args) {
		singleArrayCopy();
		twoDimensionalArrayCopy();
		twoDimensionalArrayBetterCopy();
		
	}
}
