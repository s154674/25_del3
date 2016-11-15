package entity.fields;
import entity.*;

public class Fleet extends Ownable {
private int RENT_1 = 500;
private int RENT_2 = 1000;
private int RENT_3 = 2000;
private int RENT_4 = 4000;

public Fleet(String fieldname, int fieldnumber, int price){
	super(fieldname,fieldnumber,price);
}	

public void landOnField(Player p){
	
}
}
