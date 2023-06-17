package algo.patternsearch;

import java.util.Arrays;


/**
 * Boyer Moore is a combination of the following two approaches. 
1) Bad Character Heuristic 
2) Good Suffix Heuristic

The Boyer Moore algorithm does pre-processing like KMP, so that the pattern can be shifted by more than one. 
It processes the pattern and creates different arrays for each of the two heuristics. 
At every step, it slides the pattern by the max of the slides suggested by each of the two heuristics.

	This class has Bad Character Heuristic  approach
 *  
 *  Unlike KMP, Boyer Moore algorithm starts matching from the last character of the pattern.
 *  
 * @author premkumarnarayanappavenkatesh
 *
 */
public class BoyerMoore {
	
	private static int[] badCharHeuristicsInit(String pattern){
		int[] offsetArr = new int[256];
		
		Arrays.fill(offsetArr, -1);

		for(int i=0; i< pattern.length(); i++){
			offsetArr[pattern.charAt(i)]=i;
		}
		System.out.println(Arrays.toString(offsetArr));
		System.out.println(offsetArr[pattern.charAt(0)]);
		System.out.println(offsetArr[pattern.charAt(1)]);
		System.out.println(offsetArr[pattern.charAt(pattern.length()-1)]);
		return offsetArr;
	}
	
	public static void main(String[] args) {
				//	 "0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6"	
	//	String txt = "G C A A T G C C T A T G T G A C C";
	//	String pat =     "T A T G T G";
		
		//String txt = "GCAATGCCTATGTGACC";
		//String pat = "TATGTG";
		
		//String txt = "GCAATGCCTATGTG";
		//String pat = "TATGTG";
		
	
		String txt = "ABAAABCD";
		String pat = "ABC";
		
		
			//		 "0 1 2 3 4 5
		int[] offsetArr = badCharHeuristicsInit(pat);
		
		int i = pat.length()-1;//5
		int j = pat.length()-1;//5
		System.out.println(i);
		System.out.println(txt.length());
		System.out.println("..");
		
		while(i < txt.length()){
			if(txt.charAt(i) == pat.charAt(j)){
				i--;
				j--;
			}
			if(j==0){
				System.out.println("Pattern found at "+i);
				j = (pat.length()-1);//reset j
				i = i+ (pat.length()) +1;//reset j
			}
			
			if(i<txt.length() &&  txt.charAt(i) != pat.charAt(j)){ //i<txt.length() important to not cause OutofBoundsEx
				if(pat.contains(String.valueOf(txt.charAt(i)))){
					int tempJ=offsetArr[txt.charAt(i)]; 
					if(tempJ > j){
						System.out.println("matching char in pattern, should already be matched");
					}
					j = (pat.length()-1);//reset j
					i = (i - tempJ)+(pat.length()-1); //+pat.length() to start comparing from end
					System.out.println("Moving window to "+i); 
					// i = 12
					// j = 4
				} else{
					i=i+pat.length(); 
					j = (pat.length()-1);//reset j
					System.out.println("Moving window for i and j to"+i+" ,j "+j);
				}
			}
		}
		
	}
}
