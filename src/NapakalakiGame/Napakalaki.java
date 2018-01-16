
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class Napakalaki {
    
    //privates
    private static final Napakalaki instance= new Napakalaki();
    
    //external privates
    private Monster currentMonster = null;
    private Player currentPlayer = null;
    private ArrayList<Player> players =new ArrayList();
    private CardDealer dealer = CardDealer.getInstance();
    private CombatResult resultado = CombatResult.Lose;
    
    //constructor
    private Napakalaki(){
        currentMonster = null;
        currentPlayer = null;
        players = new ArrayList();
        dealer = CardDealer.getInstance();
    }
    
    //functions
    private void initPlayers(ArrayList<String> names){      //acabado
        for (String n: names){
            players.add(new Player(n));
        }
    }
    private Player nextPlayer(){    //acabado
        Player next_player;
        if (currentPlayer == null){          //si el juego no ha empezado currentPlayer=null
            Collections.shuffle(players);    //shufle de jugadores
            next_player = players.get(0);    //el siguiente jugador es players.get(0)
        }else{
            int iNP = (players.indexOf(currentPlayer)+1)%players.size();  //indiceNextPlayer = <indice_jugador_actual)>+1 y le hago el modulo
            next_player = players.get(iNP);
        }
        currentPlayer = next_player;
        return next_player;
    }
    
    private boolean nextTurnAllowed(){
        if(currentPlayer==null){
            return true;
        }else{
        return currentPlayer.validState();
        }
    }
    
    public static Napakalaki getInstance (){return instance;}
    public CombatResult developCombat(){
        
        CombatResult c = currentPlayer.combat(currentMonster);
        this.dealer.giveMonsterBack(currentMonster);
        resultado=c;
        
        if(resultado == CombatResult.LoseAndConvert){
            //this.dealer.nextCultist();
            CultistPlayer cp = new CultistPlayer(this.getCurrentPlayer(), this.dealer.nextCultist());
            players.remove(this.currentPlayer);
            this.currentPlayer = cp;
            players.add(this.currentPlayer);
        }
        return c;
    }
    public void discardVisibleTreasures (ArrayList<Treasure> treasures) {
        /*for (Treasure treas: treasures){
            Treasure treasure = treas;
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }*/
        for(int i=0;i<treasures.size();i++){
            Treasure treasure=treasures.get(i);
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    public void discardHiddenTreasures (ArrayList<Treasure> treasures) {
        /*for (Treasure treas: treasures){
            Treasure treasure = treas;
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }*/
        for(int i=0;i<treasures.size();i++){
            Treasure treasure=treasures.get(i);
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    public void makeTreasuresVisible (ArrayList<Treasure> treasures) {
        /*for (Treasure treas : treasures) {
           currentPlayer.makeTreasureVisible(treas);
        }*/
        for(int i=0;i<treasures.size();i++){
            Treasure t;
            t=treasures.get(i);
            currentPlayer.makeTreasureVisible(t);
        }
    }
    public boolean buyLevels (ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        boolean canI = currentPlayer.buyLevels(visible, hidden);
        return canI;
    }
    public void initGame (ArrayList<String> players) {
            initPlayers(players);
            dealer.initCards();
            nextTurn();
    }
    public Player getCurrentPlayer(){return currentPlayer;}
    public Monster getCurrentMonster(){return currentMonster;}
    public CombatResult getResultado() {
        return resultado;
    }
    
    public boolean nextTurn(){
        boolean stateOK, dead;
        
        stateOK = nextTurnAllowed();        
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            dead = currentPlayer.isDead();
            
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    public boolean endOfGame(CombatResult result){
        return (result==CombatResult.WinAndWinGame);
    }
    
}
