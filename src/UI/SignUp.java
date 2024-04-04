package UI;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {

    public SignUp() {
        initializeSignUp();
    }

    private void initializeSignUp() {
        setTitle("ChefConnect - Sign Up");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4); // Padding

        // Name Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField nameField = new JTextField(20);
        panel.add(nameField, gbc);

        // Email Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Username Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField usernameField = new JTextField(20);
        panel.add(usernameField, gbc);

        // Password Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // Re-enter Password Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Re-enter Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JPasswordField rePasswordField = new JPasswordField(20);
        panel.add(rePasswordField, gbc);

        // Sign Up Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setPreferredSize(new Dimension(100, 25));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(signUpButton, gbc);

        // Action listener for sign-up button
        signUpButton.addActionListener(e -> {
            // Placeholder for sign-up logic
            JOptionPane.showMessageDialog(this, "Sign Up successful!");
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignUp signUpFrame = new SignUp();
            signUpFrame.setVisible(true);
        });
    }
}
