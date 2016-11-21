package entity;
import entity.fields.*;
import java.util.*;

public class Player {
	private String name;
	private boolean won;
	private Account account;
	private ArrayList<Field> properties = new ArrayList<Field>();

	public Player(String name, Account account) {
		this.name = name;
		this.account = account;
		this.won = false;
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
	
	public boolean addProperty(Field property){
		properties.add(property);
		return true;
	}
	
	public ArrayList<Field> getProperties(){
		return properties;
	}
}