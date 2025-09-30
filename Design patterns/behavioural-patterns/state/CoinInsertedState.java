package state;

import java.util.logging.Logger;

public class CoinInsertedState implements State {
    private static final Logger logger = Logger.getLogger(CoinInsertedState.class.getName());

    @Override
    public void handleRequest(VendingMachine machine) {
        logger.info("Coin inserted. Please select a product.");
    }
}
