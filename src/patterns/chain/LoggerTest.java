package patterns.chain;

import patterns.chain.Logger.LogLevel;

public class LoggerTest {

	private static Logger getChainOfLoggers(){
		Logger infoLogger = new InfoLogger();
		Logger debugLogger = new DebugLogger();
		Logger errorLogger = new ErrorLogger();
		infoLogger.nextLogger(debugLogger);
		debugLogger.nextLogger(errorLogger);
		return infoLogger;
		
	}
	public static void main(String[] args) {
		Logger logger = getChainOfLoggers();
		logger.logMessage(LogLevel.ERROR, "Error message");
		System.out.println("---------------------------");
		logger.logMessage(LogLevel.DEBUG, "DEBUG message");
		System.out.println("---------------------------");
		logger.logMessage(LogLevel.INFO, "INFO message");
	}
}
