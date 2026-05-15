import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static void validateName(String name) throws IllegalAccessException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalAccessException("The name of the product cannot be empty");
        }
    }

    public static void validateStock(int stock) throws IllegalAccessException {
        if (stock < 0) {
            throw new IllegalAccessException("The stock of the product cannot be negative");
        }
    }

    public static void validatePrice(double price) throws IllegalAccessException {
        if (price <= 0) {
            throw new IllegalAccessException("The price of the product cannot be 0 or negative");
        }
    }

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException error) {
                System.out.println("Please enter a whole number. Try again.");
                sc.nextLine();
            }
        }
    }


    public static int readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException error) {
                System.out.println("Please enter a double number. Try again.");
                sc.nextLine();
            }
        }
    }

    public static String readText(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
