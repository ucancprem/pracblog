package patterns.bridge.withBridge;

public class Production implements Manufacturing {

	@Override
	public void makeItHappen() {
		System.out.println("Produce parts");
	}

}
