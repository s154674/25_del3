package entity.fields;
import entity.*;

public class Refuge extends Field {
private int bonus;

public Refuge(String fieldname, int fieldnumber, int bonus){
	super(fieldname,fieldnumber);
	this.bonus=bonus;
}	

public void landOnField(Player p){
	
}
}
