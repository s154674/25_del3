package entity.fields;

import entity.Player;

public abstract class Ownable extends Field {
	private int price;
	protected Player owner;

	public Ownable(String fieldname, int fieldnumber, int price) {
		super(fieldname, fieldnumber);
		this.price = price;
	}

	@Override
	public void landOnField(Player lander) {
		if (owner == null || lander.getBalance() > price) {
			// GUI Med knapper og stuff skal implimenteres senere, måske GUI
			// Statisk
			System.out.println("Ønsker du at købe feltet, det koster" + price + "kroner");
			if (true) {
				// Hvis han vil købe den sættes lander til owner.
				owner = lander;
				lander.getAccount().withdraw(price);
			}
		} else {
			// GUI der siger spilleren ikke har nok penge til at købe feltet.
		}

		if (owner != null) {
			System.out.println("Du har landet på " + owner + "'s felt, og betaler ham" + getRent());
		}
	}

	public abstract int getRent();
}
