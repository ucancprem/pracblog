package prac.recursion.dp;

import java.util.HashSet;
import java.util.Set;

class StringPermutations {
	
	private static Set<String> permutations = new HashSet<String>();
	
	private static void permute(String str, String prefix){
		if(str.length() == 0){
			permutations.add(prefix);
		}
		for(int i=0; i<str.length(); i++){
			permute(str.substring(0,i) + str.substring(i+1), prefix+str.charAt(i));
		}
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
