package command;

import java.util.Scanner;
import java.util.logging.Logger;

public class CommandApp {
    private static final Logger logger = Logger.getLogger(CommandApp.class.getName());

    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command onCommand = new LightOnCommand(livingRoomLight);
        Command offCommand = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        logger.info("Remote Control Ready. Commands: on, off, exit");

        while (!exit) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "on":
                    remote.setCommand(onCommand);
                    remote.pressButton();
                    break;
                case "off":
                    remote.setCommand(offCommand);
                    remote.pressButton();
                    break;
                case "exit":
                    logger.info("Exiting application...");
                    exit = true;
                    break;
                default:
                    logger.warning("Unknown command: " + input);
            }
        }
        scanner.close();
    }
}
