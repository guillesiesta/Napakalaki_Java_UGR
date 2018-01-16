
package NapakalakiGame;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class Monster implements Card{
    
    //privates
    private String name ="";
    private int combatLevel=0;
    private int levelChangeAgainstCultistPlayer;
    
    //external privates
    private Prize prize=null;
    private BadConsequence badConsequence = null;

    //constructor
    Monster(String n, int l, BadConsequence b, Prize p, int levelchange){
        this.name=n;
        this.combatLevel=l;
        this.badConsequence=b;
        this.prize=p;
        this.levelChangeAgainstCultistPlayer = levelchange;
    }

    //functions
    public String getName(){return this.name;}
    public int getCombatLevel(){return this.combatLevel;}
    public BadConsequence getBadConsequence(){return this.badConsequence;}
    public int getLevelsGained(){return this.prize.getLevel();}
    public int getTreasuresGained(){return this.prize.getTreasures();}
    public boolean kills(){return this.badConsequence.myBadConsequeseIsDeath();}
    public Prize getPrize() {
        return prize;
    }
    public int getLevelChangeAgainstCultistPlayer(){
        return this.levelChangeAgainstCultistPlayer;
    }
    
    //funciones interfaz
    public int getBasicValue(){
        return this.getCombatLevel() + this.getLevelChangeAgainstCultistPlayer();
    }
    
    public int getSpecialValue(){
        return this.getLevelsGained();
    }
    //toStrings
    @Override
    public String toString(){
        return "\nName: "+name+
                ";\n\tCombatLevel: "+Integer.toString(combatLevel)+
                ";\n\tPrize: "+prize.toString()+
                ";\n\tBadConsecuence: "+badConsequence.toString()+";";
    }
}
