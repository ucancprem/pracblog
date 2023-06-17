package patterns.chain;

public class DebugLogger extends Logger{

	
	@Override
	public void log(String message) {
		System.out.println(String.format(" DebugLogger: %s", message));
	}

	@Override
	public LogLevel getLogLevel() {
		return LogLevel.DEBUG;
	}

}
