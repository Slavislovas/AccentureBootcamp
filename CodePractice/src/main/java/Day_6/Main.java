package Day_6;


import org.apache.log4j.*;

import java.io.Console;

public class Main {
    static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d [%p|%c|$C{1}] %m%n"));
        consoleAppender.activateOptions();
        logger.getRootLogger().addAppender(consoleAppender);

        logger.info("Log information");
        logger.error("Order failed. (Order ID " + 152 +")", new Exception());


    }
}
