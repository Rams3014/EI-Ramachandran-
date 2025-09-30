package builder;
import java.util.Scanner;
public class CustomVillaBuilder implements HouseBuilder {
    private House house;
    private Scanner scanner;

    public CustomVillaBuilder(Scanner scanner) {
        this.house = new House();
        this.scanner = scanner;
    }

    @Override
    public void buildFoundation() {
        System.out.print("Enter foundation type (Concrete/Stone/Wood): ");
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Invalid input! Please enter foundation type: ");
            input = scanner.nextLine().trim();
        }
        house.setFoundation(input);
    }

    @Override
    public void buildStructure() {
        System.out.print("Enter structure type (Luxury/Standard/Eco-friendly): ");
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Invalid input! Please enter structure type: ");
            input = scanner.nextLine().trim();
        }
        house.setStructure(input);
    }

    @Override
    public void buildRoof() {
        System.out.print("Enter roof type (Tile/Metal/Shingle): ");
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Invalid input! Please enter roof type: ");
            input = scanner.nextLine().trim();
        }
        house.setRoof(input);
    }

    @Override
    public House getHouse() {
        return house;
    }
}
