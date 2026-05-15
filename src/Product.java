public class Product {
    private int id;
    private int stock;
    private String name;
    private double price;
    public Product(int stock, String name, double price) {
        this.stock = stock;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
