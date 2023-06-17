package euler;

/**
 * Interesting: 
 * 1) Every prime number can be represented in form of 6n+1 or 6n-1 except the prime number 2 and 3, 
 * where n is a natural number
 * 2) Divide the number you are testing, one by one, by each number between 2 and the square root of the tested number. 
 * One of the traits of numbers is that, if they have a factor pair, 
 * one of the factors must be equal to or less than the square root. So, if you test all the numbers up to the square root, 
 * you can rest assured that the number is prime
 * 3) Find the square root of the number you wish to test using a computer or calculator. 
 * If the square root is a whole number, then you know the number is not prime and can give up on it. 
 * 
 * @author premkumarnarayanappavenkatesh
 *
 */
public class PrimeOrNot {
	private static boolean isInt(double number){
		return number%1 == 0;
	}
	
	public static boolean isPrime(int number){
		if(number == 2 || number == 3){
			return true;
		}
		
		if(number % 2 == 0 || number % 3 == 0){
			return false;
		}
		
		if(isInt(Math.sqrt(number))){
			System.out.println("square root is a whole number, so not prime");
			return false;
		}	
		
		for (int i = 4; i <= Math.sqrt(number); i++) {
			if(number % i == 0){
				return false;
			}
		}
		
		return true;
			
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(36));
		System.out.println(isPrime(25));
		System.out.println(isPrime(37));
		System.out.println(isPrime(20));
	}
}
