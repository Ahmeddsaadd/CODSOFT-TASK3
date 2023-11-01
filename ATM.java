import java.util.Scanner;
public class ATM {
    BankAccount account = new BankAccount();
    double balance = account.getBalance();
    Scanner in = new Scanner(System.in);

    public int userIn(){
        System.out.println("Enter your choice: ");
        int choice;
        choice = in.nextInt();
        return choice;
    }
    public void choiceInput(){
        System.out.println("ATM MACHINE OPERATIONS");
        System.out.println();
        System.out.println("CLICK 0 for Check Balance");
        System.out.println("CLICK 1 for Withdraw");
        System.out.println("CLICK 2 for Deposit");
        System.out.println("CLICK 3 for Exit");
        System.out.println();
    }

    public double checkBalance(){
        return balance;
    }

    public void depositing(double amount){
        balance += amount;
        System.out.println("Your money has been successfully deposited.");
        System.out.println();
    }

    public void withDraw(double amount){
        try{
            if(balance - amount < 0){
                throw new NegativeBalanceException();
            }
            balance -= amount;
            System.out.println("Withdraw done !");
            System.out.println("Collect your money please.");
            System.out.println();
        }
        catch(NegativeBalanceException e){
            System.out.println("The amount you want to draw is greater than the balance !");
            System.out.println();
        }
    }

    public void applyOperation() {

        double amount;
        while (true) {
            choiceInput();

            int input = userIn();
            switch (input) {
                case 0:
                    System.out.println("Your balance is " + checkBalance());
                    System.out.println();
                    break;
                case 1:
                    System.out.println("Enter the amount to be withdrawn: ");
                    amount = in.nextDouble();
                    withDraw(amount);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: ");
                    amount = in.nextDouble();
                    depositing(amount);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Enter valid option !");
            }
        }
    }
}
