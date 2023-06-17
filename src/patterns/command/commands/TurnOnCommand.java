package patterns.command.commands;

import patterns.command.receiver.ElectronicDevice;

public class TurnOnCommand implements Command {

	private final ElectronicDevice device;
	
	public TurnOnCommand(ElectronicDevice device){
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.on();	
	}

	@Override
	public void undo() {
		device.off();
	}

}
