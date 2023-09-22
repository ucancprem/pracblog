package prac;

public class DiagonalMatrix2D {
	
	private static void checkElemOnSameDiagonal(int[][] matrix, int ele1, int ele2){
		int row = matrix.length;
		int col = matrix[0].length;
		
		int posRow1, posRow2, posCol1, posCol2;
		posRow1 = posRow2 = posCol1 = posCol2 = -999;
		
		for(int i=0; i< row;i++){
			for(int j=0; j<col; j++){
				if(matrix[i][j] == ele1){
					posRow1=i;
					posCol1=j;
				}
				if(matrix[i][j] == ele2){
					posRow2=i;
					posCol2=j;
				}
			}
		}
		
		if(posRow1 == -999 || posRow2 == -999){
			System.out.println("Element not found");
			return;
		}
		
		int firstPosDiff = Math.abs(posRow1 - posCol1);
		int secondPosDiff = Math.abs(posRow2 - posCol2);
		int firstPosSum = (posRow1+posCol1);
		int secondPosSum = (posRow2+posCol2);
		
		if(firstPosDiff == secondPosDiff || firstPosSum == secondPosSum){
			System.out.println(String.format("Elements (%s, %s) are on the same diagonal", ele1, ele2));
		}
		else{
			System.out.println(String.format("Elements (%s, %s) are NOT on the same diagonal", ele1, ele2));
		}
		
		
		int columnsDistance = Math.abs(posCol1 - posCol2);
        int rowsDistance = Math.abs(posRow2 - posRow1);
        // cannot build on the same diagonal
        if (columnsDistance == rowsDistance) {
        	System.out.println(String.format("Elements (%s, %s) are on the same diagonal", ele1, ele2));
        } else {
			System.out.println(String.format("Elements (%s, %s) are NOT on the same diagonal", ele1, ele2));
		}
		
	}

	public static void main(String[] args) {
		int[][] matrix = {  { 2, 94, 99, 26, 8 },
			                { 5, 69, 52, 63, 17 },
			                { 90, 36, 88, 55, 33 },
			                { 93, 42, 73, 39, 28 },
			                { 81, 31, 83, 53, 10 },
			                { 12, 9, 85, 80, 7 } };
		
//		int x = 42;
//	    int y = 80;
		int x = 33;
	    int y = 83;
	    int x1 = 2;
	    int y1 = 8;
	 
	    // Found on diagonal
	    checkElemOnSameDiagonal(matrix, x, y);
	    // NOT Found on diagonal
	    checkElemOnSameDiagonal(matrix, x1, y1);
	    //Element Not found
	    checkElemOnSameDiagonal(matrix, x-2, y);
	}
}
