package prac.recursion.dp;

import java.util.HashSet;
import java.util.Set;

class StringPermutations {
	
	private static Set<String> permutations = new HashSet<String>();
	
	private static Set<String> permute(String str, String prefix){
		Set<String> permutationsInCurrentIteration = new HashSet<String>();
		
		int len = str.length();
		if(len == 0){
			permutationsInCurrentIteration.add(prefix);
		} else {
			for(int i=0; i < len; i++){
				permutations.addAll(permute(str.substring(0, i)+str.substring(i+1, len), prefix +str.charAt(i)));
			}
		}
		
		return permutationsInCurrentIteration;
	}
	
	
	public static void main(String[] args) {
		String str = "abcd";
		permute(str, "");
		System.out.println(String.format("Total number of permutations are (%s)", permutations.size()));
		System.out.println(permutations);
		
		permutations = new HashSet<String>();
		String strWithDups = "abca";
		permute(strWithDups, "");
		System.out.println(String.format("Total number of permutations are (%s)", permutations.size()));
		System.out.println(permutations);
	}

}
