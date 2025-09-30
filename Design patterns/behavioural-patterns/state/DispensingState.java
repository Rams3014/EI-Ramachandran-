package state;

import java.util.logging.Logger;

public class DispensingState implements State {
    private static final Logger logger = Logger.getLogger(DispensingState.class.getName());

    @Override
    public void handleRequest(VendingMachine machine) {
        logger.info("Dispensing product... Thank you!");
        machine.setState(new ReadyState()); 
    }
}
