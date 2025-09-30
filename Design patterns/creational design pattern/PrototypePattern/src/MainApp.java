import prototype.Document;
import java.util.Scanner;
import java.util.logging.Logger;
public class MainApp {
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Document Cloning Simulator ===");

        while (!exit) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Create & Clone Document");
                System.out.println("2. Exit");
                System.out.print("Enter choice: ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        String originalContent;
                        while (true) {
                            System.out.print("Enter original document content: ");
                            originalContent = scanner.nextLine().trim();
                            if (!originalContent.isEmpty()) break;
                            System.out.println("Content cannot be empty!");
                        }

                        Document original = new Document(originalContent);
                        Document clone = original.clone();

                        if (clone != null) {
                            System.out.print("Enter content for cloned document (or press enter to keep same): ");
                            String cloneContent = scanner.nextLine().trim();
                            if (!cloneContent.isEmpty()) {
                                clone.setContent(cloneContent);
                            }

                            System.out.println("\nOriginal Document:");
                            original.showDocument();
                            System.out.println("Cloned Document:");
                            clone.showDocument();
                            logger.info("Document cloned successfully.");
                        }
                        break;

                    case "2":
                        exit = true;
                        System.out.println("Exiting program...");
                        logger.info("User exited application.");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                        logger.warning("Invalid menu selection.");
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Input error: " + e.getMessage());
                logger.severe("IllegalArgumentException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                logger.severe("Exception: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
