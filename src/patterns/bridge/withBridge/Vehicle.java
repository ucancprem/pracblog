package patterns.bridge.withBridge;

import java.util.List;

public abstract class Vehicle {

	List<Manufacturing> manufacturing;
	
	public Vehicle(List<Manufacturing> manufacturing) {
		this.manufacturing = manufacturing;
	}
	
	public abstract void make();
	//public abstract void charge(); future enhancement -  will only change extending classes
}
