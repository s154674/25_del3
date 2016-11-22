package entity.fields;

import entity.Player;

public class Tax extends Field {
	private int taxAmount;
	private int taxRate;

	public Tax(String fieldname, int fieldnumber, int taxAmount, int taxRate) {
		super(fieldname, fieldnumber);
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}

	@Override
	public void landOnField(Player lander) {
		int fee = taxAmount;
		if (taxRate == 0) {
			lander.getAccount().withdraw(fee);
		} else if (taxRate == -1) {
			// Skal bruge en metode som finder samlede værdi af lander's
			// properties.
			// og en prompt så spilleren kan vælge imellem 4k og 10%.
			int ans;
			if (4000 == 4000) {
				lander.getAccount().withdraw(fee);
			} else {
				int percent = 10; // % af samlet værdi
				lander.getAccount().withdraw(percent);
			}

		}
	}
}
