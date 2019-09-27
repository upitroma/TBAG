import java.util.Scanner;
public class Combat{
    public static void main(){
        System.out.println("");

        Enemy bandit = new Enemy("jimmy", "a bandit", 10, 1, 3, 1, 20);
        Player player = new Player("me", 1,20, 5);

        startCombat(bandit,player);
    }
    public static void startCombat(Enemy e, Player p){
        System.out.println("Danger approches");
        Scanner in = new Scanner (System.in);
        String localUserInput = "";

        while(e.getHealth()>0){
            int playerattack = (p.getBaseDamage() + p.currentWeapon.getDamage());
            int enemyattack = e.getDamage();
            localUserInput = in.nextLine();
            if(localUserInput.equals("fight")){
                e.setHealth(e.getHealth()-playerattack);
                System.out.println("You hit for " + playerattack + " damage.");
                p.setHealth(p.getHealth()-enemyattack);
                System.out.println("Enemy hit back for " + enemyattack + " damage.");
                
            }
            else if(localUserInput.equals("check")){
                checkEnemy(e);
            }
            else if(localUserInput.equals("run")){
                if(p.getSpeed()>e.getSpeed()){
                    System.out.println("You ran away");
                    break;
                }
                else{
                    System.out.println("You tried to run but your foe was too quick");
                    p.setHealth(p.getHealth()-enemyattack);
                    System.out.println("Enemy hit for " + enemyattack + " damage.");
                    //System.out.println(displayHealth(e,p));
                }
            }
            else if(localUserInput.equals("inventory")){
                for (StandardWeapons i : p.getInventory()){
                    System.out.println(i.toString());
                }
            }

            //////////////////////DEBUG
            else if(localUserInput.equals("kill")){
                e.setHealth(e.getHealth()-999999999);
                System.out.println("you hit for " + "a lot of" + " damage.");
                //System.out.println(displayHealth(e,p));
            }
            //////////////////////DEBUG
            else{
                System.out.println("Invalid command. Please use one of the following\n[fight, run, check, inventory]");
            }

            System.out.println(displayHealth(e,p));
            
            if(p.getHealth()<=0){
                System.out.println("You died, try getting good");
            }
            else if (e.getHealth()<=0){
                System.out.println("You lived to tell another tale.");
            }
        }
    }

    public static String displayHealth(Enemy e, Player p){
        return ("\nYour Health: " + p.getHealth() +" \nEnemy Health: " + String.valueOf(e.getHealth()) + "\n");
    } 
    public static void checkEnemy(Enemy e){
        System.out.println("\nEnemy Name: " + e.getName() + "\nEnemy Discription: " + e.getDiscription() + "\nEnemy Health: " + e.getHealth() + "\nEnemy Attack Damage: " + e.getMinDamage() + "-" + e.getMaxDamage() + "\nEnemy Speed: " + e.getSpeed());
    }
}
