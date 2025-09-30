package command;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        if (light == null) {
            throw new IllegalArgumentException("Light cannot be null");
        }
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
