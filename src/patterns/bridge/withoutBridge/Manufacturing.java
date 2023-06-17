package patterns.bridge.withoutBridge;

import java.util.Arrays;
import java.util.List;

public class Manufacturing {
	
	public static void main(String[] args) {
		List<Vehicle> busBuilding = Arrays.asList(new ProduceBus(), new AssembleBus());
		for(Vehicle building: busBuilding){
			building.make();
		}
		
		List<Vehicle> bikeBuilding = Arrays.asList(new ProduceBike(), new AssemblingBike());
		for(Vehicle building: bikeBuilding){
			building.make();
		}
	}
}
