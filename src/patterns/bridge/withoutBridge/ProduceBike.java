package patterns.bridge.withoutBridge;

public class ProduceBike extends Bike {

	@Override
	public void make() {
		System.out.println("Producing bike");
	}

}
