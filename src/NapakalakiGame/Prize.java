
package NapakalakiGame;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class Prize {
    
    //privates
    private int treasures;
    private int level;
    
    //constructor
    Prize(int treasures, int level){
        this.treasures=treasures;
        this.level=level;
    }
    
    //functions
    public int getTreasures(){return treasures;}
    public int getLevel(){return level;}
    
    //toString
    @Override
    public String toString(){
        return "\n\t\tTreasures = "+Integer.toString(treasures)+
                ";\n\t\tLevels = " + Integer.toString(level);
    }

   
}
