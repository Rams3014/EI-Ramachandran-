package command;

import java.util.logging.Logger;

public class Light {
    private static final Logger logger = Logger.getLogger(Light.class.getName());
    private boolean isOn = false;

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            logger.info("Light is ON");
        } else {
            logger.warning("Light was already ON");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            logger.info("Light is OFF");
        } else {
            logger.warning("Light was already OFF");
        }
    }
}
