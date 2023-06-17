package prac.bit;

public class BasicBitwiseOperator {
	
	private static final int var1 = 5;
	private static final int var2 = 6;
	
	private static void bitwiseXor(){
		//101
		//110
		//-------
		//011
		if((var1 ^ var2)== 3){
			System.out.println(String.format("Xor of 5 and 6  should be `3`, confirmation %d", var1^var2));
		}else{
			System.out.println("Failed basic xor");
		
		}
		
	}
	
	private static void bitwiseComplement(){
		//101
		//-------
		//010
		if((~var1)== -(var1+1)){
			System.out.println(String.format("Bitwise Complement 5 should be `2`, confirmation %d", (~var1)));
		}else{
			System.out.println("Failed basic bitwise complement ");
		
		}
		
	}

	public static void main(String[] args) {
		
		
		bitwiseXor();
		bitwiseComplement();
	
	}
}
