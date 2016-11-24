package entity.fields;

public class Territory extends Ownable {
	private int rent;

	public Territory(String fieldName, int fieldNumber, int price, int rent) {
		super(fieldName, fieldNumber, price);
		this.rent = rent;
	}

	@Override
	public int getRent() {
		return rent;
	}
}
