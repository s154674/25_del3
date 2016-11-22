package entity.fields;

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
}
