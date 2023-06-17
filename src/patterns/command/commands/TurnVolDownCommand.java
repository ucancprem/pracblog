package patterns.command.commands;

import patterns.command.receiver.ElectronicDevice;

public class TurnVolDownCommand implements Command {

	private final ElectronicDevice device;
	
	public TurnVolDownCommand(ElectronicDevice device){
		this.device = device;
	}
	
	@Override
	public void execute() {
		device.volumeDown();
	}

	@Override
	public void undo() {
		device.volumeUp();
	}

}
