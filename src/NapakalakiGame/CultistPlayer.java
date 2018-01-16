/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class CultistPlayer extends Player {
    
    //Atributo
    static int totalCultistPlayer ;
    
    //Atributo externo
    Cultist myCultistCard = null;
    
    //constructor que llama al constructor de la clase player
    public CultistPlayer(Player p, Cultist carta){
        super(p);
        myCultistCard = carta;
        totalCultistPlayer++;
    }
    
    public static int getTotalCultistPlayer(){
        return totalCultistPlayer;
    }
    
    public Cultist getCultist(){
        return this.myCultistCard;
    }
    
    @Override
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevel();
    }

    @Override
    protected boolean shouldConvert()
    {   //Tiene que devolver siempre false
        return false;
    }

    @Override
     protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        /* Recorrer el array de treasures. Y por cada treasure sacar el goldcoins y sumarlo a total
            y luego dividirlo entre 1000*/
        return super.computeGoldCoinsValue(t) *2;
    }
}
