package CavePackage;

import DragonPackage.Dragon;
import TreasurePackage.Treasure;
import TreasurePackage.TreasureType;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**Класс пещера дракона, наследуумый от класса пещера*/
public class DragonCave extends Cave implements Serializable {
    /**Дракон в пещере*/
    Dragon dragon;

    /**100 сокровищ в пещере*/
    Treasure[]treasures=new Treasure[100];

    /**Если создаем объект без параметров, то читаем его параметры из файла*/
    public DragonCave() {
        readFromFile();
    }

    /**Если создаем новую пещеру дракона, то перезаписываем файл для последующего чтения*/
    public DragonCave(String name, double volume, int numberOfEntries, Dragon dragon) {
        super(name,volume,numberOfEntries);
        this.dragon=dragon;
        initializeTreasures();
        writeToFile();
    }

    /**Метод main() - точка входа в программу, демонстрация работы с подземельем дракона*/
    public static void main(String []args) {
        String[] dragonNames = {"Dino", "Godzilla", "Roberto", "Gorynych"};
        String[] caveNames = {"Lazarus", "Eastwood", "Badabum", "Texas"};
        Dragon dr=null;
        DragonCave drc=null;
        Scanner scanner = new Scanner(System.in);
        String menu = "\n1-Create new dragon cave\n" +
                "2-read dragon cave from file\n" +
                "0-exit";
        System.out.println(menu);
        int choise = scanner.nextInt();
        if (choise == 1) {
            Random r = new Random();
            dr = new Dragon(dragonNames[r.nextInt(4)],
                    r.nextInt(200) + 400,
                    r.nextInt(2) + 1);
            drc = new DragonCave(caveNames[r.nextInt(4)],
                    r.nextInt(300) + 500,
                    r.nextInt(3) + 1, dr);
        } else if (choise == 2) {
            drc = new DragonCave();
        }
        else if (choise==0)
            System.exit(0);

        menu="\n1-detailed info about dragon cave" +
                "\n2-show treasure with max value" +
                "\n3-show treasure with defenite value" +
                "\n0-exit";
        System.out.println(menu);
        choise = scanner.nextInt();
        while (choise!=0) {
            if (choise == 1) {
                System.out.println(drc);
            } else if (choise == 2) {
                System.out.println(drc.getMaxTreasure());
            }
            else if (choise==3) {
                System.out.println("Enter treasure value: ");
                int temp= scanner.nextInt();
                System.out.println(drc.getTreasureByValue(temp));
            }
            else if (choise==0)
                System.exit(0);

            System.out.println(menu);
            choise = scanner.nextInt();
        }
    }

    /**рандомная инициализация полей класса DragonCave*/
    private void initializeTreasures() {
       for (int i=0;i<treasures.length;i++) {
           Random r=new Random();
           TreasureType treasureType= TreasureType.Gold;
           switch (r.nextInt(3)){
               case 1: treasureType=TreasureType.Diamond;
                   break;
               case 2: treasureType=TreasureType.Mixed;
                   break;
           }
           treasures[i]=new Treasure(treasureType,r.nextInt(900)+100);
       }
   }

   /**Запись объекта в файл*/
    private void writeToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("DragonCave.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**Чтение объекта из файла*/
    private void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("DragonCave.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            DragonCave drc=(DragonCave)oin.readObject();
            this.dragon=drc.dragon;
            this.treasures=drc.treasures;
            this.volume=drc.volume;
            this.name=drc.name;
            this.numberOfEntries=drc.numberOfEntries;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**Вся информация про пещеру дракона, включая самого дракона и все сокровища*/
    @Override
    public String toString() {
        String res= "";
        res="Cave parametres:\nname: "+name+"; volume: "+volume+"; number of entries: "+numberOfEntries+"\n";
        res=res+"DragonPackage.Dragon characteristics:\nname: "+dragon.getName()+"; number of heads: "+dragon.getNumberOfHeads()+"; height: "+dragon.getHeight()+"\n";
        res=res+"Treasures of the cave:\n\n";
        for(int i=0;i<treasures.length;i++) {
            res=res+"treasure "+(i+1)+": "+treasures[i].toString()+"\n";
        }
        return res;
    }

    /**Возвращает сокровище с наибольшей ценностью*/
    public String getMaxTreasure(){
        int max=0;
        for(int i=1;i<treasures.length;i++) {
            if(treasures[i].getValue()>treasures[max].getValue()) {
                max=i;
            }
        }
        return "Treasure with max value:\n"+"treasure "+(max+1)+": "+treasures[max].toString();
    }

    /**Возвращает сокровище с заданной стоимостью*/
    public String getTreasureByValue(int value) {
        String res= "";
        for(int i=1;i<treasures.length;i++) {
            if(treasures[i].getValue()==value) {
                res=res+"Treasure with value "+value+":\n"+"treasure "+(i+1)+": "+treasures[i].toString()+"\n";
            }
        }
        return res;
    }
}
