/**
 *
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
package NapakalakiGame;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Test.GameTester;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebaNapakalaki {
    
    public static void main(String[] args) {
        /*Napakalaki napakalakiModel = Napakalaki.getInstance();
        
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        napakalakiView.setNapakalaki(napakalakiModel);
        
        ArrayList<String> names = new ArrayList();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
               
        napakalakiView.showView();*/
        
        ArrayList<String>names=new ArrayList();//error
        Napakalaki napakalakiModel=Napakalaki.getInstance();
        NapakalakiView napakalakiView=new NapakalakiView();
        Dice.createInstance(napakalakiView);
        Napakalaki game = Napakalaki.getInstance();
        GameTester test = GameTester.getInstance();
        PlayerNamesCapture namesCapture=new PlayerNamesCapture(napakalakiView,true);
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalakiModel(napakalakiModel);
        napakalakiView.showView();
        // Poner el numero de jugadores con el que se quiera probar
        test.play(game, 3);
        
    }

    
}
