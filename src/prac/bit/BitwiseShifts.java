package prac.bit;

public class BitwiseShifts {
	
	private static void leftShift(){
		int i=2;
		if(4 ==i<<1){
			i=i<<1;
			System.out.println(i);	
		}
		
		
		int j=-2;
		if(-4 ==j<<1){
			j=j<<1;
			System.out.println(j);	
		} 
		
		
	}
	
	private static void unSignedLeftShift(){
		 System.out.println("Since we are shifting the left most bit, "
		 		+ "which is not relate to the `signed` bit; there is no need for an unsigned left shift");
		
	}
	
	private static void rightShift(){
		int i=4;
		if(2 ==i>>1){
			i=i>>1;
			System.out.println(i);	
		}
		
		
		int j=-4;
		if(-2 ==j>>1){
			j=j>>1;
			System.out.println(j);	
		} 
	}
	
	private static void unsignedRightShift(){
		int i=4;
		if(2 ==i>>>1){
			i=i>>>1;
			System.out.println("unsigned  "+i);	
		}
		
		
		int j=-4;
		if(j>>>1 > 0 ){ //`1` in the sign bit is replaced by `0`
			j=j>>>1;
			System.out.println("unsigned  "+j);	
		} 
	}
	
	
	public static void main(String[] args) {
		leftShift();
		unSignedLeftShift();
		rightShift();
		unsignedRightShift();
	}

}
