package entity.fields;
import entity.*;
import java.util.*;

public class Fleet extends Ownable {
private int[] rent={500,1000,2000,4000};

public Fleet(String fieldName, int fieldNumber, int price){
	super(fieldName, fieldNumber, price);
}	

public int getRent(){
	return rent[fleetsOwned()];
}

private int fleetsOwned(){
	ArrayList<Ownable> properties = owner.getProperties();
	int camps=0;
	for (Ownable property: properties) {
		if (property instanceof Fleet)
			camps++;
	}
	return camps;
}
}