package DragonPackage;

import java.io.Serializable;

/**Класс, описывающий дракона*/
public class Dragon implements Serializable {
    /**Имя дракона*/
    private String name;

    /**Рост дракона*/
    private int height;

    /**Количество голов у дракона*/
    private int numberOfHeads;

    /**Флаг на то,спит ли дракон*/
    private boolean isSleeping;

    public Dragon(String name, int height, int numberOfHeads) {
        this.name=name;
        this.height=height;
        this.numberOfHeads=numberOfHeads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumberOfHeads() {
        return numberOfHeads;
    }

    public void setNumberOfHeads(int numberOfHeads) {
        this.numberOfHeads = numberOfHeads;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }

    /**Дракон засыпает*/
    public void sleep() {
        if (isSleeping==true) {
            System.out.println("DragonPackage.Dragon is already sleeping!");
        } else {
            isSleeping=true;
            System.out.println("DragonPackage.Dragon is sleeping now!");
        }
    }

    /**Дракон просыпается*/
    public void wakeUp() {
        if (isSleeping==false) {
            System.out.println("DragonPackage.Dragon is not sleeping!");
        } else {
            isSleeping=false;
            System.out.println("DragonPackage.Dragon waked up!");
        }
    }

    /**Дракон дышит огнем*/
    public void breatheFire() {
        System.out.println("DragonPackage.Dragon is fire breathing!");
    }
}
