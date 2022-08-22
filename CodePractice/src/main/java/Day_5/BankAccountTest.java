package Day_5;

import Day_3.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit() {
        BankAccount account = new BankAccount();
        assertAll( () -> assertEquals(50, account.deposit(50)),
                () -> assertEquals(150.20, account.deposit(100.20)));
    }



    @Test
    void transferFrom() {
        BankAccount firstAccount = new BankAccount();
        BankAccount secondAccount = new BankAccount(500);
        firstAccount.transferFrom(secondAccount, 500);

        assertAll( () -> assertEquals(0, secondAccount.getBalance()),
                   () -> assertEquals(500, firstAccount.getBalance()));

        secondAccount.transferFrom(firstAccount, 501);

        assertAll( () -> assertEquals(0, secondAccount.getBalance()),
                () -> assertEquals(500, firstAccount.getBalance()));
    }
}