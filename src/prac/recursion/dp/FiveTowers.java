package prac.recursion.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

	private static boolean canbuild(int currRow, int currCol, int len, Set<Integer[]> towerPositions ){
		if(towerPositions.contains(currCol)){
			return false;
		}
		//TODO
		return true;
	}
	
	private static void allPossibleLocations(int row, Integer[] col, Set<Integer[]> towerPositions){
		
	
		for(int i=0; i< col.length; i++){
			if(canbuild(row, i, col.length, towerPositions)){
				col[row] = i;
				towerPositions.add(col);
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
