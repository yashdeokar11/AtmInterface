import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) {
        MyATM atm = new MyATM();

        atm.checkPIN();

    }
}

class MyATM {
    float Balance;
    int PIN = 1108;
    Map<Float, String> history = new HashMap<>();

    public void checkPIN() {
        System.out.println("Enter Four Digit PIN: ");
        Scanner sc = new Scanner(System.in);
        int eneterredPIN = sc.nextInt();
        if (eneterredPIN == PIN) {
            menu();
        } else {
            System.out.println("Wrong PIN !!! Enter Valid PIN.");
            checkPIN();
        }

    }

    public void menu() {
        System.out.println("Enter Your Choice : ");
        System.out.println("1. View Transaction History  ");
        System.out.println("2. Check A/C Balance ");
        System.out.println("3. WithDraw Money ");
        System.out.println("4. Deposit Money ");
        System.out.println("5. Quit ");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            viewMiniStatement();
        }

        else if (opt == 2) {
            checkBalance();
        } else if (opt == 3) {
            withdrawMoney();
        } else if (opt == 4) {
            depositMoney();
        } else if (opt == 5) {
            System.out.println("Thank You !! Visit Again 🙂🙂🙂");

            return;
        } else {
            System.out.println("Enter a Valid Choice !!");
        }
    }

    public void checkBalance() {
        System.out.println("Balance " + Balance);
        System.out.println();
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to Withdraw: ");
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextInt();
        if (amount > Balance) {
            System.out.println("Insufficient Balance !!");
        } else {
            Balance = Balance - amount;
            System.out.println("Money Withdrawal Successful !!");
            history.put(amount, " Amount Withdrawn !!");
            System.out.println();
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter Amount to Deposit: ");
        Scanner scanner = new Scanner(System.in);
        float amount = scanner.nextInt();
        Balance = Balance + amount;
        System.out.println("Money Deposit Successful !! ");
        history.put(amount, " Amount Deposited !!");
        System.out.println();

        menu();

    }

    public void viewMiniStatement() {
        for (Map.Entry<Float, String> m : history.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
        System.out.println();
        menu();

    }
}