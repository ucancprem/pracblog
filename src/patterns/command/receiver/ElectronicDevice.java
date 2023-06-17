package patterns.command.receiver;

public interface ElectronicDevice {
	
	public String name();
	
	public void on();
	
	public void off();
	
	public void volumeUp();
	
	public void volumeDown();
}
