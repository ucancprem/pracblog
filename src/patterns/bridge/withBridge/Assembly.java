package patterns.bridge.withBridge;

public class Assembly implements Manufacturing {

	@Override
	public void makeItHappen() {
		System.out.println("Assembling");
	}

}
