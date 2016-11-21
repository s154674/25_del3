package entity.fields;
import entity.*;

public class Tax extends Field {
private int taxAmount;
private int taxRate;

public Tax(String fieldname, int fieldnumber, int taxAmount){
	super(fieldname,fieldnumber);
	this.taxAmount=taxAmount;
}	

public void landOnField(Player lander){
	
}
}
