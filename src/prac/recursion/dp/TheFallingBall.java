package prac.recursion.dp;

import java.util.Arrays;

/**
 * Consider an m x n grid where each (m, n) cell has an elevation represented by a number between 1 and 5 
 * (5 is the highest elevation). A ball is placed in a cell of the grid. 
 * This ball can fall into another cell, as long as that cell has a smaller elevation than the ball cell. 
 * The ball can fall in four directions: north, west, east, and south. 
 * Display the initial grid, as well as the grid after the ball falls on all possible paths. 
 * Mark the paths with 0
 * <img src="images/falling_ball.png"/> </br>
 *
 */
public class TheFallingBall {
	
	
	private static void computeAllPaths(int[][] arr,int[][] result,  int initRow, int initCol, int previousVal) {
	
		
		if(initRow >= 0 && initRow < arr.length &&  initCol >= 0 & initCol < arr[0].length){
				
			int currVal = arr[initRow][initCol];
			if(currVal < previousVal &&  currVal > 0 &&  previousVal >0){
				result[initRow][initCol] = 0;
				
				computeAllPaths(arr, result, initRow, initCol-1, currVal);
				computeAllPaths(arr, result, initRow-1, initCol, currVal);
				computeAllPaths(arr, result, initRow, initCol+1, currVal);
				computeAllPaths(arr, result, initRow+1, initCol, currVal);
				
			}
			
		}
		
	}
	
	public static void computePath(int prevElevation, int i, int j, int rows, int cols, int[][] elevations) {

		    // ensure the ball is still on the grid

		    if (i >= 0 && i <= (rows-1) && j >= 0 && j <= (cols-1)) {
		        int currentElevation = elevations[i][j];

		        if (prevElevation >= currentElevation && currentElevation > 0) {
		            prevElevation = currentElevation;

		            elevations[i][j] = 0;
		            computePath(prevElevation,i,j-1, rows,cols,elevations);

		            computePath(prevElevation,i-1,j,rows,cols,elevations);              

		            computePath(prevElevation,i,j+1,rows,cols,elevations);              

		            computePath(prevElevation,i+1,j,rows,cols,elevations);

		        }

		    }

		}
	
	public static void main(String[] args) {
		int[][] arr =  
			   {{5,4,3,4,5},
				{4,1,1,3,4},
				{4,1,1,3,3},
				{3,2,2,3,2},
				{2,1,1,2,1}};
		//int[][] result = Arrays.copyOf(arr, arr.length);
		int[][] result = new int[arr.length][arr[0].length];
		
		for(int i=0; i< arr.length ; i++){
			result[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		
		System.out.println(Arrays.deepToString(result));
		
		int initRow = 0;
		int initCol = 4;
		
		computeAllPaths(arr, result, initRow, initCol, Integer.MAX_VALUE);
		//result[initRow][initCol] = 0;
		System.out.println(Arrays.deepToString(result));
		computePath(arr[initRow][initCol], initRow, initCol, arr.length, arr[0].length, arr);
		System.out.println(Arrays.deepToString(arr));

	}

}
