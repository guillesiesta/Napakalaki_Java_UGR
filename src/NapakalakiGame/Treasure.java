
package NapakalakiGame;

import java.util.ArrayList;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class Treasure implements Card{
    
    //privates
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    
    //external privates
    private TreasureKind type;
    
    //constructor
    public Treasure(String n, int g, int min, int max, TreasureKind t){
        this.name=n;
        this.goldCoins=g;
        this.minBonus=min;
        this.maxBonus=max;
        this.type=t;
    }
    
    //gets
    public String getName(){return name;}
    public int getGoldCoins(){return goldCoins;}
    public int getMinBonus(){return minBonus;}
    public int getMaxBonus(){return maxBonus;}
    public TreasureKind getType(){return type;}
    
    //funciones interfaz
    public int getBasicValue(){
       return this.getMinBonus();
    }
    
    public int getSpecialValue(){
        return this.getMaxBonus();
    }
    
    public String toString() {
        return "\n\t\tName: " + name
                + ";\n\t\tgoldCoins: " + Integer.toString(goldCoins)
                + ";\n\t\tminBonus: " + Integer.toString(minBonus)
                + ";\n\t\tminBonus: " + Integer.toString(maxBonus)
                + ";\n\t\tminBonus: " + type.toString();
    }
}
