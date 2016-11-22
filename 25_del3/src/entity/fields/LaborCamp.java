package entity.fields;
import entity.*;
import java.util.ArrayList;

import entity.Cup;
import entity.Dice;

public class LaborCamp extends Ownable {
	private int baserent;
	private Cup labourCup;

	public LaborCamp(String fieldname, int fieldnumber, int price, int baserent) {
		super(fieldname, fieldnumber, price);
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
		ArrayList<Field> properties = owner.getProperties();
		int i;
		int camps=0;
		for (i=0;i<=properties.size();i++){
			if (properties.get(i) instanceof Fleet)
				camps++;
		}
		return camps;
	}
	
}
