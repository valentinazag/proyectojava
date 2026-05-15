import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private static int counterId;

    public Product saveProduct(Product product) throws IllegalAccessException {
        Validator.validateName(product.getName());
        Validator.validatePrice(product.getPrice());
        Validator.validateStock(product.getStock());

        product.setId(counterId);
        counterId += 1;

        products.add(product);
        return product;

    }

    public List<Product> listProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new ProductNotFoundException(
                "There are no products with the name: " + name);
    }

    public Product getProductById(int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException("There are no products with the id: " + id);
    }

    public Product updateProduct(int id, Product data) throws IllegalAccessException {
        Product product = getProductById(id);

        Validator.validateName(data.getName());
        Validator.validatePrice(data.getPrice());
        Validator.validateStock(data.getStock());

        product.setName(data.getName());
        product.setPrice(data.getPrice());
        product.setStock(data.getStock());

        return product;
    }

    public void deleteProduct(int id) {
        Product product = getProductById(id);
        products.remove(product);
    }


}
