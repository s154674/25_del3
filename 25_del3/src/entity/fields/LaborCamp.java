package entity.fields;
import entity.*;

public class LaborCamp extends Ownable {
private int baserent;

public LaborCamp(String fieldname, int fieldnumber, int price,int baserent){
	super(fieldname,fieldnumber,price);
	this.baserent=baserent;
}	

public void landOnField(Player p){
	
}
}
