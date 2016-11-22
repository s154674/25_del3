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
		if (owner == null && lander.getBalance() > price) {
			// GUI Med knapper og stuff skal implimenteres senere, måske GUI
			// Statisk
			System.out.println("Ønsker du at købe feltet, det koster" + price + "kroner");
			if (true) {
				// Hvis han vil købe den sættes lander til owner.
				owner = lander;
				lander.getAccount().withdraw(price);
			}
		} else if (owner == null && lander.getBalance() < price) {
			System.out.println("Du har ikke råd");

		} else if (owner != null) {
			int rent = getRent();
			lander.getAccount().withdraw(rent);
			owner.getAccount().deposit(rent);
			// GUI besked der viser mængden af penge der er blevet flyttet
			System.out.println("Du har landet på " + owner + "'s felt, og betaler ham" + getRent());
		}
	}

	public abstract int getRent();

}
