/**
 * Run this one
 * 
 * @author Allen
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("");

        
        Player player = new Player("me", 100,100, 5);

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

        Enemy squirrel = new Enemy("Chip", "a squirrel", 10, 1, 5, 1, 20);
        Enemy bandit = new Enemy("jimmy", "a bandit", 100, 1, 10, 1, 20);

        Combat.startCombat(squirrel,player); 
        Combat.startCombat(bandit,player); 

         
    }
}
