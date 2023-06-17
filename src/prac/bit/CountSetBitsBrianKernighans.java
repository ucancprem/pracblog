package prac.bit;

public class CountSetBitsBrianKernighans {

//	   Brian Kernighan’s Algorithm: 
//	   Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(right most `1`) including the rightmost set bit. 
//	   for example : 
//	   10 in binary is 00001010 
//	   9 in binary is 00001001 
//	   8 in binary is 00001000 
//	   7 in binary is 00000111 
//	   So if we subtract a number by 1 and do it bitwise & with itself (n & (n-1)), we unset the rightmost set bit. 
//	   If we do n & (n-1) in a loop and count the number of times the loop executes, we get the set bit count. 
//	   The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer. 
//	
//		Example for Brian Kernighan’s Algorithm:  
//
//	   n =  9 (1001)
//	   count = 0
//
//	   Since 9 > 0, subtract by 1 and do bitwise & with (9-1)
//	   n = 9&8  (1001 & 1000)
//	   n = 8
//	   count  = 1
//
//	   Since 8 > 0, subtract by 1 and do bitwise & with (8-1)
//	   n = 8&7  (1000 & 0111)
//	   n = 0
//	   count = 2
//
//	   Since n = 0, return count which is 2 now.
	private static int countSetBitsBrianKeernighansMethod(int input) {
		int count =0;
		
		while(input>0){
			input = (input & (input-1));
			count++;
		}
		
		return count;
	}
	
	
	public static void main(String[] args) {
		int i = 15;
		int j = 44;
		System.out.println(countSetBitsBrianKeernighansMethod(i));
		System.out.println(countSetBitsBrianKeernighansMethod(j));
	
	}

}
