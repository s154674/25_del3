package controller;

import boundary.FieldGenerator;
import boundary.Input;
import boundary.Output;
import entity.Account;
import entity.Cup;
import entity.Dice;
import entity.Player;
import entity.fields.*;

import java.awt.Color;
import java.util.*;

public class GameLogic {
    public static void main(String[] args) {
        boolean play = true;

        while (play) {
            // Opret Gameboard
            GameBoard gb = new GameBoard();
            // Spørg efter spillere
            Player[] players = createPlayers();
            // Put spillerne på gameboardet
            gb.setupPlayers(players);

            // Cuppen oprettes
            Cup shaker = new Cup(new Dice(), new Dice());

            int i = 0;
            Player currentPlayer = players[i];
            Field currentField = null;
            while (!isGameOver(players)) {
                // Sæt currentPlayer til den nuværende spiller
                currentPlayer = players[i % players.length];

                // Hvis spilleren ikke er bankerot...
                if (!currentPlayer.getBroke()) {
                    // Spil turen
                    Input.startTurn(currentPlayer.toString());
                    shaker.rollAll();
                    Output.setDice(shaker.values()[0], shaker.values()[1]);

                    // Placer spilleren rigtigt
                    currentField = gb.movePlayer(currentPlayer, shaker.getSum());
                    currentField.landOnField(currentPlayer);

                    // Opdater accounts
                    for (int j = 0; j < players.length; j++) {
                        Output.updateAccount(players[j].toString(), players[j].getBalance());
                    }
                }
                // Giv turen videre
                i++;

            }
            play = Input.winnerIsPlayAgain(findWinner(players).toString());
            Output.closeGui();
        }

    }
    private static boolean isGameOver(Player[] players){
        int left = players.length;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getBroke())
                left-=1;
        }
        System.out.println(left + " spillere tilbage");
        return (left==1);
    }
    private static Player findWinner(Player[] players){
        for (int i = 0; i < players.length; i++) {
            if (!players[i].getBroke())
                return players[i];
        }
        return null;
    }
    public static Player[] createPlayers(){
        Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW};
        int amount = Input.getPlayers();
        String[] names = Input.getPlayerNames(amount);
        Player[] players = new Player[amount];

        for (int i=0;i<amount;i++){
            players[i]= new Player(names[i], new Account(30000));
            FieldGenerator.createPlayer(colors[i],players[i]);
        }
        return players;
    }
}
