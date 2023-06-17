package patterns.command.commands;

import patterns.command.receiver.ElectronicDevice;

public class TurnVolUpCommand implements Command {

	private final ElectronicDevice device;
	
	public TurnVolUpCommand(ElectronicDevice device){
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.volumeUp();	
	}

	@Override
	public void undo() {
		device.volumeDown();
	}

}
