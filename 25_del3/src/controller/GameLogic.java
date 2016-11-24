package controller;

import boundary.Input;
import boundary.Output;
import entity.Cup;
import entity.Dice;
import entity.Player;
import entity.fields.*;
import java.util.*;

public class GameLogic {
    public static void main(String[] args) {
        // Opret Gameboard
        GameBoard gb = new GameBoard();
        // Spørg efter spillere
        Player[] players = GameCreator.createPlayers();
        // Put spillerne på gameboardet
        gb.setupPlayers(players);

        // Cuppen oprettes
        Cup shaker = new Cup(new Dice(), new Dice());

        int i = 0;
        Player currentPlayer = players[i];
        Field currentField = null;
        while (!currentPlayer.getWon()) {
            // Sæt currentPlayer til den nuværende spiller
            currentPlayer = players[i % players.length];

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

            // Giv turen videre
            i++;
        }


    }
}
