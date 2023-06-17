package patterns.bridge.withoutBridge;

public class AssembleBus extends Bus {

	@Override
	public void make() {
		System.out.println("Assemble bus");
	}

}
