package entity.fields;
import boundary.*;
import desktop_resources.GUI;
import entity.Player;

public abstract class Ownable extends Field {
	private int price;
	protected Player owner;

	public Ownable(String fieldName, int fieldNumber, int price) {
		super(fieldName, fieldNumber);
		this.price = price;
	}

	public void setOwner(Player buyer){
		owner = buyer;
	}
	public void removeOwner(){
		owner = null;
		Output.removeOwner(getNumber());
	}

	@Override
	public void landOnField(Player lander) {
		if (owner == null){
			if (lander.getBalance() > price){
				lander.buy(this);
			} else {
				Output.notEnough(lander.toString());
			}
		} else if (owner == lander) {
			Output.ownProperty(lander.toString());
		} else {
			int rent = this.getRent();
			lander.pay(rent, owner);
		}
	}

	public abstract int getRent();

	public int getPrice(){
		return price;
	}
}
