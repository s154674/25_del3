package boundary;

import desktop_resources.GUI;

public class Output {
    public static void noBuy(String lander) {
        GUI.showMessage(lander + " valgte ikke at købe grunden");
    }

    public static void notEnough(String lander) {
        GUI.showMessage(lander + " har ikke råd til at købe grunden");
    }

    public static void payOwner(String lander, String owner, int price) {
        GUI.showMessage(lander + " betaler " + owner + " " + price);
    }
    public static void bankrupt(String player){GUI.showMessage(player + " er gået bankerot.");}

    public static void ownProperty(String lander) {
        GUI.showMessage(lander + " landede på sit eget felt");
    }

    public static void payOwnerAndBankrupt(String lander, String owner, int left) {
        GUI.showMessage(lander + " er gået bankerot. " + owner + " får de " + left + " som " + lander + " havde.");
    }
    public static void removeOwner(int fieldNumber){
        GUI.removeOwner(fieldNumber);
    }

    public static void landOnRefuge(String lander, int bonus) {
        GUI.showMessage(lander + " får " + bonus);
    }

    public static void landOnTax(String lander, int payed) {
        GUI.showMessage(lander + " betaler " + payed);
    }

    public static void setDice(int a, int b) {
        GUI.setDice(a, b);
    }

    public static void setCar(int placement, String player) {
        GUI.setCar(placement, player);
    }

    public static void removeCar(int placement, String player) {
        GUI.removeCar(placement, player);
    }

    public static void updateAccount(String player, int balance) {
        GUI.setBalance(player, balance);
    }

    public static void setOwner(int fieldNumber, String player) {
        GUI.setOwner(fieldNumber, player);
    }

    public static void closeGui() {
        GUI.close();
    }
}
