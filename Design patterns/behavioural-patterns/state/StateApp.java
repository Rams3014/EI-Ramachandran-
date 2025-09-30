package state;

import java.util.Scanner;
import java.util.logging.Logger;

public class StateApp {
    private static final Logger logger = Logger.getLogger(StateApp.class.getName());

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        logger.info("Vending Machine ready. Commands: ready, coin, dispense, exit");

        while (!exit) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "ready":
                    machine.setState(new ReadyState());
                    machine.request();
                    break;
                case "coin":
                    machine.setState(new CoinInsertedState());
                    machine.request();
                    break;
                case "dispense":
                    machine.setState(new DispensingState());
                    machine.request();
                    break;
                case "exit":
                    logger.info("Exiting vending machine...");
                    exit = true;
                    break;
                default:
                    logger.warning("Unknown command: " + input);
            }
        }
        scanner.close();
    }
}
