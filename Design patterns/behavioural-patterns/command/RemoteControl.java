package command;

import java.util.logging.Logger;

public class RemoteControl {
    private static final Logger logger = Logger.getLogger(RemoteControl.class.getName());
    private Command command;

    public void setCommand(Command command) {
        if (command == null) {
            logger.warning("Command is null, ignoring");
        } else {
            this.command = command;
        }
    }

    public void pressButton() {
        if (command == null) {
            logger.severe("No command set!");
            return;
        }
        try {
            command.execute();
        } catch (Exception e) {
            logger.severe("Error executing command: " + e.getMessage());
        }
    }
}
