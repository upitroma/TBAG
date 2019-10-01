/**
 * Run this one
 * 
 * @author Allen
 */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("");

        Enemy bandit = new Enemy("jimmy", "a bandit", 100, 1, 10, 1, 20);
        Player player = new Player("me", 1,100, 5);

        player.addItemToInventory(DevStorage.brassKnuckles);
        player.addItemToInventory(DevStorage.fork);

        player.addKnownSpell(DevStorage.strengthI); 
        player.addKnownSpell(DevStorage.strengthII);
        player.addKnownSpell(DevStorage.strengthIII);
        player.addKnownSpell(DevStorage.flameI);
        player.addKnownSpell(DevStorage.flameII);
        player.addKnownSpell(DevStorage.flameIII);
        
        //Guys, git is pretty cool

        Combat.startCombat(bandit,player); 

         
    }
}
