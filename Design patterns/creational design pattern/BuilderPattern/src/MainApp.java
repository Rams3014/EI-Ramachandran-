import builder.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Welcome to Villa Construction Simulator ===");

        while (!exit) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Build a Custom Villa");
                System.out.println("2. Exit");
                System.out.print("Enter choice: ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        HouseBuilder villaBuilder = new CustomVillaBuilder(scanner);
                        ConstructionEngineer engineer = new ConstructionEngineer(villaBuilder);
                        House villa = engineer.constructHouse();
                        villa.showHouse();
                        logger.info("Villa constructed successfully.");
                        break;

                    case "2":
                        exit = true;
                        System.out.println("Exiting application...");
                        logger.info("Application exited by user.");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                        logger.warning("Invalid menu choice entered.");
                        break;
                }

            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                logger.severe("Exception: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
