package boundary;
import desktop_codebehind.Car;
import desktop_fields.*;
import desktop_fields.Refuge;
import desktop_resources.GUI;
import entity.fields.*;
import entity.*;
import entity.fields.Field;

import java.awt.*;

public class FieldGenerator {

    public static void createPlayer(Color color, Player player){
        Car car = new Car.Builder().typeUfo().patternHorizontalDualColor().primaryColor(color).secondaryColor(Color.BLACK).build();
        GUI.addPlayer(player.toString(), player.getBalance(), car);
    }

    public static void createField(Field[] fields){
        desktop_fields.Field[] GUIFields = new desktop_fields.Field[40];
        int i;
        for (i=0;i<21;i++) {
            GUIFields[i] = new Street.Builder().setTitle(fields[i].getName()).setSubText("" + fields[i].getPrice()).build();
        }
        for (i =21; i < 39; i++) {
            GUIFields[i] = new Empty.Builder().build();
        }
        GUIFields[39] = new Street.Builder().setTitle("Start").setSubText("").setBgColor(Color.cyan).build();
        GUI.create(GUIFields);
    }
}
