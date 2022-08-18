package Day_3;

public class Main {
    public static void main(String[] args) {
        //Main.firstTask();
        //Main.secondTask();
        //Main.thirdAndFourthTask();
        Main.fifthTask();

    }

    public static void firstTask(){
        int[][] multiplicationTable = new int[10][10];

        for (int i = 0; i <= 9; i++){
            for(int j = 0; j <= 9; j++){
                multiplicationTable[i][j] = (i + 1) * (j + 1);
                System.out.print(multiplicationTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void secondTask(){
        int[] array = {5, 6, 32, 10};
        int[] arrayCopy = new int[array.length];

        for(int i = 0; i < array.length; i++){
            arrayCopy[i] = array[i];
            System.out.println(arrayCopy[i]);
        }
    }

    public static void thirdAndFourthTask(){
        BankAccount firstAccount = new BankAccount(5000);
        BankAccount secondAccount = new BankAccount(2000);

        System.out.println("Current first bank account balance: " + firstAccount.getBalance());
        firstAccount.withdraw(2000);
        System.out.println("Tried to withdraw 2000 from the first bank account. Current balance: " + firstAccount.getBalance());
        firstAccount.withdraw(5000);
        System.out.println("Tried to withdraw 5000 from the first bank account. Current balance: " + firstAccount.getBalance());

        System.out.println("Trying to deposit 6000 to first bank account.");
        firstAccount.deposit(6000);

        System.out.println("Trying to tranfer 3000 from the second bank account to the first.");
        firstAccount.transferFrom(secondAccount, 3000);
    }

    public static void fifthTask(){
        PickupTruck truck = new PickupTruck("Mercedes-benz", 256000, "5", 110, 220, 20, 60, "Diesel", 256.4);
        System.out.println(truck.toString());

        System.out.println("Current truck speed: " + truck.getCurrentSpeed() + " let's accelerate by 20");
        truck.accelerate(20);
        System.out.println("Current truck speed: " + truck.getCurrentSpeed());
        System.out.println("Now let's try to accelerate over the max speed");
        truck.accelerate(500);
        System.out.println("Current truck speed: " + truck.getCurrentSpeed());
        System.out.println("Let's try to decelerate by 20 now");
        truck.decelerate(20);
        System.out.println("Current truck speed: " + truck.getCurrentSpeed());
        System.out.println("Current gear the truck is in: " + truck.getCurrentGear() + " let's try to put it in reverse while going at the speed of 110");
        truck.changeGears("R");
        System.out.println("Current gear the truck is in: " + truck.getCurrentGear());

    }
}