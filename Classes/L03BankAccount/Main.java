package Advanced.Classes.L03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tockens = command.split("\\s+");
            String output = null;

            if (tockens[0].equals("Create")) {
                BankAccount account = new BankAccount();
                bankAccounts.put(account.getId(), account);
                output = "Account ID" + account.getId() + " created";
            } else if (tockens[0].equals("Deposit")) {
                int id = Integer.parseInt(tockens[1]);
                int amount = Integer.parseInt(tockens[2]);

                if (!bankAccounts.containsKey(id)) {
                    output = "Account does not exist";
                } else {
                    bankAccounts.get(id).deposit(amount);
                    output = "Deposited " + amount + " to ID" + id;
                }
            } else if (tockens[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tockens[1]));
            } else if (tockens[0].equals("GetInterest")) {
                int id = Integer.parseInt(tockens[1]);
                int years = Integer.parseInt(tockens[2]);

                if (!bankAccounts.containsKey(id)) {
                    output = "Account does not exist";
                } else {
                    double interest = bankAccounts.get(id).getInterest(years);
                    output =  String.format("%.2f", interest);
                }
            }

            if (output != null) {
                System.out.println(output);
            }
            command = scanner.nextLine();
        }
    }
}
