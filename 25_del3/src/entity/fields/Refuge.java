package entity.fields;

import entity.Player;
import boundary.*;

public class Refuge extends Field {
	private int bonus;

	public Refuge(String fieldName, int fieldNumber, int bonus) {
		super(fieldName, fieldNumber);
		this.bonus = bonus;
	}

	@Override
	public void landOnField(Player lander) {
		lander.getAccount().deposit(bonus);
		Output.landOnRefuge(lander.toString(), bonus);
	}
	public int getPrice(){
		return bonus;
	}
}
