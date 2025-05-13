/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JANA
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UpdateProductWindow extends JFrame {
    private JTextField nameField, categoryField, quantityField, priceField, supplierField, dateField;
    private List<Product> productList;
    private InventoryUI mainUI;
    private Product product;

    public UpdateProductWindow(List<Product> productList, InventoryUI mainUI, Product product) {
        this.productList = productList;
        this.mainUI = mainUI;
        this.product = product;

        if (product == null) {
            JOptionPane.showMessageDialog(this, "Please select a product to update.");
            dispose();
            return;
        }

        setTitle("Update Product");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 5, 5));

        nameField = new JTextField(product.getName());
        categoryField = new JTextField(product.getCategory());
        quantityField = new JTextField(String.valueOf(product.getQuantity()));
        priceField = new JTextField(String.valueOf(product.getPrice()));
        supplierField = new JTextField(product.getSupplier());
        dateField = new JTextField(product.getDateAdded());

        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Category:")); add(categoryField);
        add(new JLabel("Quantity:")); add(quantityField);
        add(new JLabel("Price:")); add(priceField);
        add(new JLabel("Supplier:")); add(supplierField);
        add(new JLabel("Date Added:")); add(dateField);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateProduct());
        add(updateButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private void updateProduct() {
        try {
            String name = nameField.getText();
            String category = categoryField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String supplier = supplierField.getText();
            String date = dateField.getText();

            Product updatedProduct = new Product(product.getId(), name, category, quantity, price, supplier, date);

            int index = productList.indexOf(product);
            productList.set(index, updatedProduct);
            FileUtil.saveAllProducts(productList);
            mainUI.refreshTable();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
