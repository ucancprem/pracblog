package patterns.chain;

public class ErrorLogger extends Logger {

	@Override
	public void log(String message) {
		System.out.println(String.format(" ErrorLogger: %s", message));
	}


	@Override
	public LogLevel getLogLevel() {
		// TODO Auto-generated method stub
		return LogLevel.ERROR;
	}

}
