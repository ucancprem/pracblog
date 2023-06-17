package prac.bit;

public class CountSetBits {
	
	
	private static int countSetBits(int input) {
		int count=0;
		String bits = Integer.toBinaryString(input);
		System.out.println(String.format("bit representation of input %d is %s", input, bits));
		for(int i = 0; i < bits.length(); i++ ){
			if(bits.charAt(i)=='1'){
				count++;
			}
		}
		
		return count;
	}
	
	private static int countSetBitsByShiftingBits(int input){
		int count=0;
		while(input > 0){
			count += input&1; //`&` with essentially the last bit.
			input = input>>1;
		}
		
		return count;
	}
	
	private static int countSetBitsRecursion(int input){
		if(input == 0){
			return 0;
		}
		return (input&1)+countSetBitsRecursion(input>>1);
	}
	
	private static int countSetBitsTailRecursion(int input, int count){
		if(input == 0){
			return count;
		}
		return countSetBitsTailRecursion(input>>1, count+= input&1);
	}
	
	public static void main(String[] args) {
		int i = 15;
		System.out.println(countSetBits(i));
		System.out.println(countSetBitsByShiftingBits(i));
		System.out.println(countSetBitsRecursion(i));
		System.out.println(countSetBitsTailRecursion(i,0));
	}

}
