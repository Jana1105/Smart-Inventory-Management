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

public class AddProductWindow extends JFrame {
    private JTextField nameField, categoryField, quantityField, priceField, supplierField, dateField;
    private List<Product> productList;
    private InventoryUI mainUI;

    public AddProductWindow(List<Product> productList, InventoryUI mainUI) {
        this.productList = productList;
        this.mainUI = mainUI;

        setTitle("Add Product");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 5, 5));

        nameField = new JTextField(); categoryField = new JTextField();
        quantityField = new JTextField(); priceField = new JTextField();
        supplierField = new JTextField(); dateField = new JTextField();

        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Category:")); add(categoryField);
        add(new JLabel("Quantity:")); add(quantityField);
        add(new JLabel("Price:")); add(priceField);
        add(new JLabel("Supplier:")); add(supplierField);
        add(new JLabel("Date Added:")); add(dateField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveProduct());
        add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private void saveProduct() {
        try {
            int id = productList.size() + 1;
            String name = nameField.getText();
            String category = categoryField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String supplier = supplierField.getText();
            String date = dateField.getText();

            Product p = new Product(id, name, category, quantity, price, supplier, date);
            FileUtil.saveProduct(p);
            productList.add(p);
            mainUI.refreshTable();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
