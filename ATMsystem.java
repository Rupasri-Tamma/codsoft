//creation of bank account
import java.util.Scanner;
class Bankaccount {
    private double balance;

    public Bankaccount(double balance) {
        this.balance = balance;
    }

    public double getbalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            return true;
        }
        return false;
    }
}
//creation of ATM class
class ATM {
    Bankaccount account;
    public ATM(Bankaccount account){
        this.account = account;
    }
    public void showMenu() {
        Scanner sc =  new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n------ATM-----");
            System.out.println("1.check bakance");
            System.out.println("2.deposite money");
            System.out.println("3.withdraw money");
            System.out.println("4.exit");
            System.out.println("choose option ");
            
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.println("enter amount to deposit: ");
                    double depositamount = sc.nextDouble();
                    deposit(depositamount);
                    break;
                case 3:
                    System.out.println("enter amount to withdraw: ");
                    double withdrawamount = sc.nextDouble();
                    withdraw(withdrawamount);
                case 4:
                    System.out.println("Thankyou for using ATM hope you will visit again");
                    break;
                default:
                    System.out.println("Invalid option! try again");
            }
        }while (choice != 4);
    }
    public void checkBalance() {
        System.out.println("current balance: "+ account.getbalance());
    }
    public void deposit(double amount){
        if(amount > 0){
            account.deposit(amount);
            System.out.println("deposit successful");
        }else{
            System.out.println("invalid amount! try again");
        }
    }
    public  void withdraw(double amount){
         if(account.withdraw(amount)){
            System.out.println("withdraw successful");
        }
        else{
            System.out.println("insufficient balance");
        }
    }
}
//creation of main class
public class ATMsystem {
    public static void main(String[] args){
        Bankaccount useraccount = new Bankaccount(1000);//initial balance
        ATM atm = new ATM(useraccount);
         atm.showMenu();
    }
}