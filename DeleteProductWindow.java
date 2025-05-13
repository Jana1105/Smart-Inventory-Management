/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JANA
 */

import javax.swing.*;
import java.util.List;

public class DeleteProductWindow extends JFrame {
    private List<Product> productList;
    private InventoryUI mainUI;
    private Product product;

    public DeleteProductWindow(List<Product> productList, InventoryUI mainUI, Product product) {
        this.productList = productList;
        this.mainUI = mainUI;
        this.product = product;

        if (product == null) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.");
            dispose();
            return;
        }

        setTitle("Delete Product");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel msg = new JLabel("Are you sure you want to delete product: " + product.getName() + "?");
        msg.setAlignmentX(CENTER_ALIGNMENT);
        add(msg);

        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete");
        JButton cancelButton = new JButton("Cancel");

        deleteButton.addActionListener(e -> deleteProduct());
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(deleteButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel);
    }

    private void deleteProduct() {
        productList.remove(product);
        FileUtil.saveAllProducts(productList);
        mainUI.refreshTable();
        dispose();
    }
}
