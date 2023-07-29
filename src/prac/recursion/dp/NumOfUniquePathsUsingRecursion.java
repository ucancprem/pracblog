package prac.recursion.dp;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).</br> 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).</br> 
 * The robot can only move either down or right at any point in time. </br>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach </br> 
 * the bottom-right corner. </br>
 * 
 * Case 1
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * Case 2
 * Input: m = 3, n = 2
 * Output: 3
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class NumOfUniquePathsUsingRecursion {
	
	 private int uniquePaths(int m, int n) {
	    if(m < 0 || n < 0){
	    	return 0;
	    }
	    if(m == 0 && n ==0 ){
	    	return 1;
	    }
	    return uniquePaths(m-1, n) + uniquePaths(m, n-1);
		 
	 }
	 
	 public static void main(String[] args) {
		int row = 3;
		int col = 2;
		NumOfUniquePathsUsingRecursion numOfPaths = new NumOfUniquePathsUsingRecursion();
		
		//case1
		int numOfUniquePaths = numOfPaths.uniquePaths(row-1, col-1);
		assert (3 == numOfUniquePaths);
		System.out.println(String.format("Recursion:: Num of uniquePaths for (row,col) (%d,%d) is %d", row, col, numOfUniquePaths));
		
		//case2
		row = 3;
		col = 7;
		numOfUniquePaths = numOfPaths.uniquePaths(row-1, col-1);
		assert (28 == numOfUniquePaths);
		System.out.println(String.format("Recursion:: Num of uniquePaths for (row,col) (%d,%d) is %d", row, col, numOfUniquePaths));
		
		//case3
		row = -1;
		col = -1;
		numOfUniquePaths = numOfPaths.uniquePaths(row-1, col-1);
		assert (0 == numOfUniquePaths);
		System.out.println(String.format("Recursion:: Num of uniquePaths for (row,col) (%d,%d) is %d", row, col, numOfUniquePaths));

	}
}
