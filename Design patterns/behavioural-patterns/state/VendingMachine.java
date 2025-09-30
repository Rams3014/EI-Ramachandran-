package state;

import java.util.logging.Logger;

public class VendingMachine {
    private static final Logger logger = Logger.getLogger(VendingMachine.class.getName());
    private State state;

    public VendingMachine() {
        this.state = new ReadyState();
    }

    public void setState(State state) {
        if (state == null) {
            logger.warning("Null state ignored.");
            return;
        }
        this.state = state;
    }

    public void request() {
        if (state == null) {
            logger.severe("State is null!");
            return;
        }
        state.handleRequest(this);
    }
}
