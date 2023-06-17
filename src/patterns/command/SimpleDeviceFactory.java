package patterns.command;

import java.util.Arrays;
import java.util.List;

import patterns.command.receiver.ElectronicDevice;
import patterns.command.receiver.Radio;
import patterns.command.receiver.TV;

public class SimpleDeviceFactory {
	
	public static List<ElectronicDevice> getAllDevices(){
		return Arrays.asList(new TV(), new Radio());
	}

}
