package prac.recursion.dp;

//LargestConnectedGrid Or BiggestColorSpot
public class LargestConnectedGrid {
	
	private static int checkForAdjacentCells(int[][] arr, int i, int j, int row, int col, int count){
		int value = arr[i][j];
		arr[i][j] = -arr[i][j]; //marking as visited
		
		if(i > 0 && arr[i-1][j] == value){
			return checkForAdjacentCells(arr, i-1, j, row, col, count+1);
		}
		if(j > 0 && arr[i][j-1] == value){
			return checkForAdjacentCells(arr, i, j-1, row, col, count+1);
		}
		if(i < row-1 && arr[i+1][j] == value){
			return checkForAdjacentCells(arr, i+1, j, row, col,  count+1);
		}
		if(j < col-1 && arr[i][j+1] == value){
			return checkForAdjacentCells(arr, i, j+1, row, col,  count+1);
		}
		return count;
	}
	
	
	private static void getLargestConnectedGraph(int[][] arr){
		int row = arr.length;
		int col = arr[0].length;
		int largestCount = 1;
		int largestConnectedValue = Integer.MIN_VALUE;
		
		for(int i=0; i < row; i++){
			for(int j=0; j < col; j++){
				
				if(arr[i][j] > 0){ //prevent calling same cells
					int currCount =  checkForAdjacentCells(arr, i, j, row, col, 1);
					if(currCount > largestCount){
						largestCount = currCount;
						largestConnectedValue = -arr[i][j]; 
					}
				}
				
			}
		}
		System.out.println(String.format("Largest connected value is (%s) with total connected cells of (%s)", largestConnectedValue, largestCount ));
		
	}


	public static void main(String[] args) {
		int input[][] = {{1, 4, 4, 4, 4, 3, 3, 1},
                		 {2, 1, 1, 4, 3, 3, 1, 1},
                		 {3, 2, 1, 1, 2, 3, 2, 1},
                		 {3, 3, 2, 1, 2, 2, 2, 2},
                		 {3, 1, 3, 1, 1, 4, 4, 4},
                		 {1, 1, 3, 1, 1, 4, 4, 4}};
		
		getLargestConnectedGraph(input);
	}
}

