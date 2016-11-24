package entity.fields;
import entity.*;
import java.util.ArrayList;

import entity.Cup;
import entity.Dice;

public class LaborCamp extends Ownable {
	private int baserent;
	private Cup labourCup;

	public LaborCamp(String fieldName, int fieldNumber, int price, int baserent) {
		super(fieldName, fieldNumber, price);
		labourCup = new Cup(new Dice(), new Dice());
		this.baserent = baserent;
	}

	@Override
	public int getRent() {
		labourCup.rollAll();
		int facevalue = labourCup.getSum();
		int multi = campsOwned(owner);
		return baserent * facevalue * multi;
		// LaborCamp tager facevalue af summen af dice for at finde rent.
	}
	public int campsOwned(Player owner){
		ArrayList<Ownable> properties = owner.getProperties();
		int camps=0;
		for (Ownable property: properties) {
			if (property instanceof LaborCamp)
				camps++;
		}
		return camps;
	}
	
}
