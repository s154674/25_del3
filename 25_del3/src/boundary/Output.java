package boundary;

import desktop_resources.GUI;

public class Output {
public static void noBuy(){
	GUI.showMessage("Du valgte ikke at købe grunden");
}

public static void notEnough(){
	GUI.showMessage("Du har ikke råd til at købe grunden");
}

public static void payOwner(String lander, String owner, int price){
	GUI.showMessage(lander +" betaler " + owner + " " + price);
}
public static void landOnRefuge(String lander, int bonus){
	GUI.showMessage(lander + " får " + bonus);
}
public static void landOnTax(String lander, int payed){
	GUI.showMessage(lander + " betaler " + payed);
}
}
