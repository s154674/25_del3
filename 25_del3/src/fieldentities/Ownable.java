package fieldentities;
import entity.*;

public abstract class Ownable extends Field {
private int price;
private Player owner;

public int getRent(){
	return price;
}
}
