package state;

import java.util.logging.Logger;

public class ReadyState implements State {
    private static final Logger logger = Logger.getLogger(ReadyState.class.getName());

    @Override
    public void handleRequest(VendingMachine machine) {
        logger.info("Machine is ready. Please insert a coin.");
    }
}
