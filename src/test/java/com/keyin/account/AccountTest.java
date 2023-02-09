/**
 * @author Makenzie Roberts
 */

/*
    Comment Legend:
         ❗ --- Note to Professor
        🧠 --- Logic
*/

package com.keyin.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @see com.keyin.account.Account
 */
public class AccountTest {
    /*
        ❗ NOTES:

          I hope you don't mind that I use assertEquals() instead of assertTrue() in my test classes. I
          prefer to use assertEquals() because it's more explicit and I find it easier to read, whereas
          I only prefer to use assertTrue() when testing a boolean value.

          When I was researching unit testing, many programmers mentioned that it's usually bad practice to
          add print statements to unit tests, so I omitted them. Instead, I tried to make the test names and
          code as descriptive and readable as possible, so I hope that's okay.

          I believe you mentioned that we don't need to test setters and getters, so I didn't. I also didn't
          test my constructor, since it didn't contain any logic and is effectively just another basic setter.
    */

    /**
     * @see com.keyin.account.Account#credit(int)
     */
    @Test
    public void testCredit() {
        Account account = new Account("1a2b3c", "John Doe", 5000);

        account.credit(1000);

        int actualBalance = account.getBalance();
        Assertions.assertEquals(6000, actualBalance);
    }

    /**
     * @see com.keyin.account.Account#debit(int)
     */
    @Test
    public void testDebitWithSufficientFunds() {
        Account account = new Account("1a2b3c", "John Doe", 5000);

        account.debit(4000);

        int actualBalance = account.getBalance();
        Assertions.assertEquals(1000, actualBalance);
    }

    /**
     * @see com.keyin.account.Account#debit(int)
     */
    @Test
    public void testDebitWithInsufficientFunds() {
        Account account = new Account("1a2b3c", "John Doe", 5000);

        account.debit(6000);

        int actualBalance = account.getBalance();
        Assertions.assertEquals(5000, actualBalance);
    }

    /**
     * @see com.keyin.account.Account#transferTo(Account, int)
     */
    @Test
    public void testTransferToWithSufficientFunds() {
        Account accountToDebit = new Account("1a2b3c", "John Doe", 5000);
        Account accountToCredit = new Account("7x8y9z", "Jane Doe", 4000);

        accountToDebit.transferTo(accountToCredit, 1000);

        int accountToDebitActualBalance = accountToDebit.getBalance();
        int accountToCreditActualBalance = accountToCredit.getBalance();
        Assertions.assertEquals(4000, accountToDebitActualBalance);
        Assertions.assertEquals(5000, accountToCreditActualBalance);
    }

    /**
     * @see com.keyin.account.Account#transferTo(Account, int)
     */
    @Test
    public void testTransferToWithInsufficientFunds() {
        Account accountToDebit = new Account("1a2b3c", "John Doe", 5000);
        Account accountToCredit = new Account("7x8y9z", "Jane Doe", 4000);

        accountToDebit.transferTo(accountToCredit, 6000);

        int accountToDebitActualBalance = accountToDebit.getBalance();
        int accountToCreditActualBalance = accountToCredit.getBalance();
        Assertions.assertEquals(5000, accountToDebitActualBalance);
        Assertions.assertEquals(4000, accountToCreditActualBalance);
    }

    /**
     * @see com.keyin.account.Account#toString()
     */
    @Test
    public void testToString() {
        Account account = new Account("1a2b3c", "John Doe", 5000);

        String actualString = account.toString();
        Assertions.assertEquals("Account[id=1a2b3c,name=John Doe,balance=5000]", actualString);
    }
}


