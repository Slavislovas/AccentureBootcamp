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

    public void deposit(double amount){
        if(amount > 5000){
            System.out.println("Transaction cancelled. Max deposit - 5000 | Your deposit: " + amount);
        } else {
            balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if(balance - amount < 0){
            System.out.println("There is not enough funds");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void printBalance(){
        System.out.println(balance);
    }

    public void transferFrom(BankAccount account, double amount){
        if(amount > account.getBalance()){
            System.out.println("Transfer cancelled. You are trying to transfer " + amount + " units, but only " + account.getBalance() + " are available.");
        } else {
            deposit(amount);
            account.withdraw(amount);
        }
    }
}
