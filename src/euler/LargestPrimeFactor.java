package euler;

/**
 * Interesting: Every prime number can be represented in form of 6n+1 or 6n-1 except the prime number 2 and 3, 
 * where n is a natural number
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class LargestPrimeFactor {
	
	private static boolean isInt(double number){
		
		return number % 1 == 0;
	}
	
	private static int largestPrime(int number){
		
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if(isInt((double)number/i)){
				
				int potentialPrime = number/i;
				if(PrimeOrNot.isPrime(potentialPrime)){ // we're testing the biggest divisibale factor first, so should be largest prime?
					return potentialPrime;
				}
				else{
					//System.out.println("calling largestPrime for"+potentialPrime);
					return largestPrime(potentialPrime);
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(largestPrime(40));//2X2X5
		System.out.println(largestPrime(10));
	}
}
