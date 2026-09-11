import builders.PresetCakeBuilder;
import builders.CustomCakeBuilder;
import product.Cake;
import director.CakeDirector;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("       WELCOME TO THE CAKE BAKERY        ");
        System.out.println("=========================================");
        System.out.println("1. Build a Custom Cake (From Scratch)");
        System.out.println("2. Choose a Preset Cake (Menu)");
        System.out.print("Select an option (1 or 2): ");

        int mainChoice = readInt(scanner);
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
