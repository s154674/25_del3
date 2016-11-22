package entity.fields;

import entity.Player;

public class Territory extends Ownable {
	private int rent;

	public Territory(String fieldname, int fieldnumber, int price, int rent) {
		super(fieldname, fieldnumber, price);
		this.rent = rent;
	}

	@Override
	public int getRent() {
		return rent;
	}

	private void transferAmount(int amount, Player lander) {
		int amountWithdraw = lander.getAccount().withdraw(getRent());
		owner.getAccount().deposit(amountWithdraw);
		// GUI besked der viser mængden af penge der er blevet flyttet

	}
}
