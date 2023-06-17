package patterns.command.receiver;

public class TV implements ElectronicDevice{

	private int volume = 0;
	

	@Override
	public String name() {
		return "TV";
	}
	
	@Override
	public void on() {
		System.out.println("TV is On");
		
	}

	@Override
	public void off() {
		System.out.println("TV is Off");		
	}

	@Override
	public void volumeUp() {
		System.out.println(String.format("TV volume turned up to %s", ++volume));
		
	}

	@Override
	public void volumeDown() {
		System.out.println(String.format("TV volume turned down to %s", --volume));
		
	}
	

}
