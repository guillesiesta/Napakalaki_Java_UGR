package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class Player {

    //privates
    private boolean dead=true;
    private String name ="";
    private int level=1;

    //external privates
    private BadConsequence pendingBadConsequence =null;
    private ArrayList <Treasure> visibleTreasures = new ArrayList();
    private ArrayList <Treasure> hiddenTreasures = new ArrayList();
    private CombatResult combatResult = null;
    private Dice dice=Dice.getInstance();
    
    //constructor
    Player(String name){
        this.name=name;
    }
    //constructor de copia
    public Player(Player p)
    {
        this.combatResult=p.combatResult;
        this.dead=p.dead;
        this.dice=p.dice;
        this.visibleTreasures= new ArrayList<>(p.visibleTreasures);
        this.hiddenTreasures= new ArrayList<>(p.hiddenTreasures);
        this.level=p.level;
        this.name=p.name;
        this.pendingBadConsequence=p.pendingBadConsequence;
    }
    
    //p5 functions
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevel();
    }
    protected boolean shouldConvert()
    {   /*//▪ ha perdido el combate contra un monstruo y no ha conseguido huir, pero no muere al aplicarse el “mal rollo”, y
        //▪ al tirar de nuevo el dado, obtiene un 6.
        return (this.combatResult==CombatResult.Lose && this.dice.nextNumber()==6);*/
        return this.dice.nextNumber()==6;
    }
    //functions
    public CombatResult getCombatresult() {
        return combatResult;
    }
    public String getName () {
        return this.name;
    }
    public void setLevel(int l){
        this.level = l;
    }
    private void bringToLife(){
        this.dead=false;
    }
    public boolean getDead(){
        return dead;
    }
    protected int getCombatLevel(){
        int bonus = 0;
        if(this.visibleTreasures.size()>0){
            for(int i=0; i< this.visibleTreasures.size(); i++ )
                if(this.visibleTreasures.get(i).getType() == TreasureKind.NECKLACE ){
                    bonus = bonus + this.visibleTreasures.get(i).getMaxBonus();
                }else{
                    bonus = bonus + this.visibleTreasures.get(i).getMinBonus();
                }
        }
        return bonus;
    }
    private void incrementLevels(int l){
     if(canIBuyLevels(l)==true)
            if(this.level<=10)
               this.level=this.level+l;
    }
    
    private void decrementLevels(int l){
        if((this.level - l) < 0){
            this.level = 1;
        }else{
            this.level = this.level - l;
        }
        
    }
    private void setPendingBadConsequence(BadConsequence b){this.pendingBadConsequence=b;}
    public boolean isDead(){return this.dead;}
    public ArrayList<Treasure> getHiddenTreasures(){return this.hiddenTreasures;}
    public ArrayList<Treasure> getVisibleTreasures(){return this.visibleTreasures;}
    public int getLevels(){return this.level;}
    
    private void dieIfNoTreasures(){ 
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()){
            this.dead = true;
        }            
    }
    private void discardNecklaceIfVisible(){
        
        for(int i=0; i <this.visibleTreasures.size(); i++){
            if(this.visibleTreasures.get(i).getType() == TreasureKind.NECKLACE ){
                this.visibleTreasures.remove(i);
                break;
            }
        }
        
        
    }
    private void die(){
        /*Cuando el jugador muere en un combate, esta operación es la encargada de dejarlo sin
tesoros, ponerle el nivel a 1 e indicar que está muerto, en el atributo correspondiente*/
        this.setLevel(1);
        
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        
        for(int i=0; i<this.visibleTreasures.size(); i++){
            dealer.giveTreasureBack(this.visibleTreasures.get(i));
        }
        this.visibleTreasures.clear();
        
        for(int i=0; i<this.hiddenTreasures.size(); i++){
            dealer.giveTreasureBack(this.hiddenTreasures.get(i));
        }
        this.hiddenTreasures.clear();
        
        dieIfNoTreasures();
    
    }
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        /* Recorrer el array de treasures. Y por cada treasure sacar el goldcoins y sumarlo a total
            y luego dividirlo entre 1000*/
        float total=0;
        for(int i=0; i<t.size(); i++){
            total = total + t.get(i).getGoldCoins();
        }
        
        return total/1000;
    }
    
    private boolean canIBuyLevels(int lev){
        /*Devuelve true si con los niveles que compra no gana la partida y false 
        en caso contrario*/
    
        if((lev+this.level)>=10){
            return false;
        }else{
            return true;
        }
    }
    
    private void applyPrize(Monster currentMonster){
        /*Cuando el jugador gana el combate, esta operación es la encargada de aplicar el buen
rollo al jugador, sumando los niveles correspondiente y robando los tesoros indicados en el
buen rollo del monstruo*/
        
        incrementLevels(currentMonster.getLevelsGained());
        int nTreasures = currentMonster.getTreasuresGained();
        
        if(nTreasures > 0){
            CardDealer dealer ;
            dealer = CardDealer.getInstance();
            Treasure treasure;
            for(int i=0; i<nTreasures; i++){
                treasure = dealer.nextTreasure();
                this.hiddenTreasures.add(treasure);
            }
        }       
        
    }
    private void applyBadConsequence(BadConsequence bad){
        
        int nLevels = bad.getLevels();
        decrementLevels(nLevels);
        
        BadConsequence pendingbad;
        pendingbad = bad.adjustToFitTreasureLists(this.visibleTreasures, this.hiddenTreasures);
        
        setPendingBadConsequence(pendingbad);
    }
    
    
    private boolean canMakeTreasureVisible(Treasure t){
        
        /*Cada jugador, podría equiparse en el mejor de los casos:
        
        1.- Armadura, un tesoro 2 manos, casco, calzado y collar
        
        2.- Armadura, dos tesoros 1 mano. casco, calzado y collar*/
        
        /*Si el tipo es armadura, miro a ver si tiene ya alguna armadura equipada*/
        int contador = 0;
        for(int i = 0; i < this.visibleTreasures.size(); i++){
            if(this.visibleTreasures.get(i).getType() == t.getType())
                contador++;
            if(t.getType()==TreasureKind.ONEHAND){
                if(this.visibleTreasures.get(i).getType() == TreasureKind.BOTHHAND)
                    return false;
                    }
            if(t.getType()==TreasureKind.BOTHHAND){    
                if(this.visibleTreasures.get(i).getType() == TreasureKind.ONEHAND)
                    return false;
            }
        }
        return contador < 1 || (t.getType() == TreasureKind.ONEHAND && contador < 2 );
    }
    private int howManyVisibleTreasures(TreasureKind tkind){
        int total=0;
        for(int i=0; i< this.visibleTreasures.size(); i++){
            if(this.visibleTreasures.get(i).getType()== tkind){
                total++;
            }
        }
        return total;
    }
    
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        //System.out.println(monsterLevel);
        //int monsterLevel = m.getCombatLevel();
        
        if(myLevel > monsterLevel){
            applyPrize(m);
            if(this.level >=10){
                this.combatResult = CombatResult.WinAndWinGame;
            }else{
                this.combatResult = CombatResult.Win;
            }
        }else{
            dice = Dice.getInstance();
            int escape = dice.nextNumber();
            
            if(escape>5){
                boolean amIDead = m.kills();
                BadConsequence bd = new BadConsequence("",true);
                bd.myBadConsequeseIsDeath();
                
                if(amIDead = true){
                    die();
                    this.combatResult = CombatResult.LoseAndDie;
                }else{
                    if(escape==6){
                        BadConsequence bad = m.getBadConsequence();
                        if(this.shouldConvert()==true){
                            this.combatResult = CombatResult.LoseAndConvert;
                        }
                        this.applyBadConsequence(bad);
                    }else{
                        BadConsequence bad = m.getBadConsequence();
                        this.combatResult = CombatResult.Lose;
                        this.applyBadConsequence(bad);
                    }
                }
            
            }else{
                this.combatResult = CombatResult.LoseAndEscape;
            }
            
        }
        
    
        this.discardNecklaceIfVisible();
        
        
        return combatResult;
        
    }
    public void makeTreasureVisible(Treasure t){
        boolean canI=this.canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        this.visibleTreasures.remove(t);
        
        if((pendingBadConsequence!= null) && (!pendingBadConsequence.isEmpty())){
            this.pendingBadConsequence.substractVisibleTreasure(t);
            
        }
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        this.hiddenTreasures.remove(t);
    }
    
    public boolean buyLevels( ArrayList<Treasure> visible, ArrayList<Treasure> hidden ){
        boolean canI;
        float levelsMayBought = this.computeGoldCoinsValue(visible);
        levelsMayBought += computeGoldCoinsValue(hidden);
        int levels = (int)(levelsMayBought);
        canI = canIBuyLevels(levels);
        
        if(canI){
            incrementLevels(levels);
        }
        
        this.visibleTreasures.removeAll(visible);
        this.hiddenTreasures.removeAll(hidden);
        
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        
        for(int i=0; i<visible.size(); i++){
            Treasure treasure;
            treasure=visible.get(i);
            dealer.giveTreasureBack(treasure);
        }
        
        for(int j=0; j<hidden.size(); j++){
            Treasure treasure;
            treasure=hidden.get(j);
            dealer.giveTreasureBack(treasure);
        }
        
        return true;
    }
    
    
    
    public boolean validState(){
    /*Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir 
        (pendingBadSConsequece.isEmpty() == true) y no tiene más de 4 tesoros
        ocultos y false en caso contrario.*/
       
        if((this.pendingBadConsequence==null || this.pendingBadConsequence.isEmpty()== true) && (this.hiddenTreasures.size()<=4) ){
            return true;
        }else{
            return false;
        }
        
    
    }
    public void initTreasures(){       
       CardDealer dealer;
       dealer  = CardDealer.getInstance();
       
       dice = Dice.getInstance();
       
       this.bringToLife();
       
       hiddenTreasures.add(dealer.nextTreasure());
       
       /*RETOCADO AQUIIIIII---------------------------------------------------------------------------->>*/
       //Random r = new Random();
       //int number = r.nextInt(6)+1;
       int number = dice.nextNumber();
       
       if(number>1){
           this.hiddenTreasures.add(dealer.nextTreasure());
       }
       
       if(number ==6 ){
           this.hiddenTreasures.add(dealer.nextTreasure());
       }
               
               
    }
    public boolean hasVisibleTreasures(){
        if(this.visibleTreasures.size()>0){
            return true;
        }else{
            return false;
        }
    }
    
    public String toString() {
        return "\n\t\tName: " + name
                + ";\n\t\tLevel: " + Integer.toString(level)
                + ";\n\t\tDead: " + Boolean.toString(dead);
    }
    
    
}
