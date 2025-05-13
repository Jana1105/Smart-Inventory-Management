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

public class ViewProductsWindow extends JFrame {
    private List<Product> productList;

    public ViewProductsWindow(List<Product> productList) {
        this.productList = productList;

        setTitle("View Products");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Creating a table to display the products
        String[] columnNames = {"ID", "Name", "Category", "Quantity", "Price", "Supplier", "Date Added"};
        Object[][] data = new Object[productList.size()][7];

        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            data[i] = new Object[]{p.getId(), p.getName(), p.getCategory(), p.getQuantity(), p.getPrice(), p.getSupplier(), p.getDateAdded()};
        }

        JTable productTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        // Adding a Close button to close the View Products window
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }
}
