/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NapakalakiGame;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class Cultist implements Card{
    
    private String name;
    private int gainedLevels;
    
    
    //funciones
    public int getGainedLevels(){
        return this.gainedLevels;
    }
    public String getName(){
        return this.name;
    }
    //funciones interfaz
    public int getBasicValue(){
        return this.getGainedLevels();
    }
    
    public int getSpecialValue(){
        return CultistPlayer.getTotalCultistPlayer() * this.getBasicValue();
        
    }
    
    public Cultist(String n, int gl){
        this.name = n;
        this.gainedLevels = gl;
    }
    
    public String toString(){
        return "\n\t\tName: " + name
                + ";\n\t\tgainedLevels: " + Integer.toString(this.gainedLevels);
    
    }
    
}
