package boundary;
import desktop_resources.GUI;

public class Input {

public static int getPlayers(){
	int antalSpillere;
	while (true){
		try {
			antalSpillere = GUI.getUserInteger("Antal Spillere: ");
			return antalSpillere;
		} catch (NumberFormatException e){
			GUI.showMessage("Du skal indtaste et tal");
		}
	}
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
public static void startTurn(String player){ GUI.showMessage(player + "'s tur"); }

public static boolean winnerIsPlayAgain(String player){
	return GUI.getUserLeftButtonPressed(player + " vandt! spil igen?", "Ja", "Nej");
}

}
