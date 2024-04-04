package UI;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    public Home() {
        initializeHome();
    }

    private void initializeHome() {
        setTitle("ChefConnect Home");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome to ChefConnect", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create buttons
        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");
        JButton chefSignInButton = new JButton("Chef Sign In");

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        mainPanel.add(createButtonPanel(signInButton, signUpButton, chefSignInButton));
        mainPanel.add(Box.createVerticalGlue()); // Add space at the bottom

        add(mainPanel); // Add mainPanel to the frame
    }

    private JPanel createButtonPanel(JButton... buttons) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10)); // Align buttons horizontally

        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(150, 40)); // Set standard size for buttons
            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Home homeFrame = new Home();
            homeFrame.setVisible(true);
        });
    }
}
