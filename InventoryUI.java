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

public class InventoryUI extends JFrame {
    private List<Product> productList;

    public InventoryUI() {
        setTitle("Smart Inventory Manager");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        productList = FileUtil.loadProducts();

        // Header
        JLabel header = new JLabel("📦 Smart Inventory Manager", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 26));
        header.setOpaque(true);
        header.setBackground(new Color(0, 123, 255));
        header.setForeground(Color.WHITE);
        add(header, BorderLayout.NORTH);

        // Center Panel with Buttons
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        centerPanel.setBackground(new Color(245, 245, 245));

        JButton addBtn = new JButton("➕ Add Product");
        JButton updateBtn = new JButton("✏️ Update Product");
        JButton deleteBtn = new JButton("❌ Delete Product");
        JButton viewBtn = new JButton("👀 View Products");

        // Style the buttons
        styleButton(addBtn, new Color(40, 167, 69));
        styleButton(updateBtn, new Color(255, 193, 7));
        styleButton(deleteBtn, new Color(220, 53, 69));
        styleButton(viewBtn, new Color(23, 162, 184));

        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.gridx = 0; gbc.gridy = 0; centerPanel.add(addBtn, gbc);
        gbc.gridy = 1; centerPanel.add(updateBtn, gbc);
        gbc.gridy = 2; centerPanel.add(deleteBtn, gbc);
        gbc.gridy = 3; centerPanel.add(viewBtn, gbc); // Add View button

        add(centerPanel, BorderLayout.CENTER);

        // Action Listeners
        addBtn.addActionListener(e -> new AddProductWindow(productList, this).setVisible(true));
        updateBtn.addActionListener(e -> {
            Product p = selectProduct();
            if (p != null) new UpdateProductWindow(productList, this, p).setVisible(true);
        });
        deleteBtn.addActionListener(e -> {
            Product p = selectProduct();
            if (p != null) new DeleteProductWindow(productList, this, p).setVisible(true);
        });
        viewBtn.addActionListener(e -> new ViewProductsWindow(productList).setVisible(true)); // View Button Action
    }

    private void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(220, 45));
    }

    private Product selectProduct() {
        if (productList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products available.");
            return null;
        }

        String[] productNames = productList.stream().map(p -> p.getId() + " - " + p.getName()).toArray(String[]::new);
        String selection = (String) JOptionPane.showInputDialog(
                this, "Select a product:", "Choose Product",
                JOptionPane.PLAIN_MESSAGE, null, productNames, productNames[0]);

        if (selection != null) {
            int id = Integer.parseInt(selection.split(" - ")[0].trim());
            return productList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        }
        return null;
    }

    public void refreshTable() {
        // Not used in this version but kept for compatibility
    }

    // Main method for running
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryUI().setVisible(true));
    }
}

