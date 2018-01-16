
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Guillermo Muriel
 * @author Luis Liñán
 */
public class CardDealer {
    //privates 
    private static final CardDealer instance= new CardDealer();
    
    //external privates
    ArrayList<Treasure> unusedTreasures = new ArrayList();
    ArrayList<Treasure> usedTreasures = new ArrayList();
    ArrayList<Monster> unusedMonsters = new ArrayList();
    ArrayList<Monster> usedMonsters = new ArrayList();
    ArrayList<Cultist> unusedCultists = new ArrayList();
    ArrayList<Cultist> usedCultists = new ArrayList();
   
    //functions
    private CardDealer(){
    }
    
    public void initCards() {
        initCultistCardDeck();
        initTreasureCardDeck();
        initMonsterCardDeck();
    }
    private void initTreasureCardDeck(){
    
        unusedTreasures = new ArrayList();
        
        /*1-¡Sí mi amo!*/
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        
        /*2-Botas de investigación*/
        unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        
        /*3-Capucha de Cthulhu*/
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));

        /*4-A prueba de babas*/
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));
        
        /*5-Botas de lluvia ácida*/
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.BOTHHAND));
        
        /*6-Casco minero*/
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
        
        /*7-Ametralladoras Thompson*/
        unusedTreasures.add(new Treasure("Ametralladoras Thompson", 600, 4, 8, TreasureKind.BOTHHAND));
        
        /*8-Camiseta de la UGR*/
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
        
        /*9-Clavo de rail ferroviario*/
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
        
        /*10-Cuchillo de sushi arcano*/
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
        
        /*11-Fez alópolo*/
        unusedTreasures.add(new Treasure("Fez alópolo", 700, 3, 5, TreasureKind.HELMET));
        
        /*12-Hacha prehistórica*/
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));
        
        /*13-El aparato del Pr. Tesla*/
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        
        /*14-Gaita*/
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHAND));
        
        /*15-Insecticida*/
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        
        /*16-Escopeta de 3 cañones*/
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHAND));
        
        /*17-Garabato místico*/
        unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        
        /*18-La fuerza de Mr.T*/
        unusedTreasures.add(new Treasure("La fuerza de Mr.T", 1000, 0, 0, TreasureKind.NECKLACE));
        
        /*19-La rebeca metálica*/
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        
        /*20-Mazo de los antiguos*/
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        
        /*21-Necro-playboycón*/
        unusedTreasures.add(new Treasure("Necro-playboycón", 300, 3, 5, TreasureKind.ONEHAND));
        
        /*22-Lanzallamas*/
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHAND));
        
        /*23-Necro-comicón*/
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
        
        /*24-Necronomicón*/
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHAND));
        
        /*25-Linterna a 2 manos*/
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHAND));
        
        /*26-Necro-gnomicón*/
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
        
        /*27-Necrotelecom*/
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        
        /*28-Porra preternatural*/
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        
        /*29-Tentáculo de pega*/
        unusedTreasures.add(new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.HELMET));
        
        /*30-Zapato deja-amigos*/
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        
        /*31-Shogulador*/
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHAND));
        
        /*32-Varita de atizamiento*/
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
        
        this.shuffleTreasures();
    }
    
    private void initMonsterCardDeck(){
    
        unusedMonsters = new ArrayList();

        /*1-3 Byakhees de bonanza*/
        BadConsequence bc1 = new BadConsequence("Pierdes tu armadura visible y otra oculta"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize pr1 = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc1, pr1,0));

        /*2-Chibithulhu*/
        BadConsequence bc2 = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.HELMET))
                ,new ArrayList());
        Prize pr2 = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, bc2, pr2,0));

        /*3-El sopor de Dunwich*/
        BadConsequence bc3 = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.SHOE))
                ,new ArrayList());
        Prize pr3 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc3, pr3,0));

        /*4-Angeles de la noche ibicenca*/
        BadConsequence bc4 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND))
                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize pr4 = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, bc4, pr4,0));

        /*5-El gorron del umbral*/
        BadConsequence bc5 = new BadConsequence("Pierdes todos tus tesoros visibles."
                ,1
                ,10 //como solo hay 6, así pierdes todos seguro
                ,0);
        Prize pr5 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón del umbral", 10, bc5, pr5,0));

        /*6-H.P. Munchcraft*/
        BadConsequence bc6 = new BadConsequence("Pierdes la armadura visible."
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                ,new ArrayList());
        Prize pr6 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft",6 , bc6, pr6,0));

        /*7-Bichgooth*/
        BadConsequence bc7 = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                ,new ArrayList());
        Prize pr7 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, bc7, pr7,0));

        /*8-El rey de rosa*/
        BadConsequence bc8 = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles."
                ,5
                ,3
                ,0);
        Prize pr8 = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, bc8, pr8,0));

        /*9-La redacta en las tiniblas*/
        BadConsequence bc9 = new BadConsequence("Toses los pulmones y pierdes 2 niveles."
                ,2
                ,0
                ,0);
        Prize pr9 = new Prize(1,1);
        unusedMonsters.add(new Monster("La redacta en las tiniblas", 2, bc9, pr9,0));

        /*10-Los hondos*/
        BadConsequence bc10 = new BadConsequence("Estos unusedMonsters resultan bastante superficiales y te aburren mortalmente. Estas muerto"
                ,true);
        Prize pr10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, bc10, pr10,0));

        /*11-Semillas de Cthulhu*/
        BadConsequence bc11 = new BadConsequence("Pierdes dos niveles y dos tesoros ocultos."
                ,2
                ,0
                ,2);
        Prize pr11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas de Cthulhu", 4, bc11, pr11,0));

        /*12-Dameargo*/
        BadConsequence bc12 = new BadConsequence("Te intentas escapar y pierdes una mano visible"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND))
                ,new ArrayList());
        Prize pr12 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, bc12, pr12,0));

        /*13-Pollipólipo volante*/
        BadConsequence bc13 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles."
                ,3
                ,0
                ,0);
        Prize pr13 = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, bc13, pr13,0));

        /*14-Yskhtihyssg-Goth*/
        BadConsequence bc14 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto"
                ,true);
        Prize pr14 = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, bc14, pr14,0));

        /*15-Familia feliz*/
        BadConsequence bc15 = new BadConsequence("La familia te atrapa. Estás muerto."
                ,true);
        Prize pr15 = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, bc15, pr15,0));

        /*16-Roboggoth*/
        BadConsequence bc16 = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible"
                ,2
                ,new ArrayList(Arrays.asList(TreasureKind.BOTHHAND))
                ,new ArrayList());
        Prize pr16 = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, bc16, pr16,0));

        /*17-El espia*/
        BadConsequence bc17 = new BadConsequence("Te asusta en la noche. Pierdes un casco visible"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.HELMET))
                ,new ArrayList());
        Prize pr17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, bc17, pr17,0));

        /*18-El Lenguas*/
        BadConsequence bc18 = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles."
                ,2
                ,5
                ,0);
        Prize pr18 = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, bc18, pr18,0));

        /*19-Bicéfalo*/
        BadConsequence bc19 = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos"
                ,3
                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHAND))
                ,new ArrayList());
        Prize pr19 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, bc19, pr19,0));
        
        
        /*CULTIST*/
        
        /*1.- El mal indecible impronunciable*/
        BadConsequence bc20 = new BadConsequence("Pierdes una mano visible"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND))
                ,new ArrayList()
        );
        Prize pr20 = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10,bc20,pr20,-2));
        
        /*2.- Testigos Oculares*/
        BadConsequence bc21 = new BadConsequence("Pierdes tus tesoros visibles. Jajaja"
                ,1
                ,10 //como solo hay 6 al ser 10 los pierdes todos
                ,0
        );
        Prize pr21 = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares",6,bc21,pr21,2));
        
        /*3.- El gran cthulhu*/
        BadConsequence bc22 = new BadConsequence("Hoy no es tu dia de suerte.Mueres.",true);
        Prize pr22 = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu",20,bc22,pr22,4));
            
        /*4.- Serpiente Político*/
        BadConsequence bc23 = new BadConsequence("Tu gobierno te recorta 2 nivevles",2,0,0);
        Prize pr23 = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico",8,bc23,pr23,-2));
        
        /*5.- Felpuggoth*/
        BadConsequence bc24 = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas"
                ,1
                ,new ArrayList(Arrays.asList(TreasureKind.HELMET , TreasureKind.ARMOR))
                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHAND))
        );
        Prize pr24 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bc24,pr24,4));
        
        /*6.- Shoggoth*/
        BadConsequence bc25 = new BadConsequence("Pierdes 2 niveles",2,0,0);
        Prize pr25 = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth",16,bc25,pr24,-4));
        
        /*7.- Lolitagooth*/
        BadConsequence bc26 = new BadConsequence("Pintalabios negro. Pierdes 2 niveles",2,0,0);
        Prize pr26 = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc26, pr24, 3));
        
        this.shuffleMonsters();
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 1));
        
        this.shuffleCultists();
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    public static CardDealer getInstance(){return instance;}
    
    public Treasure nextTreasure(){
        Treasure next_t = null;
        if(unusedTreasures.isEmpty()){
            /*ArrayList<Treasure> aux;
            aux=unusedTreasures;
            unusedTreasures=usedTreasures;
            usedTreasures=aux;
            shuffleTreasures();*/
            unusedTreasures.addAll(usedTreasures);
            usedTreasures.removeAll(usedTreasures);
            shuffleTreasures();   
            next_t=unusedTreasures.get(0);
            unusedTreasures.remove(0);
        }else{
            next_t = unusedTreasures.get(0);
            giveTreasureBack(unusedTreasures.get(0));
            unusedTreasures.remove(0);
        }
        return next_t;
    }
    public Monster nextMonster(){
        Monster monstruo = null;
        if(unusedMonsters.isEmpty()){
            /*ArrayList<Monster> aux;
            aux=unusedMonsters;
            unusedMonsters=usedMonsters;
            usedMonsters=aux;
            shuffleMonsters();*/
            this.unusedMonsters.addAll(usedMonsters);
            usedMonsters.removeAll(usedMonsters);
            shuffleMonsters();
            monstruo = unusedMonsters.get(0);
            unusedMonsters.remove(0);
        }else{
            monstruo = unusedMonsters.get(0);
            giveMonsterBack(unusedMonsters.get(0));
            unusedMonsters.remove(0);
            
       }
        return monstruo;
    }
    public Cultist nextCultist(){
        Cultist cultist = null;
        if(unusedCultists.isEmpty()){
            this.unusedCultists.addAll(usedCultists);
            usedCultists.removeAll(usedCultists);
            shuffleCultists();
            cultist = unusedCultists.get(0);
            unusedCultists.remove(0);
        }else{
            cultist = unusedCultists.get(0);
            usedCultists.add(unusedCultists.get(0));
            unusedCultists.remove(0);
            
       }
        return cultist;
    }
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    public void giveCultistBack(Cultist cp){
       usedCultists.add(cp);
    }
    
}