package prac;

/**
 * 
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class LongestPalindromicSubString {
	
	private static int maxLength = 1;
	private static int startIndex = 0;
	private static int endIndex = 0;
	
	
	private static void initialze(){
		maxLength = 1;
		startIndex = 0;
		endIndex = 0;
	}
	private static void printLongestSubString(String str){
		if(startIndex < 0){
			startIndex = 0;
		}
		if(endIndex >= str.length()){
			endIndex = str.length()-1;
		}	
		
		System.out.println(String.format("Longest palindrome(%s) is of length(%d),  ", str.substring(startIndex, endIndex) , maxLength ));
	}
	
	private static void findPalindrome(int low, int high, String str) {
		int len = str.length(); 
		char[] strArray = str.toCharArray();
		while( low >=0 && high <= len-1 && strArray[low] == strArray[high]){
			low--;
			high++;
		}
		
		int currLength = ((high-1)-(low+1))+1;
		if(currLength > maxLength){		
			maxLength = currLength;
			startIndex = low;
			endIndex = high;
			
			System.out.println(maxLength+" -> from "+low+" , "+high);
		}
	}
	
	private static void findPalindromeOfEvenLength(int i, String str) {
		/*
		 * EVEN Palindrome
		 *  	A   B
		 *     low  high
		 */
		int low = i-1; //(0,1), (1,2), (2,3), (3,4)..
		int high = i;
		findPalindrome(low, high, str);
	}
	
	private static void findPalindromeOfOddLength(int i, String str) {
		/*
		 * ODD Palindrome
		 *  	A  B  A
		 *     low    high
		 */
		
		int low = i-1; //(0,2), (1,3), (2,4), (3,5)..
		int high = i+1;
		
		findPalindrome(low, high, str);
	}
	
	private static void longestPalindrome(String str) {
		initialze();
		int len = str.length();
	
		for(int i = 0; i < len ; i++){
			findPalindromeOfEvenLength(i, str);
			findPalindromeOfOddLength(i, str);			
		}
		printLongestSubString(str);
	}
	
	public static void main(String[] args) {

		String str = "abababa"; 
		String str1 = "abbaabba"; 
		
		longestPalindrome(str);   
		longestPalindrome(str1); 
		
		String str2 = "cabababa";
		String str3 = "abbaabbac";
		
		longestPalindrome(str2);
		longestPalindrome(str3);
		
	}

}
