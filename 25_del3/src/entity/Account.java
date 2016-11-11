package entity;

public class Account {
	private int balance;

	public Account(int initialBalance) {
		balance = initialBalance;
	}

	public int getBalance() {
		return balance;
	}

	public int deposit(int amount) {
		if (balance + (amount) >= 0) {
			balance += amount;
		} else {
			balance = 0;
		}
		return balance;
	}

	public int withdraw(int amount) {
		balance -= amount;
		return balance;
	}

}