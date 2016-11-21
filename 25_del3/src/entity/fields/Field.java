package entity.fields;
import entity.*;

public abstract class Field {
private String fieldname;
private int fieldnumber;

public Field (String fieldname, int fieldnumber){
	this.fieldname=fieldname;
	this.fieldnumber=fieldnumber;
}
public abstract void landOnField(Player lander);
}
