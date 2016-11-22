package entity.fields;

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
		int facevalue = labourCup.getSum();
		return baserent * facevalue;
		// LaborCamp tager facevalue af summen af dice for at finde rent.
	}

}
