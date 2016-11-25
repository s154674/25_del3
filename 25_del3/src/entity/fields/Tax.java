package entity.fields;

import entity.Player;
import boundary.*;

public class Tax extends Field {
	private int taxAmount;
	private int taxRate;

	public Tax(String fieldName, int fieldNumber, int taxAmount, int taxRate) {
		super(fieldName, fieldNumber);
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}

	@Override
	public void landOnField(Player lander) {
		int fee = taxAmount;
		if (taxRate == -1) {
			lander.getAccount().withdraw(fee);
			Output.landOnTax(lander.toString(), fee);
		} else if (taxRate == 0) {
			boolean ans = Input.getTaxChoice();
			if (ans==true) {
				Output.landOnTax(lander.toString(), fee);
				lander.pay(fee);
			} else {
				int percent, i, sum = lander.getAccount().getBalance();
				for (i=0;i<lander.getProperties().size();i++){
					sum+=lander.getProperties().get(i).getPrice();
				}
				percent = (int) sum/10;
				Output.landOnTax(lander.toString(), percent);
				lander.pay(percent);
			}
		}
	}
	public int getPrice(){
		return -taxAmount;
	}
}
