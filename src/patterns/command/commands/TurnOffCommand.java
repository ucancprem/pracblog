package patterns.command.commands;

import patterns.command.receiver.ElectronicDevice;

public class TurnOffCommand implements Command {

	private final ElectronicDevice device;
	
	public TurnOffCommand(ElectronicDevice device){
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.off();	
	}

	@Override
	public void undo() {
		device.on();
	}

}
