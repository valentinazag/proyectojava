import java.util.List;
import java.util.Scanner;

public record ProductsMenu(Scanner sc, ProductService service) {

    public void showMenu() {
        System.out.println("======= CRUD Products =======");
        System.out.println("1) Add a product");
        System.out.println("2) List products");
        System.out.println("3) Find a product by it´s ID");
        System.out.println("4) Find a product by it´s name");
        System.out.println("5) Update product");
        System.out.println("6) Delete product");
        System.out.println("7) Exit");
        System.out.println("==============================================");
    }

    public void addProduct() throws IllegalAccessException {
        System.out.println("--- New product ---");
        String name = Validator.readText(sc, "Name: ");
        double price = Validator.readDouble(sc, "Price: ");
        int stock = Validator.readInt(sc, "Stock: ");


        Product product = new Product(stock, name, price);
        Product saved = service.saveProduct(product);

        System.out.println("New product added with id " + saved.getId());
    }

    public void listProducts() {
        List<Product> productList = service.listProducts();

        if (productList.isEmpty()) {
            System.out.println("0 products saved");
            return;
        }

        System.out.println("--- Products: ---");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void getProduct() {
        int id = Validator.readInt(sc, "ID of the product: ");
        Product product = service.getProductById(id);
        System.out.println("Found: " + product);
    }

    public void getProductByName() {
        String name = Validator.readText(sc, "Name of the product: ");
        Product product = service.getProductByName(name);
        System.out.println("Found: " + product);
    }

    public void updateProduct() throws IllegalAccessException {
        System.out.println("Update by:");
        System.out.println("1) ID");
        System.out.println("2) Name");

        int option = Validator.readInt(sc, "Option: ");
        Product data;

        if (option == 1) {
            int id = Validator.readInt(sc, "ID: ");
            data = service.getProductById(id);

        } else if (option == 2) {
            String name = Validator.readText(sc, "Name: ");
            data = service.getProductByName(name);

        } else {
            System.out.println("Invalid option");
            return;
        }

        System.out.println("Current data: " + data);

        System.out.println("--- New data ---");
        String newName = Validator.readText(sc, "Name: ");
        double price = Validator.readDouble(sc, "Price: ");
        int stock = Validator.readInt(sc, "Stock: ");

        data.setName(newName);
        data.setPrice(price);
        data.setStock(stock);

        System.out.println("Product updated: " + data);
    }

    public void deleteProduct() {

        System.out.println("Delete by:");
        System.out.println("1) ID");
        System.out.println("2) Name");
        int option = Validator.readInt(sc, "Option: ");

        if (option == 1) {
            int id = Validator.readInt(sc, "ID: ");
            service.deleteProduct(id);
        } else if (option == 2) {
            String name = Validator.readText(sc, "Name: ");
            Product product = service.getProductByName(name);
            service.deleteProduct(product.getId());
        }
        System.out.println("Product deleted.");
    }
}