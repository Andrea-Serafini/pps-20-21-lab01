package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account With ATM allows always the deposit
 * while the withdraw is allowed only if the balance greater or equal the withdrawal amount.
 * Each transaction done with the ATM implies paying a 1$ fee.
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    public static final double ATMFee = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    public void ATMDeposit(int usrID, double amount) {
        if(amount-ATMFee > 0){
            super.deposit(usrID, amount - ATMFee);
        } else {
            super.withdraw(usrID, ATMFee - amount);
        }
    }

    public void ATMWithdraw(int usrID, double amount) {
        super.withdraw(usrID, amount + ATMFee);
    }


}
