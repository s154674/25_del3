package entity.fields;

import entity.Player;
import boundary.*;

public class Refuge extends Field {
	private int bonus;

	public Refuge(String fieldname, int fieldnumber, int bonus) {
		super(fieldname, fieldnumber);
		this.bonus = bonus;
	}

	@Override
	public void landOnField(Player lander) {
		lander.getAccount().deposit(bonus);
		Output.landOnRefuge(lander.toString(), bonus);
	}
}
