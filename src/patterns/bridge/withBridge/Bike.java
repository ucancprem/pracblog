package patterns.bridge.withBridge;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(List<Manufacturing> manufacturing) {
		super(manufacturing);
		
	}

	@Override
	public void make() {
		System.out.println("Simple bike making");
		for(Manufacturing currentStep: manufacturing)
			currentStep.makeItHappen();
	}

}
