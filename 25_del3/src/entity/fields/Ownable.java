package entity.fields;
import boundary.*;
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
			boolean ans;
			ans=Input.getBuyChoice(price);
			if (ans==true) {
				// Hvis han vil købe den sættes lander til owner.
				owner = lander;
				lander.getAccount().withdraw(price);
				lander.getProperties().add(this);
			} else if (ans==false){
				Output.noBuy();
			}
		} else if (owner == null && lander.getBalance() < price) {
			Output.notEnough();

		} else if (owner != null) {
			int rent = this.getRent();
			lander.getAccount().withdraw(rent);
			owner.getAccount().deposit(rent);
			Output.payOwner(owner.toString(), rent);
		}
	}

	public abstract int getRent();

	public int getPrice(){
		return price;
	}
}
