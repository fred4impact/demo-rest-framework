package pojo;

public class Product {
    private String id;        // Use String for both ID and Quantity
    private String name;
    private String quantity;
    private String brand;
    private String category;

    // Getters and Setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // Optionally, you can provide methods to get quantity as integer if needed
    public Integer getQuantityAsInteger() {
        try {
            return Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            return null; // or throw an exception based on your use case
        }
    }
}
