package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class ChefSpecial extends JFrame {
    private Map<String, DefaultListModel<String>> cuisineDishes = new HashMap<>();
    private JComboBox<String> cuisineComboBox;
    private JList<String> dishList;
    private DefaultListModel<String> dishListModel;

    public ChefSpecial() {
        initializeChefSpecial();
    }

    private void initializeChefSpecial() {
        setTitle("ChefConnect - Chef Special");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        cuisineComboBox = new JComboBox<>();
        cuisineComboBox.addActionListener(this::cuisineSelected);
        mainPanel.add(cuisineComboBox, BorderLayout.NORTH);

        dishListModel = new DefaultListModel<>();
        dishList = new JList<>(dishListModel);
        JScrollPane scrollPane = new JScrollPane(dishList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel with buttons to add/delete cuisines and dishes
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addCuisineButton = new JButton("Add Cuisine");
        JButton deleteCuisineButton = new JButton("Delete Cuisine");
        JButton addDishButton = new JButton("Add Dish");
        JButton deleteDishButton = new JButton("Delete Dish");

        addCuisineButton.addActionListener(this::addCuisine);
        deleteCuisineButton.addActionListener(this::deleteCuisine);
        addDishButton.addActionListener(e -> addDish());
        deleteDishButton.addActionListener(e -> deleteDish());

        buttonPanel.add(addCuisineButton);
        buttonPanel.add(deleteCuisineButton);
        buttonPanel.add(addDishButton);
        buttonPanel.add(deleteDishButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addCuisine(ActionEvent e) {
        String cuisine = JOptionPane.showInputDialog(this, "Enter new cuisine name:");
        if (cuisine != null && !cuisine.trim().isEmpty() && !cuisineDishes.containsKey(cuisine)) {
            DefaultListModel<String> model = new DefaultListModel<>();
            cuisineDishes.put(cuisine, model);
            cuisineComboBox.addItem(cuisine);
        }
    }

    private void deleteCuisine(ActionEvent e) {
        String selectedCuisine = (String) cuisineComboBox.getSelectedItem();
        if (selectedCuisine != null) {
            cuisineDishes.remove(selectedCuisine);
            cuisineComboBox.removeItem(selectedCuisine);
            dishListModel.clear(); // Clear dish list when cuisine is removed
        }
    }

    private void addDish() {
        String selectedCuisine = (String) cuisineComboBox.getSelectedItem();
        if (selectedCuisine != null) {
            String dish = JOptionPane.showInputDialog(this, "Enter new dish name:");
            if (dish != null && !dish.trim().isEmpty()) {
                DefaultListModel<String> model = cuisineDishes.get(selectedCuisine);
                if (!model.contains(dish)) {
                    model.addElement(dish);
                }
            }
        }
    }

    private void deleteDish() {
        String selectedCuisine = (String) cuisineComboBox.getSelectedItem();
        int selectedIndex = dishList.getSelectedIndex();
        if (selectedCuisine != null && selectedIndex >= 0) {
            DefaultListModel<String> model = cuisineDishes.get(selectedCuisine);
            model.remove(selectedIndex);
        }
    }

    private void cuisineSelected(ActionEvent e) {
        String selectedCuisine = (String) cuisineComboBox.getSelectedItem();
        if (selectedCuisine != null) {
            DefaultListModel<String> model = cuisineDishes.get(selectedCuisine);
            dishList.setModel(model);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChefSpecial().setVisible(true));
    }
}
