import proxy.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Internet Access Control ===");

        while(!exit) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Access Website");
                System.out.println("2. Exit");
                System.out.print("Enter choice: ");
                String choice = scanner.nextLine().trim();

                switch(choice) {
                    case "1":
                        System.out.print("Enter URL: ");
                        String url = scanner.nextLine().trim();
                        if(url.isEmpty()) {
                            System.out.println("URL cannot be empty!");
                            break;
                        }
                        internet.connectTo(url);
                        logger.info("Attempted to access: " + url);
                        break;
                    case "2":
                        exit = true;
                        System.out.println("Exiting Internet Access Control...");
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
