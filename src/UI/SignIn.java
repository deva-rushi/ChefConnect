package UI;

import javax.swing.*;
import java.awt.*;

public class SignIn extends JFrame {

    public SignIn() {
        initializeSignIn();
    }

    private void initializeSignIn() {
        setTitle("ChefConnect - Sign In");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4); // Padding

        // Username Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField usernameField = new JTextField(20);
        panel.add(usernameField, gbc);

        // Password Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // Sign In Button
        JButton signInButton = new JButton("Sign In");
        signInButton.setPreferredSize(new Dimension(100, 25));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(signInButton, gbc);

        // Action listener for sign-in button
        signInButton.addActionListener(e -> {
            // Placeholder for backend
            JOptionPane.showMessageDialog(this, "Sign In successful!");
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignIn signInFrame = new SignIn();
            signInFrame.setVisible(true);
        });
    }
}
