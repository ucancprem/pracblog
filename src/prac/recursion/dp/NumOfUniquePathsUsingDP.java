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
 * 1 1
 * 1 2
 * 1 3
 * 
 * @author premkumarnarayanappavenkatesh
 *
 *
 *
 */
public class NumOfUniquePathsUsingDP {
	
	private int[][] getInitializedRowAndColumn(int m, int n) {
		// TODO Auto-generated method stub
		int[][] arr = new int[m][n];
		for(int i=0;i<m;i++){
			arr[i][0] = 1;
		}
		for(int i=0;i<n;i++){
			arr[0][i] = 1;
		}
		
		for(int i=0; i<m; i++){	
	    	for(int j=0; j<n; j++){
	    		System.out.print(arr[i][j]+"\t");
	    	}
	    	System.out.println("");
		} 	
		
		return arr;
	}
	
	 private int uniquePaths(int m, int n) {
		
		 if( m<1 || n<1){
			 return 0;
		 }
		 
	    int[][] arr = getInitializedRowAndColumn(m, n);
	    for(int i=1; i<m; i++){
	    	for(int j=1; j<n; j++){
	    		arr[i][j] = arr[i-1][j] + arr[i][j-1];
	    	}
	    }
		 
	    return arr[m-1][n-1];//remove
	 } 

	public static void main(String[] args) {
		int row = 3;
		int col = 2;
		NumOfUniquePathsUsingDP numOfPaths = new NumOfUniquePathsUsingDP();
		
		//case1
		int numOfUniquePaths = numOfPaths.uniquePaths(row, col);
		assert (3 == numOfUniquePaths);
		System.out.println(String.format("DP:: Num of uniquePaths for (row,col) (%d,%d) is %d", row, col, numOfUniquePaths));
		
		//case2
		row = 3;
		col = 7;
		numOfUniquePaths = numOfPaths.uniquePaths(row, col);
		assert (28 == numOfUniquePaths);
		System.out.println(String.format("DP:: Num of uniquePaths for (row,col) (%d,%d) is %d", row, col, numOfUniquePaths));
		
		//case3
		row = -1;
		col = -1;
		numOfUniquePaths = numOfPaths.uniquePaths(row, col);
		assert (0 == numOfUniquePaths);
		System.out.println(String.format("DP:: Num of uniquePaths for (row,col) (%d,%d) is %d", row, col, numOfUniquePaths));

	}
}
