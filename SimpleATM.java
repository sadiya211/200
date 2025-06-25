import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleATM {
    private static final String DATA_FILE = "users.txt";
    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        loadAccounts();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Simple ATM");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        if (!accounts.containsKey(userId)) {
            System.out.println("User ID not found. Creating a new account.");
            accounts.put(userId, 0.0);
            saveAccounts();
        }

        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(userId);
                    break;
                case 2:
                    deposit(userId, scanner);
                    break;
                case 3:
                    withdraw(userId, scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple ATM. Goodbye!");
                    saveAccounts();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance(String userId) {
        System.out.println("Your current balance is: $" + accounts.get(userId));
    }

    private static void deposit(String userId, Scanner scanner) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            accounts.put(userId, accounts.get(userId) + amount);
            System.out.println("Deposit successful. New balance: $" + accounts.get(userId));
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdraw(String userId, Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        double currentBalance = accounts.get(userId);
        if (amount > 0 && amount <= currentBalance) {
            accounts.put(userId, currentBalance - amount);
            System.out.println("Withdrawal successful. New balance: $" + accounts.get(userId));
        } else {
            System.out.println("Invalid amount. Please check your balance or enter a valid value.");
        }
    }

    private static void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userId = parts[0];
                double balance = Double.parseDouble(parts[1]);
                accounts.put(userId, balance);
            }
        } catch (IOException e) {
            System.out.println("No existing data found. Starting fresh.");
        }
    }

    private static void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, Double> entry : accounts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data. Changes may not be preserved.");
        }
    }
}
