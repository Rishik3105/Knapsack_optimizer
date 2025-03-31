import java.awt.*;
import javax.swing.*;

public class KnapsackGUI extends JFrame {
    private JTextField profitField, weightField, maxWeightField;
    private JTextArea resultArea;

    public KnapsackGUI() {
        setTitle("0/1 Knapsack Solver - Optimized");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating Panels for better UI
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel buttonPanel = new JPanel();
        JPanel resultPanel = new JPanel(new BorderLayout());

        // Input Fields
        inputPanel.add(new JLabel("Profit Array (space-separated):"));
        profitField = new JTextField(20);
        inputPanel.add(profitField);

        inputPanel.add(new JLabel("Weight Array (space-separated):"));
        weightField = new JTextField(20);
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Max Weight:"));
        maxWeightField = new JTextField(5);
        inputPanel.add(maxWeightField);

        // Buttons
        JButton solveButton = new JButton("Solve Knapsack");
        JButton resetButton = new JButton("Reset");

        buttonPanel.add(solveButton);
        buttonPanel.add(resetButton);

        // Result Area
        resultArea = new JTextArea(15, 55);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setBorder(BorderFactory.createTitledBorder("Result"));

        // Adding components
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        // Button Actions
        solveButton.addActionListener(e -> runKnapsack());
        resetButton.addActionListener(e -> resetFields());
    }

    private void runKnapsack() {
        try {
            int[] profits = parseInput(profitField.getText());
            int[] weights = parseInput(weightField.getText());
            int maxWeight = Integer.parseInt(maxWeightField.getText());

            if (profits.length != weights.length) {
                resultArea.setText(" Error: Profit and weight arrays must have the same length.");
                return;
            }

            String result = knapsack(profits, weights, maxWeight);
            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            resultArea.setText(" Error: Please enter valid numbers separated by spaces.");
        }
    }

    private int[] parseInput(String input) throws NumberFormatException {
        String[] parts = input.trim().split("\\s+");
        int[] values = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }
        return values;
    }

    private String knapsack(int[] profits, int[] weights, int maxWeight) {
        int n = profits.length;
        int[][] dp = new int[n + 1][maxWeight + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int maxProfit = dp[n][maxWeight];
        int w = maxWeight;
        StringBuilder selectedItems = new StringBuilder(" Selected Items:\n");

        // Traceback to find selected items
        for (int i = n; i > 0 && maxProfit > 0; i--) {
            if (maxProfit != dp[i - 1][w]) {
                selectedItems.append(" Item ").append(i)
                        .append(" (Profit: ").append(profits[i - 1])
                        .append(", Weight: ").append(weights[i - 1]).append(")\n");
                maxProfit -= profits[i - 1];
                w -= weights[i - 1];
            }
        }

        return selectedItems.append("\n Maximum Profit: ").append(dp[n][maxWeight]).toString();
    }

    private void resetFields() {
        profitField.setText("");
        weightField.setText("");
        maxWeightField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KnapsackGUI().setVisible(true));
    }
}
