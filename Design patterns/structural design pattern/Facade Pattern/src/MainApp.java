import facade.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        TV tv = new TV();
        SoundSystem sound = new SoundSystem();
        Lights lights = new Lights();
        HomeTheaterFacade theater = new HomeTheaterFacade(tv, sound, lights);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Home Theater Control ===");

        while(!exit) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Watch Movie");
                System.out.println("2. End Movie");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                String choice = scanner.nextLine().trim();

                switch(choice) {
                    case "1":
                        theater.watchMovie();
                        logger.info("Movie started");
                        break;
                    case "2":
                        theater.endMovie();
                        logger.info("Movie ended");
                        break;
                    case "3":
                        exit = true;
                        System.out.println("Exiting Home Theater Control...");
                        logger.info("Application exited");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        logger.warning("Invalid menu choice entered");
                        break;
                }
            } catch(Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
                logger.severe("Exception: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
