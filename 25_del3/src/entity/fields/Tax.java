package entity.fields;

import entity.Player;

public class Tax extends Field {
	private int taxAmount;
	private int taxRate;

	public Tax(String fieldname, int fieldnumber, int taxAmount) {
		super(fieldname, fieldnumber);
		this.taxAmount = taxAmount;
	}

	@Override
	public void landOnField(Player lander) {
		if (taxAmount == 2000) {
			getTax(2000, lander);
		} else if (taxAmount == 4000) {
			// Skal bruge en metode som finder samlede værdi af lander's
			// properties.
		}
	}

	private void getTax(int amount, Player lander) {
		lander.getAccount().withdraw(amount);
	}

}
