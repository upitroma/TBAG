import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("");

        Enemy bandit = new Enemy("jimmy", "a bandit", 100, 1, 3, 1, 20);
        Player player = new Player("me", 1,200, 5);

        StandardWeapons brassKnuckles = new StandardWeapons("brass knuckles","your grandmother's lucky brass knuckles",1,3,20);

        player.addItemToInventory(brassKnuckles);
        player.setCurrentWeapon(brassKnuckles);

        Combat.startCombat(bandit,player);
    }
}
