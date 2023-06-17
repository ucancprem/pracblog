package patterns.chain;

public abstract class Logger {

	public enum LogLevel {
		INFO(0), DEBUG(1), ERROR(2);
		
		int level;
		private LogLevel(int level) {
			this.level = level;
		}
		
	};
	
	private Logger nextLogger;
	//public LogLevel loglevel;
	
	public abstract LogLevel getLogLevel();
	
	public void nextLogger(Logger nextLogger){
		this.nextLogger = nextLogger;
	}
	
	public abstract void log(String message);
	
	public void logMessage(LogLevel currentLevel, String message){
		if(getLogLevel().level >= currentLevel.level){
			log(message);
		}
		if(nextLogger != null){
			nextLogger.logMessage(currentLevel,message);	
		}
	
	}
}
