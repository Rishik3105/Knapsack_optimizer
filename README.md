# 🎒 KsnapOptimizer - 0/1 Knapsack Solver in Java

## 🚀 Overview
Welcome to **KsnapOptimizer**, a user-friendly Java-based application that helps solve the **0/1 Knapsack problem** using **dynamic programming**. With an intuitive GUI, you can easily input values and let the algorithm do the magic, giving you the best combination of items for maximum profit! 💰

## ✨ Features
✅ **Easy-to-use Interface** – Built with Java Swing for a seamless experience.
✅ **Optimized Algorithm** – Uses dynamic programming to get the best results efficiently.
✅ **Instant Results** – Get the selected items and maximum profit in seconds.
✅ **Reset Option** – Clear all inputs and start fresh with a single click.

## 🛠 Prerequisites
🔹 Java Development Kit (**JDK 8+**)
🔹 Any Java-supported IDE (IntelliJ, Eclipse, NetBeans) or simply run from the terminal.

## ▶️ How to Run
### 1️⃣ Clone or Download the Repository
```bash
git clone https://github.com/your-repo/KsnapOptimizer.git
cd KsnapOptimizer
```

### 2️⃣ Compile the Java Program
```bash
javac KnapsackGUI.java
```

### 3️⃣ Run the Application
```bash
java KnapsackGUI
```

## 📌 Usage Guide
1️⃣ **Enter Profits:** Type in space-separated profit values (e.g., `10 20 30 40`).
2️⃣ **Enter Weights:** Provide corresponding weight values (e.g., `1 2 3 4`).
3️⃣ **Set Maximum Weight:** Specify the total weight capacity of the knapsack.
4️⃣ **Click 'Solve Knapsack'** – Let the algorithm work its magic! ✨
5️⃣ **View Results:** See which items are selected and the total profit.
6️⃣ **Click 'Reset'** – Start fresh anytime!

## 📊 Example
**Input:**  
- 💰 Profit Array: `60 100 120`
- ⚖️ Weight Array: `10 20 30`
- 🎯 Max Weight: `50`

**Output:**  
```
🎒 Selected Items:
🛍️ Item 3 (Profit: 120, Weight: 30)
🛍️ Item 2 (Profit: 100, Weight: 20)

💵 Maximum Profit: 220
```

## 📝 Code Breakdown
🔹 **`KnapsackGUI` Class** – Manages the UI and user inputs.
🔹 **`runKnapsack()` Method** – Parses data, checks errors, and triggers the solver.
🔹 **`knapsack()` Method** – Implements the dynamic programming approach.
🔹 **`resetFields()` Method** – Clears everything for a new calculation.

## 🔮 Future Enhancements
🔹 **Fractional Knapsack Support** – Allowing fractional item selection.
🔹 **Data Import/Export** – Save and load input/output from files.
🔹 **Advanced Visualizations** – Interactive graphs for better insights.

## 📜 License
This project is released under the **MIT License**. Feel free to use and modify it! 📝

## 👤 About the Developer
👨‍💻 **Sriram Nagendra**  
🔗 LinkedIn: [linkedin](https://www.linkedin.com/in/nagendrasriram103/)

