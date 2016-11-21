package entity.fields;
import entity.*;

public abstract class Ownable extends Field {
private int price;
protected Player owner;

public Ownable(String fieldname, int fieldnumber, int price){
	super(fieldname,fieldnumber);
	this.price=price;
}
public void landOnField(Player lander){
	if (owner==null){
		//GUI Med knapper og stuff skal implimenteres senere, måske GUI Statisk
		System.out.println("Ønsker du at købe feltet, det koster" + price + "kroner");
	    if(true){
	    //Hvis han vil købe den sættes lander til owner.
	    	owner=lander;
	    }
	}
	if(owner!=null){
		System.out.println("Du har landet på "+ owner + "'s felt, og betaler ham"+getRent());
	}
}
public abstract int getRent();
}
