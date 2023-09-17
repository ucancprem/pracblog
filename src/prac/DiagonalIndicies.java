package prac;

public class DiagonalIndicies {
	
	private static void printIndicies(int[][] arr, int startRow, int startCol){
		System.out.println(String.format("(%d,%d)", startRow,startCol));
		int i = startRow;
		int j = startCol;
		while(i > 0 && j > 0){
			i--;
			j--;
			System.out.println(String.format("(%d,%d)", i,j));
		}
		i = startRow;
		j = startCol;
		while(i< arr.length && j < arr[0].length){
			i++;
			j++;
			System.out.println(String.format("(%d,%d)", i,j));
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int startRow =0;
		int startCol =0;
		//printIndicies(arr, startRow, startCol);
		startRow =2;
		startCol =2;
		//printIndicies(arr, startRow, startCol);
		startRow =0;
		startCol =1;
		printIndicies(arr, startRow, startCol);
	}

}
