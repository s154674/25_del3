package entity;

import java.util.ArrayList;
import java.util.Properties;

import boundary.Input;
import boundary.Output;
import entity.fields.Field;
import entity.fields.Ownable;

public class Player {
	private String name;
	private boolean won;
	private boolean broke;
	private Account account;
	private ArrayList<Ownable> properties = new ArrayList<Ownable>();

	public Player(String name, Account account) {
		this.name = name;
		this.account = account;
		this.won = false;
		this.broke = false;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getBalance() {
		return account.getBalance();
	}

	public Account getAccount() {
		return account;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public boolean getWon() {
		return won;
	}

	public boolean getBroke() {
		return broke;
	}

	public void setBroke(boolean broke) {
		this.broke = broke;
	}

	public void pay(Player player, int amount){
		if (getBalance()>=amount){
			account.withdraw(amount);
			player.getAccount().deposit(amount);
			Output.payOwner(this.toString(),player.toString(), amount);
		} else {
			int left = account.getBalance();
			player.getAccount().withdraw(left);
			player.getAccount().deposit(left);
			bankrupt();
			Output.payOwnerAndBankrupt(this.toString(), player.toString(), amount);
		}
	}
	public void buy(Ownable property){
		if (Input.getBuyChoice(property.getPrice())) {
			// Hvis han vil købe den sættes lander til owner.
			property.setOwner(this);
			getAccount().withdraw(property.getPrice());
			addProperty(property);
			Output.setOwner(property.getNumber(), this.toString());
		} else{
			Output.noBuy(this.toString());
		}
	}
	private void bankrupt(){
		broke = true;
		for (Ownable property: properties) {
			property.removeOwner();
		}
		properties = null;
	}

	public void addProperty(Ownable property) {
		properties.add(property);
	}

	public ArrayList<Ownable> getProperties() {
		return properties;
	}
}