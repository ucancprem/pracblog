package patterns.bridge.withBridge;

import java.util.Arrays;
import java.util.List;

public class BridgeMain {

	public static void main(String[] args) {
		List<Manufacturing> bikeManufacturing = Arrays.asList(new Production(),new Assembly());
		List<Manufacturing> busManufacturing = Arrays.asList(new Production(),new Assembly(), new Painting());
		
		Vehicle bike = new Bike(bikeManufacturing);
		Vehicle bus = new Bus(busManufacturing);
		bike.make();
		System.out.println("------------------------");
		bus.make();
	}
}
