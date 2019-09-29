import java.util.Scanner;
public class Combat{
    
    public static int enemyStartingHealth;
    public static void startCombat(Enemy e, Player p){
        
        enemyStartingHealth = e.getHealth();
        System.out.println("Danger approches");
        System.out.println(displayHealth(e, p));
        checkEnemy(e);
        Scanner in = new Scanner (System.in);
        String localUserInput = "";

        while(e.getHealth()>0){
            System.out.println("\n\n\n\n");
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
                System.out.println("type the name of an item to equip it");
                for (StandardWeapons i : p.getInventory()){
                    if(i.equals(p.getCurrentWeapon())){
                        System.out.println("Equipped: " + i.toString());
                    }
                    else{
                        System.out.println("          " + i.toString());
                    }
                }
                localUserInput = in.nextLine();
                for (StandardWeapons i : p.getInventory()){
                    if (i.getName().equals(localUserInput)){
                        p.setCurrentWeapon(i);
                        System.out.println(p.getCurrentWeapon().getName() + " equipped.");
                    }
                }

            }
            else if(localUserInput.equals("item")){
                
                System.out.println("Select an item");
                for (HealingItems i : p.getHealingItems()){
                    System.out.println("   " + i.getName());
                }
                System.out.println();
                localUserInput = in.nextLine();
                if(p.useHealingItem(localUserInput)){
                    System.out.println("You used " + localUserInput +".");
                }
                else{
                    System.out.println("You don't have item: " + localUserInput);
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
                System.out.println("\nInvalid command. Please use one of the following\n[fight, run, check, inventory, item]");
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
        String playerHealthDisplay = "[";
        int percentPlayerHealth = (p.getHealth()*20)/p.getMaxHealth();
        for(int i = 0; i<percentPlayerHealth; i++){
            playerHealthDisplay = playerHealthDisplay + "=";
        }
        for(int i = 0; i<20-percentPlayerHealth; i++){
            playerHealthDisplay = playerHealthDisplay + " ";
        }
        playerHealthDisplay = playerHealthDisplay + "]";

        String enemyHealthDisplay = "[";
        int percentEnemyHealth = (e.getHealth()*20)/enemyStartingHealth;
        for(int i = 0; i<percentEnemyHealth; i++){
            enemyHealthDisplay= enemyHealthDisplay + "=";
        }
        for(int i = 0; i<20-percentEnemyHealth; i++){
            enemyHealthDisplay = enemyHealthDisplay + " ";
        }
        enemyHealthDisplay = enemyHealthDisplay + "]";

        return ("\nYour Health: " + p.getHealth() + playerHealthDisplay+ "\nEnemy Health: " + String.valueOf(e.getHealth()) + enemyHealthDisplay + "\n");
    } 
    public static void checkEnemy(Enemy e){
        System.out.println("\nEnemy Name: " + e.getName() + "\nEnemy Discription: " + e.getDiscription() + "\nEnemy Health: " + e.getHealth() + "\nEnemy Attack Damage: " + e.getMinDamage() + "-" + e.getMaxDamage() + "\nEnemy Speed: " + e.getSpeed());
    }
}
