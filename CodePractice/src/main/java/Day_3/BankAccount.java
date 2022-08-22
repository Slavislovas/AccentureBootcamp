package Day_3;

public class BankAccount {
    private double balance;

    public BankAccount(){
        balance = 0;
    }

    public BankAccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double newBalance){
        balance = newBalance;
    }

    public double deposit(double amount){
        if(amount > 5000){
            System.out.println("Transaction cancelled. Max deposit - 5000 | Your deposit: " + amount);
            return -1;
        } else {
            balance += amount;
            return balance;
        }
    }

    public double withdraw(double amount){
        if(balance - amount < 0){
            System.out.println("There is not enough funds");
            return -1;
        }
        balance -= amount;
        return balance;
    }

    public void printBalance(){
        System.out.println(balance);
    }

    public double transferFrom(BankAccount account, double amount){
        if(amount > account.getBalance()){
            System.out.println("Transfer cancelled. You are trying to transfer " + amount + " units, but only " + account.getBalance() + " are available.");
            return -1;
        } else {
            deposit(amount);
            account.withdraw(amount);
            return balance;
        }
    }
}
