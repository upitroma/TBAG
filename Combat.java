import java.util.Scanner;
public class Combat{
    public static void main(){
        System.out.println("");
        Scanner in = new Scanner (System.in);
        String userInput = "";

        int playerDamage = 2;
        Enemy bandit = new Enemy("jimmy", "a bandit", 10, 1, 1, 3, 2);
        Player player = new Player("me", 1,5,20);

        startCombat(bandit,player);
    }
    public static void startCombat(Enemy e, Player p){
        System.out.println("Danger approches");
        Scanner in = new Scanner (System.in);
        String userInput = "";

        while(e.getHealth()>0){
            int playerattack = p.getDamage();
            if(in.nextLine().equals("fight")){
                e.setHealth(e.getHealth()-playerattack);
                System.out.println("you hit for " + playerattack + " damage.");
            }
            
            System.out.println("\nYour health: " + p.getHealth() +" \nEnemy health: " + String.valueOf(e.getHealth()));
        }
    }
}