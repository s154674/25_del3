package entity;

public class Player {
	private String name;
	private boolean won;
	private Account account;

	public Player(String name, Account account) {
		this.name = name;
		this.account = account;
		this.won = false;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getBalance() {
		return account.getBalance();
	}

	public Account getAccount() {
		return account;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public boolean getWon() {
		return won;
	}
}