package boundary;
import desktop_resources.GUI;

public class Input {

public static int getPlayers(){
	int antalSpillere = GUI.getUserInteger("Antal Spillere: ");
	return antalSpillere;
}

public static String[] getPlayerNames(int antalSpillere){
	String[] navne = new String[antalSpillere];
	int i;
	for (i=0 ; i<antalSpillere ; i++){
	navne[i] = GUI.getUserString("Indtast Spiller " + (i+1) + "'s navn: ");
	}
	return navne;
}

public static boolean getBuyChoice(int price){
	return GUI.getUserLeftButtonPressed("Ønsker du at købe denne grund for " + price , "Ja", "Nej");
}

public static boolean getTaxChoice(){
	return GUI.getUserLeftButtonPressed("Ønsker du at betale 4000 eller 10% af din formue?", "4000", "10%");
}

public static boolean getPlayAgain(){
	return GUI.getUserLeftButtonPressed("Ønsker i at spille igen?", "Ja", "Nej");
}

}
