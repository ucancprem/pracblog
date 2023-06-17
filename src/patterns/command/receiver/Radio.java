package patterns.command.receiver;

public class Radio implements ElectronicDevice{

	private int volume = 0;
	

	@Override
	public String name() {
		return "Radio";
	}
	
	@Override
	public void on() {
		System.out.println("Radio is On");
		
	}

	@Override
	public void off() {
		System.out.println("Radio is Off");		
	}

	@Override
	public void volumeUp() {
		System.out.println(String.format("Radio volume turned up to %s", ++volume));
		
	}

	@Override
	public void volumeDown() {
		System.out.println(String.format("Radio volume turned down to %s", --volume));
		
	}

}
