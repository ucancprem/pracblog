package patterns.bridge.withBridge;

public class Painting implements Manufacturing {

	@Override
	public void makeItHappen() {
		System.out.println("Paint job");
	}

}
