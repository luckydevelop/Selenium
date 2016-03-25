package utility;


import org.apache.log4j.Logger;

public class Log{

    private static final Logger log = Logger.getLogger(new Object(){}.getClass().getName());

    public static void startScenario(String scenarioName) {
        info("S");
        info("S");
        info("SSSSSSSS     SCENARIO START - " + scenarioName + "      SSSSSSSS");
        info("S");
        info("S");
    }

    public static void finishScenario(String scenarioName, String scenarioStatus) {
        info("F");
        info("F");
        info("SSSSSSSS    SCENARIO - " + scenarioName + " FINISHED / STATUS - " + scenarioStatus.toUpperCase() + " SSSSSSSS");
        info("F");
        info("F");
    }

    public static void startStep(String stepName) {
        info("*******************************");
        info("MMMMMMMM   METHOD STEP NAME - " + stepName + "   MMMMMMMM");
        info("*******************************");
    }

    private static void info(String message)
    {
        log.info(message);
    }

}
