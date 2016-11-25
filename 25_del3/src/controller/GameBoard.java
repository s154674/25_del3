package controller;

import boundary.FieldGenerator;
import boundary.Input;
import boundary.Output;
import entity.Account;
import entity.Player;
import entity.fields.*;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private Field[] fields = new Field[21];
    private Map<Player, Integer> map = new HashMap<Player, Integer>();
    public GameBoard(){
        //Territory objekterne bliver oprettet
        fields[0] = new Territory("Tribe Encampment", 1, 1000, 100);
        fields[1] = new Territory("Crater", 2, 1500, 300);
        fields[2] = new Territory("Mountain", 3, 2000, 500);
        fields[3] = new Territory("Cold Desert", 4, 3000, 700);
        fields[4] = new Territory("Black Cave", 5, 4000, 1000);
        fields[5] = new Territory("The Werewall", 6, 4300, 1300);
        fields[6] = new Territory("Mountain Village", 7, 4750, 1600);
        fields[7] = new Territory("South Citadel", 8, 5000, 2000);
        fields[8] = new Territory("Palace Gates", 9, 5500, 2600);
        fields[9] = new Territory("Tower", 10, 6000, 3200);
        fields[10] = new Territory("Castle", 11, 8000, 40000);

        //Refuge objekterne bliver oprettet
        fields[11] = new Refuge("Walled City",12, 5000);
        fields[12] = new Refuge("Monastery", 13, 500);

        //LaborCamp objekterne bliver oprettet
        fields[13] = new LaborCamp("Huts in the Mountain", 14, 2500, 100);
        fields[14] = new LaborCamp("The Pit", 15, 2500, 100);

        //Tax objekterne bliver oprettet
        fields[15] = new Tax("Goldmine", 16, 2000, -1);
        fields[16] = new Tax("Caravan", 17, 4000, 0);

        //Fleet objekterne bliver oprettet
        fields[17] = new Fleet("Second Sail", 18, 4000);
        fields[18] = new Fleet("Sea Grover", 19, 4000);
        fields[19] = new Fleet("The Buccaneers", 20, 4000);
        fields[20] = new Fleet("Privatee Armade", 21, 4000);

        FieldGenerator.createField(fields);
    }
    public void setupPlayers(Player[] players){
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], 1);
            Output.setCar(40, players[i].toString());
        }
    }
    public Field movePlayer(Player player, int n){
        Output.removeCar((40), player.toString());
        Output.removeCar((map.get(player)), player.toString());

        map.put(player, ((map.get(player) + n - 1) % fields.length)+1);
        Output.setCar(map.get(player), player.toString());
        return fields[map.get(player)-1];
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
