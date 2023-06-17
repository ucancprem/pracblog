package patterns.bridge.withoutBridge;

public class AssemblingBike extends Bike {

	@Override
	public void make() {
		System.out.println("Assembling bike");
	}
	
}
