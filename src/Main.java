import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        Scanner sc = new Scanner(System.in);
        ProductsMenu menu = new ProductsMenu(sc, service);

        int menuOption;
        do {
            menu.showMenu();
            menuOption = Validator.readInt(sc, "Select a menu option:");
            try {
                switch (menuOption) {
                    case 1 -> menu.addProduct();
                    case 2 -> menu.listProducts();
                    case 3 -> menu.getProduct();
                    case 4 -> menu.getProductByName();
                    case 5 -> menu.updateProduct();
                    case 6 -> menu.deleteProduct();
                    case 7 -> System.out.println("Exiting the program");
                    default -> System.out.println("Invalid option. Choose a number between 1 (one) and 6 (six)");
                }
            } catch (ProductNotFoundException | InsufficientStockException | IllegalAccessException error) {
                System.out.println(error.getMessage());
            } catch (IllegalArgumentException error) {
                System.out.println("Invalid data: " + error.getMessage());
            }
                System.out.println();
            } while (menuOption != 6);

            sc.close();
        }
    }
