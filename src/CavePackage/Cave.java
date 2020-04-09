package CavePackage;

import java.io.Serializable;

/**Класс пещера*/
public class Cave implements Serializable {
    /**Объем пещеры*/
    protected double volume;

    /**Количество входов в пещеру*/
    protected int numberOfEntries;

    /**Название пещеры*/
    protected String name;

    public Cave(){}

    public Cave(String name, double volume, int numberOfEntries) {
        this.volume=volume;
        this.numberOfEntries=numberOfEntries;
        this.name=name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
