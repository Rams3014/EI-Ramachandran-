package command;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        if (light == null) {
            throw new IllegalArgumentException("Light cannot be null");
        }
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
