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
 import java.awt.event.ActionEvent;
 
 public class LoginPage extends JFrame {
     private JTextField userField;
     private JPasswordField passField;
 
     public LoginPage() {
         setTitle("Admin Login");
         setSize(400, 350);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLayout(new GridBagLayout());
         getContentPane().setBackground(new Color(240, 245, 250));
 
         Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
         Font titleFont = new Font("Segoe UI", Font.BOLD, 24);
         Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
 
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(10, 15, 10, 15);
         gbc.fill = GridBagConstraints.HORIZONTAL;
 
         JLabel title = new JLabel("Inventory System", SwingConstants.CENTER);
         title.setFont(titleFont);
         title.setForeground(new Color(0, 102, 204));
         gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
         add(title, gbc);
 
         gbc.gridwidth = 1;
 
         JLabel userLabel = new JLabel("Username:");
         userLabel.setFont(labelFont);
         gbc.gridx = 0; gbc.gridy = 1;
         add(userLabel, gbc);
         
         gbc.gridx = 1;
         userField = new JTextField();
         userField.setFont(labelFont);
         userField.setPreferredSize(new Dimension(200, 30));
         add(userField, gbc);
 
         JLabel passLabel = new JLabel("Password:");
         passLabel.setFont(labelFont);
         gbc.gridx = 0; gbc.gridy = 2;
         add(passLabel, gbc);
         
         gbc.gridx = 1;
         passField = new JPasswordField();
         passField.setFont(labelFont);
         passField.setPreferredSize(new Dimension(200, 30));
         add(passField, gbc);
 
         JButton loginBtn = new JButton("Login");
         loginBtn.setFont(buttonFont);
         loginBtn.setBackground(new Color(0, 102, 204));
         loginBtn.setForeground(Color.WHITE);
         loginBtn.addActionListener(this::performLogin);
         gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
         add(loginBtn, gbc);
 
         setVisible(true);
     }
 
     private void performLogin(ActionEvent e) {
         String username = userField.getText().trim();
         String password = new String(passField.getPassword()).trim();
 
         if (username.isEmpty() || password.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please enter both username and password");
             return;
         }
 
         if (username.equals("jana") && password.equals("123")) {
             dispose();
             new InventoryUI().setVisible(true);
         } else {
             JOptionPane.showMessageDialog(this, "Invalid credentials");
             passField.setText("");
         }
     }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(LoginPage::new);
     }
 }