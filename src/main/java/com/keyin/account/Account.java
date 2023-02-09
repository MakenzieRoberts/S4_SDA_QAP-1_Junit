/**
 * @author Makenzie Roberts
 */

/*
    Comment Legend:
         ❗ --- Note to Professor
        🧠 --- Logic
*/

package com.keyin.account;

public class Account {
    /* Instance variables */
    private String id;
    private String name;
    private int balance = 0;

    /* Constructor */
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Parameterized Constructor */
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    /* Getters */
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    /* Methods */
    public int credit(int amount) {
        return this.balance += amount;
    }

    public int debit(int amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.printf("""
                    Attempted Debit Denied (Amount exceeded balance)
                    \tSender:    %s
                    \tAmount:    $%d%n
                    """, this, amount);
        }
        return this.balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            another.balance += amount;
        } else {
            System.out.printf("""
                    Attempted Transfer Denied (Amount exceeded balance)
                    \tSender:    %s
                    \tRecipient: %s
                    \tAmount:    $%d%n
                    """, this, another, amount);
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + this.id + ",name=" + this.name + ",balance=" + this.balance + "]";
    }

}

