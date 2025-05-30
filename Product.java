/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JANA
 */
public class Product {
    private int id;
    private String name, category, supplier, dateAdded;
    private int quantity;
    private double price;

    public Product(int id, String name, String category, int quantity, double price, String supplier, String dateAdded) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.dateAdded = dateAdded;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getSupplier() { return supplier; }
    public String getDateAdded() { return dateAdded; }

    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + quantity + "," + price + "," + supplier + "," + dateAdded;
    }

    public static Product fromString(String line) {
        String[] parts = line.split(",");
        return new Product(
            Integer.parseInt(parts[0]),
            parts[1], parts[2],
            Integer.parseInt(parts[3]),
            Double.parseDouble(parts[4]),
            parts[5], parts[6]
        );
    }
}
