import builders.PresetCakeBuilder;
import builders.CustomCakeBuilder;
import product.Cake;
import director.CakeDirector;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CakeDirector director = new CakeDirector();

        System.out.println("=========================================");
        System.out.println("       WELCOME TO THE CAKE BAKERY        ");
        System.out.println("=========================================");
        System.out.println("1. Build a Custom Cake (From Scratch)");
        System.out.println("2. Choose a Preset Cake (Menu)");
        System.out.print("Select an option (1 or 2): ");

        int mainChoice = readInt(scanner);
        if (mainChoice == 1) {
            handleCustomCake(scanner);
        } else if (mainChoice == 2) {
            handlePresetCake(scanner, director);
        } else {
            System.out.println("Invalid selection. Exiting ordering system.");
        }
        scanner.close();
    }

    private static void handleCustomCake(Scanner scanner){
        System.out.println("\n--- CUSTOM CAKE BUILDER ---");
        CustomCakeBuilder builder = new CustomCakeBuilder();
        System.out.println("Enter flavor:");
        builder.setFlavor(scanner.nextLine().trim());
        System.out.println("Enter number of layers (1-10):");
        builder.setLayers(readInt(scanner));
        System.out.println("Enter frosting type:");
        builder.setFrosting(scanner.nextLine().trim());
        System.out.println("Enter toppings or press Enter to skip (if more than one, separate with ','):");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) { //this code is used to separate toppings
            String[] items = input.split(",");
            for (String item : items) {
                builder.addTopping(item.trim());
            } //without: [chocolate strawberry], with: [chocolate, strawberry]
        }
        System.out.println("Enter custom text on a cake or press Enter to skip:");
        builder.setMessage(scanner.nextLine().trim());

        try {
            Cake customCake = builder.build();
            System.out.println("\n--- Your order summary ---");
            System.out.println(customCake);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("\nOrder failed validation: " + e.getMessage());
        }
    }

    private static void handlePresetCake(Scanner scanner, CakeDirector director){
        System.out.println("\n--- PRESET CAKE MENU ---");
        System.out.println("1. Standard House Cake (Preset Defaults)");
        System.out.println("2. Birthday Cake");
        System.out.println("3. Wedding Cake");
        System.out.print("Select a preset option (1, 2, or 3): ");
        int presetChoice = readInt(scanner);
        Cake resultCake = null;
        switch(presetChoice){
            case 1:
                resultCake = new PresetCakeBuilder().build();
                break;
            case 2:
                System.out.print("Enter recipient name for the Birthday Cake: ");
                String name = scanner.nextLine().trim();
                resultCake = director.makeBirthdayCake(new PresetCakeBuilder(), name);
                break;
            case 3:
                resultCake = director.makeWeddingCake(new PresetCakeBuilder());
                break;
            default:
                System.out.println("invalid preset choice.");
                return;
        }
        System.out.println("\n--- Your order summary ---");
        System.out.println(resultCake);
    }

    private static int readInt(Scanner scanner) {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            return -1; // Invalid integer input fallback
        }
    }
}
