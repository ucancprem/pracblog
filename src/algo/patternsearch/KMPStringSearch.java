package algo.patternsearch;

import java.util.Arrays;

/* KMP (Knuth Morris Pratt) Pattern Searching
 * In computer science, the Knuth–Morris–Pratt string-searching algorithm (or KMP algorithm) searches for occurrences of a "word" W within a main "text string" S
 *  by employing the observation that when a mismatch occurs, the word itself embodies sufficient information to determine where the next match could begin, 
 *  thus bypassing re-examination of previously matched characters.
 */

//Since the two portions of the algorithm have, respectively, complexities of O(k) and O(n), the complexity of the overall algorithm is O(n + k).
//Time complexity of KMP algorithm is O(n) in the worst case.

public class KMPStringSearch {

	private static int computeLPSLengh(String subPattern) {

		//System.out.println(subPattern);
		int len = subPattern.length()-1;
		for (int i = len; i >= 0; i--) {
			
			String prefix = subPattern.substring(0, i);
			String suffix = subPattern.substring(subPattern.length() - i);
//System.out.println("Comparing "+prefix+" ,"+suffix);
			if (prefix.equals(suffix)) {
				return prefix.length();
			}
		}
		return 0;
	}

	private static int[] computeLPS(String pat) {
		int[] lpsArr = new int[pat.length()];
		lpsArr[0] = 0;
		for (int i = 1; i < pat.length(); i++) {
			lpsArr[i] = computeLPSLengh(pat.substring(0, i+1));
		}

		return lpsArr;
	}

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		//String pat = "AABAACAABAA";

		int[] lps = computeLPS(pat);
		System.out.println(Arrays.toString(lps));
		int i = 0;
		int j = 0;
		while (i < txt.length()) {
			System.out.println("Checking "+txt.substring(i)+" versus "+pat+", with j value of "+j);

			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				if (j == pat.length()) {
					System.out.println("Found match at index " + (i - j));
					j = lps[j-1];
				}
			} 
			
			if (i < txt.length() && txt.charAt(i) != pat.charAt(j)) {////i<txt.length() important to not cause OutofBoundsEx
				if(j>0){
					j = lps[j-1];
				} else {
					i++;
					//j=0; j is already 0
				}	
			}
		
		}

	}

}
