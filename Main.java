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
        Enemy assasin = new Enemy("Zer0", "a trained assasin", 150, 1, 20, 10, 20);
        Enemy boss = new Enemy("\"Big Daddy\"", "(probably not your dad)", 300, 1, 10, 10, 20);

        Combat.startCombat(squirrel,player); 
        Combat.startCombat(bandit,player); 
        Combat.startCombat(assasin,player); 
        Combat.startCombat(boss,player); 

         //need to clear status effects at end of fight
    }
}
