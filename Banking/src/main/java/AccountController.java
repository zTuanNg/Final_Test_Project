import java.util.List;
import java.util.Scanner;

public class AccountController {
    static AccountService service = new AccountService();
    static Scanner sc = new Scanner(System.in);
    static String username;
    static String password;
    static Account currentAccount;

    public static void run() {
        System.out.println("Đọc readme để lấy thông tin account");
        login();
        currentAccount = service.getAccountByUsernameAndPassword(username, password);

        while (true) {
            menu();
            System.out.println("Enter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter integer number");
                continue;
            }

            switch (choice) {

                // case1 : Truy vấn số dư tài khoản
                case 1:
                    System.out.println("=>Balance: " + service.getBalance(currentAccount));
                    break;

                // Chuyển tiền
                case 2:
                    transaction(currentAccount);
                    break;

                // Xem lịch sử giao dịch
                case 3:
                    showHistoryTransition(currentAccount);
                    break;

                default:
                    System.out.println("Have no this choice");
                    break;


            }
        }
    }


    public static void login() {
        while (true) {
            System.out.println("Enter Username: ");
            String name = sc.nextLine();
            System.out.println("Enter password: ");
            String pass = sc.nextLine();
            if (service.checkValid(name, pass)) {
                username = name;
                password = pass;
                System.out.println("Login successful !!!");
                break;
            }
            System.out.println("==> Username , Password incorrect , Please try again: ");
        }
    }

    public static void menu() {

        System.out.println("Welcome, Please choice this option");
        System.out.println("1 - Show balance");
        System.out.println("2 - Withdraw");
        System.out.println("3 - History transaction");
        System.out.println("0 - Exit");
    }

    public static boolean checkValidSTK(String stk) {
        if (stk.length() == 8 || stk.length() == 15) {
            try {
                int i = 0;
                while (i < stk.length()) {
                    int num = Integer.parseInt(stk.substring(i, i + 1));
                    i++;
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    // Input STK
    public static Account inputSTK(Account account) {
        while (true) {
            System.out.println("Enter account number: ");
            String stk = sc.nextLine();

            if (account.getAccountNumber().equals(stk)) {
                System.out.println("This account number is yours, Please enter different account number");
                continue;
            }
            if (!checkValidSTK(stk)) {
                System.out.println("Account number must be 8 or 15 characters!!!");
                System.out.println("Please try again!!!");
                continue;
            }

            Account acc = service.getAccountBySTK(stk);
            if (acc != null) {
                return acc;
            } else {
                System.out.println("This account number is not exist, Please try again!!!");
            }
        }
    }

    // transaction
    public static void transaction(Account currentAccount) {
        Account acc = inputSTK(currentAccount);

        while (true) {
            double amount;
            System.out.println("Enter amount: ");
            try {
                amount = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Amount is not valid, try again!!!");
                continue;
            }

            if (currentAccount.getBalance() < 100000) {
                System.out.println("Balance is not enough to do transaction !!!");
                break;
            }

            if (amount < 50000) {
                System.out.println("Amount must be > 50000, Try agian!!!");
                continue;
            }
            if (currentAccount.getBalance() - amount < 50000) {
                System.out.printf("Your balance is: %s, amount too much , Please try agian!!!\n", service.getBalance(currentAccount));
                continue;
            }

            System.out.println("Enter message: ");
            String message = sc.nextLine();
            currentAccount.withdraw(amount);
            System.out.println("Transaction successful");
            Transaction trans = new Transaction(message, acc.getAccountNumber(), amount);
            List<Transaction> t = currentAccount.getTransaction();
            t.add(trans);
            break;

        }
    }

    public static void showHistoryTransition(Account acc) {
        System.out.println("===History transaction===");
        if (acc.getTransaction().size() != 0)
            acc.getTransaction().forEach(t -> System.out.println(t));
        else
            System.out.println("=>History transaction is empty!");

    }
}