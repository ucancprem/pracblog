package prac.recursion.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * `StringPermutations` code will work fine. Because we use a Set duplicates are removed.
 * However, we do generate duplicates. 
 * For example, if the given string is aaa, then we generate six identical permutations, even if there is only one. 
 * This is far from being efficient.
 * 
 *  One approach starts by counting the characters of a string and storing them in a map. 
 *  For example, for the given string abcabcaa, the key-value map can be a=4, b=2, and c=2
 *  
 *  Next, we choose one of these characters as the first character and find all the permutations of the remaining characters. We can express this as follows:
 * 
 * P(a=4,b=2,c=2) = [a + P(a=3,b=2,c=2)] + [b + P(a=4,b=1,c=1)] + [c + P(a=4,b=2,c=1)]
 * 
 * P(a=3,b=2,c=2) = [a + P(a=2,b=2,c=2)] + [b + P(a=3,b=1,c=1)] + [c + P(a=3,b=2,c=1)]
 * 
 * P(a=4,b=1,c=1) = [a + P(a=3,b=1,c=1)] + [b + P(a=4,b=0,c=1)] + [c + P(a=4,b=1,c=0)]
 * 
 * P(a=4,b=2,c=1) = [a + P(a=3,b=2,c=1)] + [b + P(a=4,b=1,c=1)] + [c + P(a=4,b=2,c=0)]
 * 
 * P(a=2,b=2,c=2) = [a + P(a=1,b=2,c=2)] + [b + P(a=2,b=1,c=2)] + [c + P(a=2,b=2,c=1)]
 * 
 * P(a=3,b=1,c=1) = ...
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
class StringPermutationsNoDuplication {
	
	private static Set<String> permutations = new HashSet<>();
	private static int length;
	
	private static void permute(Map<Character, Integer> charCount, String prefix){
		System.out.println(prefix);
		if(prefix.length() == length){
			System.out.println("---------------------------");
			System.out.println("---------------------------");
			permutations.add(prefix);
		}
		for(Character c: charCount.keySet()){
			int count = charCount.get(c);
			if(count > 0){
				charCount.put(c, count-1);
				permute(charCount, prefix+c);
				charCount.put(c, count);//reset count to initial counter	
			}
			
		}
	}
	
	private static Map<Character, Integer> getCharacterCount(String str){
		
		Map<Character, Integer> charCount = new HashMap<>();
		//BiFunction<Character, Integer, Integer> calculateCount = (currChat, currentCount) -> currentCount == null ? 1 : currentCount++; - INCORRECT.
		BiFunction<Character, Integer, Integer> calculateCount = (currChat, currentCount) -> currentCount == null ? 1 : ++currentCount;
		
		for(char c : str.toCharArray()){
			charCount.compute(c, calculateCount);
		}
		System.out.println(String.format("Char count of str (%s) is (%s)", str, charCount));
		return charCount;
	}
	
	
	public static void main(String[] args) {
		String str = "abcd";
		length = str.length();
		
		Map<Character, Integer> charCount = getCharacterCount(str);
		permute(charCount, "");
		System.out.println(String.format("Total number of permutations are (%s)", permutations.size()));
		System.out.println(permutations);
		
		String str2 = "aacd";
		length = str2.length();
		
		permutations = new HashSet<>();
		charCount = getCharacterCount(str2);
		permute(charCount, "");
		System.out.println(String.format("Total number of permutations are (%s)", permutations.size()));
		System.out.println(permutations);
	}

}
