
package NapakalakiGame;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
import java.util.ArrayList;

public class BadConsequence {
    
    //private variables
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;

    //external private variables
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    //constructor
    public BadConsequence(String t, int l, int nVisible, int nHidden) {
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        this.text = t;
        this.levels = l;
        this.specificVisibleTreasures = v;
        this.specificHiddenTreasures = h;
    }
    public BadConsequence(String t, boolean death) {
        this.text = t;
        this.death = death;
    }
    
    //functions
    public boolean isEmpty () {
        return (nVisibleTreasures==0 && nHiddenTreasures==0 && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty());
    }
    public int getLevels() {return this.levels;}
    
    public int getnVisibleTreasures() {return this.nVisibleTreasures;}
    
    public int getnHiddenTreasures() {return this.nHiddenTreasures;}
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){return this.specificHiddenTreasures;}
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){return this.specificVisibleTreasures;}
    
    public void substractVisibleTreasure(Treasure t){
        if (specificVisibleTreasures.contains(t.getType())){
            specificVisibleTreasures.remove(t.getType());
        }else {
            if (nVisibleTreasures>0) nVisibleTreasures--;
        }
    }
    public void substractHiddenTreasure(Treasure t){
        if (specificHiddenTreasures.contains(t.getType())){
            specificHiddenTreasures.remove(t.getType());
        }else{
            if (nHiddenTreasures>0) nHiddenTreasures--;
        }
    }


    //functions
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
    /*Recibe como parámetros los tesoros visibles y ocultos de los que dispone el jugador y
devuelve un nuevo objeto mal rollo que contiene una lista de tipos tesoros visibles y
ocultos de los que el jugador debe deshacerse.
El objeto de mal rollo devuelto por
adjustToFitTreasureLists
solo contendrá tipos de tesoros y en una cantidad
adecuada a los que el jugador puede llegar a deshacerse en función de los que dispone. */
        ArrayList<TreasureKind> tv = new ArrayList();
        ArrayList<TreasureKind> th = new ArrayList();
        for(int i=0; i<v.size(); i++){
            tv.add(v.get(i).getType());
        }
        
        for(int j=0; j<h.size(); j++){
            th.add(h.get(j).getType());
        }
        
        BadConsequence b = new BadConsequence("",0,tv,th);
        return b;
   
    }
    
    public boolean myBadConsequeseIsDeath(){return death;}
    
    //toString
    @Override
    public String toString() {
        return "\n\t\tText: " + text
                + ";\n\t\tLevels: " + Integer.toString(levels)
                + ";\n\t\tNVisibleTreasures: " + Integer.toString(nVisibleTreasures)
                + ";\n\t\tNHiddenTreasures: " + Integer.toString(nHiddenTreasures)
                + ";\n\t\tDeath: " + death
                + ";\n\t\tSpecificVisibleTreasures: " + specificVisibleTreasures.toString()
                + ";\n\t\tSpecificHiddenTreasures: " + specificHiddenTreasures.toString();
    }

    public String getText() {
        return text;
    }
}
