/**
 * Run this one
 * 
 * @author Allen
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("");

        
        Player player = new Player("me", 10,10, 10);

        player.addItemToInventory(DevStorage.brassKnuckles);
        player.addItemToInventory(DevStorage.fork);

        player.addKnownSpell(DevStorage.strengthI); 
        player.addKnownSpell(DevStorage.strengthII);
        player.addKnownSpell(DevStorage.strengthIII);
        player.addKnownSpell(DevStorage.flameI);
        player.addKnownSpell(DevStorage.flameII);
        player.addKnownSpell(DevStorage.flameIII);
        player.addKnownSpell(DevStorage.healI);
        player.addKnownSpell(DevStorage.healII);
        player.addKnownSpell(DevStorage.healIII);
        player.addKnownSpell(DevStorage.delayedStrikeI);
        player.addKnownSpell(DevStorage.delayedStrikeII);
        player.addKnownSpell(DevStorage.delayedStrikeIII);
        player.addKnownSpell(DevStorage.energyShield);

       
        Enemy squirrel = new Enemy(EnemyNameGen.getName(), EnemyNameGen.getDiscription(), 10, 1, 2, 1, 1);
        Enemy squirrel2 = new Enemy(EnemyNameGen.getName(), EnemyNameGen.getDiscription(), 15, 1, 5, 1, 1);
        Enemy sandy = new Enemy(EnemyNameGen.getName(), EnemyNameGen.getDiscription(), 50, 1, 5, 1, 1);
        Enemy bandit = new Enemy(EnemyNameGen.getName(), EnemyNameGen.getDiscription(), 100, 1, 10, 1, 5);
        Enemy assasin = new Enemy(EnemyNameGen.getName(), EnemyNameGen.getDiscription(), 150, 1, 20, 10, 20);
        Enemy boss = new Enemy(EnemyNameGen.getName(), EnemyNameGen.getDiscription(), 300, 1, 10, 10, 20);

        Combat.startCombat(squirrel,player); 
        Combat.startCombat(squirrel2,player);
        Combat.startCombat(sandy,player);
        player.setMaxHealth(player.getMaxHealth()+80);
        player.setHealth(player.getMaxHealth());
        Combat.startCombat(bandit,player); 
        Combat.startCombat(assasin,player); 
        Combat.startCombat(boss,player); 

         //need to bugg strength spells
    }
}
