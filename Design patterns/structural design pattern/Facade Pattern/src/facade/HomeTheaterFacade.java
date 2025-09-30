package facade;

public class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private Lights lights;

    public HomeTheaterFacade(TV tv, SoundSystem sound, Lights lights) {
        this.tv = tv;
        this.sound = sound;
        this.lights = lights;
    }

    public void watchMovie() {
        System.out.println("Preparing to watch movie...");
        lights.dim();
        tv.on();
        sound.on();
    }

    public void endMovie() {
        System.out.println("Shutting down movie...");
        tv.off();
        sound.off();
        lights.bright();
    }
}
