package patterns.chain;

public class InfoLogger extends Logger{

	@Override
	public void log(String message) {
		System.out.println(String.format(" InfoLogger: %s", message));
	}

	@Override
	public LogLevel getLogLevel() {
		return  LogLevel.INFO;
	}

}
