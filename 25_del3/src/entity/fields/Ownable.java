package entity.fields;
import entity.*;

public abstract class Ownable extends Field {
private int price;
private Player owner;

public Ownable(String fieldname, int fieldnumber, int price){
	super(fieldname,fieldnumber);
	this.price=price;
}
public int getRent(){
	return price;
}
}
