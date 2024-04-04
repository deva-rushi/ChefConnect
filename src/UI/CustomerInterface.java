package UI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerInterface extends JFrame {
    private Map<String, Integer> cart = new HashMap<>();

    public CustomerInterface() {
        initializeCustomerInterface();
    }

    private void initializeCustomerInterface() {
        setTitle("ChefConnect - Customer Interface");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        String[] cuisines = {"Indian", "Chinese"};
        String[][] menuItems = {
                {"Butter Chicken", "Palak Paneer", "Biryani"},
                {"Dumplings", "Kung Pao Chicken", "Spring Rolls"}
        };

        for (int i = 0; i < cuisines.length; i++) {
            tabbedPane.addTab(cuisines[i], createCuisinePanel(cuisines[i], menuItems[i]));
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(e -> viewCart());
        bottomPanel.add(viewCartButton);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkoutCart());
        bottomPanel.add(checkoutButton);

        add(tabbedPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createCuisinePanel(String cuisine, String[] menuItems) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (String item : menuItems) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel itemLabel = new JLabel(item);
            itemPanel.add(itemLabel);

            SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner spinner = new JSpinner(model);
            itemPanel.add(spinner);

            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> {
                int quantity = (Integer) spinner.getValue();
                cart.put(item, cart.getOrDefault(item, 0) + quantity); // Add to cart
                JOptionPane.showMessageDialog(this, quantity + " x " + item + " added to cart.");
            });
            itemPanel.add(addButton);

            panel.add(itemPanel);
        }

        return panel;
    }

    private void viewCart() {
        StringBuilder cartContents = new StringBuilder("Cart:\n");
        cart.forEach((item, quantity) -> cartContents.append(item).append(": ").append(quantity).append("\n"));
        JOptionPane.showMessageDialog(this, cartContents.toString());
    }

    private void checkoutCart() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty.");
        } else {
            JOptionPane.showMessageDialog(this, "Checkout successful!");
            cart.clear(); // Clear the cart after checkout
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerInterface().setVisible(true));
    }
}
