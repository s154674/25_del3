package entity.fields;
import entity.*;
import java.util.*;

public class Fleet extends Ownable {
private int[] rent={500,1000,2000,4000};

public Fleet(String fieldname, int fieldnumber, int price){
	super(fieldname,fieldnumber,price);
}	

public int getRent(){
	return rent[fleetsOwned()];
}

private int fleetsOwned(){
	ArrayList<Field> kappa = owner.getProperties();
	int i;
	int Fleets=0;
	for (i=0;i<=kappa.size();i++){
		if (kappa.get(i) instanceof Fleet)
			Fleets++;
	}
	return Fleets;
}
}