import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
public class SimpleBankAccountWithAtmTest extends BankAccountTest<SimpleBankAccountWithAtm>{

    @BeforeEach
    void beforeEach(){
        super.beforeEach();
        setBankAccount(new SimpleBankAccountWithAtm(getAccountHolder(),0));
    }

    @Test
    void testDepositWithAtm() {
        getBankAccount().ATMDeposit(getAccountHolder().getId(), 100);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        getBankAccount().ATMDeposit(getAccountHolder().getId(), 100);
        getBankAccount().ATMDeposit(2, 50);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testNegativeDepositWithAtm() {
        getBankAccount().ATMDeposit(getAccountHolder().getId(), 11);
        assertEquals(10, getBankAccount().getBalance());
        getBankAccount().ATMDeposit(getAccountHolder().getId(), 0.5);
        assertEquals(9.5, getBankAccount().getBalance());
        getBankAccount().ATMWithdraw(getAccountHolder().getId(), 8.5);
        assertEquals(0, getBankAccount().getBalance());
        getBankAccount().ATMWithdraw(getAccountHolder().getId(), 0.5);
        assertEquals(0, getBankAccount().getBalance());

    }

    @Test
    void testWithdrawWithAtm() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        getBankAccount().ATMWithdraw(getAccountHolder().getId(), 70);
        assertEquals(29, getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        getBankAccount().ATMWithdraw(2, 70);
        assertEquals(100, getBankAccount().getBalance());
    }

    @Test
    void testNegativeWithdrawWithAtm() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        getBankAccount().ATMWithdraw(getAccountHolder().getId(), -70);
        assertEquals(100, getBankAccount().getBalance());
    }

    @Test
    void testTotalWithdrawWithAtm() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        getBankAccount().ATMWithdraw(getAccountHolder().getId(), 100);
        assertEquals(100, getBankAccount().getBalance());
    }

}
