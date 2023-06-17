package patterns.bridge.withoutBridge;

public class ProduceBus extends Bus {

	@Override
	public void make() {
		System.out.println("Producing bus");
	}

}
