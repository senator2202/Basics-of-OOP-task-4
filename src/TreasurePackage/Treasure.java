package TreasurePackage;

import java.io.Serializable;

/*Класс сокровищ*/
public class Treasure implements Serializable {
    /**Стоимость сокровища */
    private int value;

    /**Тип скоровища*/
    TreasureType treasureType;

    public Treasure(TreasureType treasureType, int value) {
        this.treasureType=treasureType;
        this.value=value;
    }

    @Override
    public String toString() {
        return "type of treasure - "+treasureType+"; treasure value - "+value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
