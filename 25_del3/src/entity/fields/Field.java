package entity.fields;

import entity.*;

public abstract class Field {
    private String fieldName;
    private int fieldNumber;

    public Field(String fieldName, int fieldNumber) {
        this.fieldName = fieldName;
        this.fieldNumber = fieldNumber;
    }

    public abstract void landOnField(Player lander);

    public String getName() {
        return fieldName;
    }

    public int getNumber() {
        return fieldNumber;
    }


    public abstract int getPrice();
}