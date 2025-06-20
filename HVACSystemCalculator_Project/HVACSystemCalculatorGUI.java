// HVACSystemCalculatorGUI.java - GUI-based HVAC System Calculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HVACSystemCalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HVAC System Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        String[] refrigerants = {"R22", "R410a", "R454b", "R32"};
        JComboBox<String> refrigerantBox = new JComboBox<>(refrigerants);
        JTextField quantityField = new JTextField();

        String[] services = {"installation", "repair", "maintenance"};
        JComboBox<String> serviceBox = new JComboBox<>(services);

        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        frame.add(new JLabel("Refrigerant:"));
        frame.add(refrigerantBox);
        frame.add(new JLabel("Quantity (lbs):"));
        frame.add(quantityField);
        frame.add(new JLabel("Service Type:"));
        frame.add(serviceBox);
        frame.add(new JLabel(""));
        frame.add(calculateButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultArea);

        calculateButton.addActionListener(e -> {
            Map<String, Double> refrigerantPrices = new HashMap<>();
            refrigerantPrices.put("R22", 250.0);
            refrigerantPrices.put("R410a", 150.0);
            refrigerantPrices.put("R454b", 99.0);
            refrigerantPrices.put("R32", 89.0);

            Map<String, Integer> serviceCosts = new HashMap<>();
            serviceCosts.put("installation", 500);
            serviceCosts.put("repair", 200);
            serviceCosts.put("maintenance", 100);

            String refrigerant = (String) refrigerantBox.getSelectedItem();
            String service = (String) serviceBox.getSelectedItem();

            try {
                double quantity = Double.parseDouble(quantityField.getText());
                double refrigerantCost = refrigerantPrices.get(refrigerant) * quantity;
                int serviceCost = serviceCosts.get(service);
                double total = refrigerantCost + serviceCost;

                resultArea.setText("Refrigerant: " + refrigerant + "\n" +
                        "Quantity: " + quantity + " lbs\n" +
                        "Refrigerant Cost: $" + refrigerantCost + "\n" +
                        "Service: " + service + "\n" +
                        "Service Cost: $" + serviceCost + "\n" +
                        "Total Cost: $" + total);
            } catch (NumberFormatException ex) {
                resultArea.setText("Invalid quantity. Please enter a number.");
            }
        });

        frame.setVisible(true);
    }
}