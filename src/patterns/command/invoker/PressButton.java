package patterns.command.invoker;

import patterns.command.commands.Command;

public class PressButton {
	
	private final Command command;
	
	public PressButton(Command command){
		this.command = command;
	}

	public void press(){
		command.execute();
	}
	
	public void pressUndo(){
		command.undo();
	}

}
