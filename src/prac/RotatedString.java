package prac;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * A String is said to be rotation of another String if :
-Both the Strings have equal lengths and consist of same characters.
-We can obtain the second string by rotating the first String around a certain character.

 * @author premkumarnarayanappavenkatesh
 *
 */
public class RotatedString {

	private static void isStringRotationOfOther(String originalStr, String tamperedString){
		//if we concatenate the second string with itself and search for the first string in the resulting string,
		//we will find a match if and only if the two original strings are rotations of each other
		
		String tempStr = new StringBuilder().append(tamperedString)
											.append(tamperedString).toString();
		if(originalStr.length()==tamperedString.length() && tempStr.contains(originalStr)){
			System.out.println(String.format("String %s is a rotation of %s ", tamperedString, originalStr ));
		} else {
			System.out.println(String.format("String %s is NOT a rotation of %s ", tamperedString, originalStr ));
		}
		
	}
	
	private static void isStringRotationOfOtherUsingQueues(String originalStr, String tamperedString){
		
		if(originalStr.length()!=tamperedString.length()){
			System.out.println(String.format("String %s is NOT a rotation of %s ", tamperedString, originalStr ));
			return;
		} else if (originalStr.equals(tamperedString)){
			System.out.println("Idential strings with no rotation");
		}
		
		Queue<Character> origQueue = new ArrayDeque<>();
		Queue<Character> tamperedStrQueue = new ArrayDeque<>();
		
		
		for (int i = 0; i < originalStr.length(); i++) {
			origQueue.add(originalStr.charAt(i));
			tamperedStrQueue.add(tamperedString.charAt(i));
		}
		
		int i = 0;
		while(i < originalStr.length() ){
			Character c = tamperedStrQueue.poll();
			tamperedStrQueue.add(c);
		
			i++;
			if(origQueue.toString().equals(tamperedStrQueue.toString())){
				System.out.println(String.format("Q - String %s is a rotation of %s ", tamperedString, originalStr ));
				break;
			}
			//System.out.println(origQueue.toString());
			System.out.println(tamperedStrQueue.toString());

		}
		System.out.println(String.format("Q - String %s is NOT a rotation of %s ", tamperedString, originalStr ));
		
		
	} 
	
	public static void main(String[] args) {
		String str1 = "ABCD";
		String str2 = "CDAB";
		String str3 = "ACDA";
		
		isStringRotationOfOther(str1, str2);
		System.out.println("----------------------");
		isStringRotationOfOther(str1, str3);
		
		System.out.println("----------USING QUEUE------------");

		isStringRotationOfOtherUsingQueues(str1, str2);
		System.out.println("----------------------");
		isStringRotationOfOtherUsingQueues(str1, str3);
	}
	
}
