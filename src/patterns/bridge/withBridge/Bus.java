package patterns.bridge.withBridge;

import java.util.List;

public class Bus extends Vehicle {

	public Bus(List<Manufacturing> manufacturing) {
		super(manufacturing);
		
	}

	@Override
	public void make() {
		System.out.println("Bus making");
		for(Manufacturing currentStep: manufacturing)
			currentStep.makeItHappen();
	}

}
