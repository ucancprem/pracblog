package prac.recursion.dp;

/**
 * <img src="images/knight_tour.png/"> </br>
 * As we can see, a knight can move from a (r, c) cell into a maximum of eight other valid cells; 
 * that is, (r+2, c+1), (r+1, c+2), (r-1,c+2), (r-2, c+1), (r-2, c-1), (r-1, c-2), (r+1, c-2), and (r+2, c-1). 
 * 
 * Checking this in a sequence will help us be more efficient than picking one randomly. 
 * The counterclockwise circular path from (r, c) is (r+2, c+1), (r+1, c+2), (r-1, c+2), (r-2, c+1), (r-2, c-1), (r-1, c-2), (r+1, c-2), and (r+2, c-1)
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class KnightTour {

	private static final int gridSize=8;
	private static int[][] visited = new int[gridSize][gridSize];
	
	private static final int[] ROW_POS = {2,1,-1,-2,-2,-1, 1, 2,2};
	private static final int[] COL_POS = {1,2, 2, 1,-1,-2,-2,-1,1};
	
	private static void printSolution(){
		System.out.println("-------------");
		for(int i=0; i < gridSize; i++){
			for(int j=0; j < gridSize; j++){
				System.out.print(visited[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("-------------");
	}
	
	private static boolean isInBounds(int row, int col){
		return (row >= 0 && row < gridSize && col >= 0 && col < gridSize);		
	}
	
	private static void findPossiblePaths(int row, int col, int position){
		
		visited[row][col] = position;
		if(position >= gridSize * gridSize){
			printSolution();
			visited[row][col] = 0;// //backtrack and check for other positions
			return;
		}
		
		for(int i=0; i< ROW_POS.length; i++){
			int nextRow = row + ROW_POS[i];
			int nextCol = col + COL_POS[i];
			
			if(isInBounds(nextRow, nextCol) && visited[nextRow][nextCol] == 0 ){
				findPossiblePaths(nextRow, nextCol, position+1);
			}
		}	
		visited[row][col] = 0; //backtrack and check for other positions
	}
	
	public static void main(String[] args) {
		int row=0; //We start from a corner of the chessboard to be efficient
		int col=0;
		int position=1;
		
		findPossiblePaths(row, col, position);
		System.out.println("Done");
	}
}
