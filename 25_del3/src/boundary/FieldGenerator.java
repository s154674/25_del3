package boundary;
import desktop_codebehind.Car;
import desktop_fields.Street;
import desktop_resources.GUI;
import entity.fields.*;
import entity.*;

import java.awt.*;

public class FieldGenerator {

    public static void createPlayer(Color color, Player player){
        Car car = new Car.Builder().typeUfo().patternHorizontalDualColor().primaryColor(color).secondaryColor(Color.BLACK).build();
        GUI.addPlayer(player.toString(), player.getBalance(), car);
    }

    public static void createField(Field[] fields){
        new Street.Builder().setTitle(title).setSubText(""+price).build();
        GUI.create(fields);
    }
}
