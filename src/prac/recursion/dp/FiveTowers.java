package prac.recursion.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Consider a 5x5 grid with five defensive towers spread across the grid. </br>
 * To provide an optimal defense for the grid, we have to build a tower on each row of the grid.</br> 
 * Find all the solutions for building these towers so that none of them share the same column and diagonal.</br>
 * <img src="images/five_towers.png"/> </br>
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class FiveTowers {

	/**
	 * DOES NOT WORK
	 */
	private static boolean isDiagonalElement(int currRow, int currCol, int row, int filledCol) {
		int filledPosition = Math.abs(row - filledCol);
		int postitionToCheck = Math.abs(currRow - currCol);
		int filledPosition1 = row + filledCol;
		int postitionToCheck1 = currRow + currCol;
		if(filledPosition == postitionToCheck || filledPosition1 == postitionToCheck1){
			return false;
		}
		
		return true;
	}
	
	private static boolean canBuild(Integer[] columns, int nextRow, int nextColumn) {
		
		
		for(int currentRow = 0; currentRow < nextRow ;  currentRow++){
			int currentCol = columns[currentRow];
			if( currentCol ==  nextColumn){
				return false;
			}
			
			int colPos =  Math.abs(currentCol - nextColumn);
			int rowPos = nextRow - currentRow;
			
			if(colPos == rowPos){
				return false;
			}
		}
		return true;
	}
	
	private static void allPossibleLocations(int row, Integer[] columns, Set<Integer[]> towerPositions){
		
		if(row == columns.length){
			System.out.println(Arrays.toString(columns));
			towerPositions.add(columns);
			return;
		} 
		
		for(int col=0; col< columns.length; col++){
			if(canBuild(columns, row, col)){
				columns[row]=col;
				allPossibleLocations(row+1, columns, towerPositions);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Set<Integer[]> towerPositions = new HashSet<>();
		allPossibleLocations(0, new Integer[5], towerPositions);
		
		//grid - row length == col.length
		
		for(Integer[] position: towerPositions){
            System.out.println(Arrays.toString(position));
		}
	}
}
