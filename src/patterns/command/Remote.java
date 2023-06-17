package patterns.command;

import java.util.Arrays;
import java.util.List;

import patterns.command.commands.TurnOffCommand;
import patterns.command.commands.TurnOnCommand;
import patterns.command.commands.TurnVolDownCommand;
import patterns.command.commands.TurnVolUpCommand;
import patterns.command.invoker.PressButton;
import patterns.command.receiver.ElectronicDevice;

public class Remote {

	private static void testAllbuttons(ElectronicDevice device) {
		
		TurnOnCommand turnOnCommand = new TurnOnCommand(device);
		TurnOffCommand turnOffCommand = new TurnOffCommand(device);
		TurnVolUpCommand turnVolUpCommand = new TurnVolUpCommand(device);
		TurnVolDownCommand turnVolDownCommand = new TurnVolDownCommand(device);
		
		PressButton onButton = new PressButton(turnOnCommand);
		PressButton offButton = new PressButton(turnOffCommand);
		PressButton volUpButton = new PressButton(turnVolUpCommand);
		PressButton volDownButton = new PressButton(turnVolDownCommand);
		
		List<PressButton> pressAllbuttons = Arrays.asList(onButton, volUpButton, volUpButton, volUpButton, volDownButton, offButton); 
		System.out.println("---------------- Testing button press function ----------------");
		for(PressButton button: pressAllbuttons){
			button.press();
		}
		
		System.out.println("---------------- Testing undo function ----------------");
		for(int i = pressAllbuttons.size()-1 ; i >= 0; i-- ){
			pressAllbuttons.get(i).pressUndo();
		}
		
	}
	
	public static void main(String[] args) {
		List<ElectronicDevice> electronicDevices = SimpleDeviceFactory.getAllDevices();
		
		for(ElectronicDevice device :  electronicDevices){
			System.out.println(String.format("---------------- Testing %s ----------------", device.name()));
			testAllbuttons(device);	
		}
		
	}

}
