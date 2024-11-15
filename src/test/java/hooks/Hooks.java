package hooks;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);


    public void beforeScenario() {
        log.info("Before scenario hook execution started.");
        // Other code
    }

    public void afterScenario() {
        log.info("After scenario hook execution completed.");
        // Other code
    }


}
