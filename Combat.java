import java.util.Scanner;
/**
 * Manages all things combat
 * 
 * @author Allen (modeled after the python TBAG)
 */
public class Combat{
    
    public static int enemyStartingHealth; //for calculating healthbar
    public static void startCombat(Enemy e, Player p){
        
        enemyStartingHealth = e.getHealth();
        System.out.println("Danger approches");
        checkEnemy(e);
        System.out.println(displayHealth(e, p));
        Scanner in = new Scanner (System.in);
        String localUserInput = "";

        int playerattack;
        int enemyattack;

        while(e.getHealth()>0 && p.getHealth()>0){
            
            System.out.println("\n\n\n\n");
            playerattack = p.getTotalDamage();
            enemyattack = e.getDamage();
            //untested
            enemyattack = checkForDamageBuffs(e,p,enemyattack, playerattack)[0];
            playerattack = checkForDamageBuffs(e,p,enemyattack, playerattack)[1];
            localUserInput = in.nextLine();
            if(localUserInput.equals("fight")){
                e.setHealth(e.getHealth()-playerattack);
                System.out.println("You hit for " + playerattack + " damage.");
                p.setHealth(p.getHealth()-enemyattack);
                System.out.println("Enemy hit back for " + enemyattack + " damage.");
                applyStatusEffectDamage(e,p);
                
            }
            else if(localUserInput.equals("check")){
                checkEnemy(e);
            }
            else if(localUserInput.equals("run")){
                if(p.getSpeed()>e.getSpeed()){
                    System.out.println("You ran away");
                    p.setHealth(p.getMaxHealth());
                    p.appliedStatusEffects = new StatusEffects[]{};
                    System.out.println("Press enter to continue...");
                    in.nextLine();
                    break;
                }
                else{
                    System.out.println("You tried to run but your foe was too quick");
                    p.setHealth(p.getHealth()-enemyattack);
                    System.out.println("Enemy hit for " + enemyattack + " damage.");
                    applyStatusEffectDamage(e,p);
                }
            }
            else if(localUserInput.equals("inventory")){
                System.out.println("type the name of an item to equip it\n");
                for (StandardWeapons i : p.getInventory()){
                    if(i.equals(p.getCurrentWeapon())){
                        System.out.println("Equipped->" + i.toString());
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
            else if(localUserInput.equals("items")){
                
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
            else if (localUserInput.equals("spells")){
                System.out.println("Cast a spell");
                for (Spells s : p.knownSpells){
                    System.out.println("   " + s.getName() + " (" + s.getDescription()+ ")");
                }
                System.out.println();
                localUserInput = in.nextLine();
                System.out.println(castSpell(localUserInput,e,p));
                p.setHealth(p.getHealth()-enemyattack);
                System.out.println("Enemy hit for " + enemyattack + " damage.");
                applyStatusEffectDamage(e,p);
            }

            
            

            //////////////////////DEBUG
            else if(localUserInput.equals("kill")){
                e.setHealth(0);
                System.out.println("you hit for " + "a lot of" + " damage.");
            }
            //////////////////////DEBUG

            else{
                System.out.println("\nInvalid command. Please use one of the following\n[fight, run, check, inventory, items, spells]");
            }

            

            System.out.println(displayHealth(e,p));
            
            if(p.getHealth()<=0){
                System.out.println("You died, try getting good");
                System.out.println("Since this is just a demo, keep on playing");
                p.setHealth(p.getMaxHealth());
                p.appliedStatusEffects = new StatusEffects[]{};
                System.out.println("Press enter to continue...");
                in.nextLine();
            }
            else if (e.getHealth()<=0){
                int num = (int)enemyStartingHealth/10;
                p.setMaxHealth(p.getMaxHealth()+num);
                System.out.println("You lived to tell another tale.\nYou gained " + enemyStartingHealth + " exp and " + num + " max health!");
                p.setExp(p.getExp()+enemyStartingHealth);
                p.setHealth(p.getMaxHealth());
                p.appliedStatusEffects = new StatusEffects[]{};
                System.out.println("Press enter to continue...");
                in.nextLine();
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


        String playerStatusEffectDisplay = "";
        for (StatusEffects s : p.getAppliedStatusEffects()){
            if (s.getDuration()>0){
                playerStatusEffectDisplay = playerStatusEffectDisplay + "<" + s.getName() + " : " + s.getDuration() + ">";
            }
        }
        String enemyStatusEffectDisplay = "";
        for (StatusEffects s : e.getAppliedStatusEffects()){
            if (s.getDuration()>0){
                enemyStatusEffectDisplay = enemyStatusEffectDisplay + "<" + s.getName() + " : " + s.getDuration() + ">";
            }
        }

        String enemyHealthDisplay = "[";
        int percentEnemyHealth = (e.getHealth()*20)/enemyStartingHealth;
        for(int i = 0; i<percentEnemyHealth; i++){
            enemyHealthDisplay= enemyHealthDisplay + "=";
        }
        for(int i = 0; i<20-percentEnemyHealth; i++){
            enemyHealthDisplay = enemyHealthDisplay + " ";
        }
        enemyHealthDisplay = enemyHealthDisplay + "]";

        return ("\nYour Health: " + p.getHealth() + playerHealthDisplay+ playerStatusEffectDisplay + "\nEnemy Health: " + String.valueOf(e.getHealth()) + enemyHealthDisplay + enemyStatusEffectDisplay + "\n");
    } 
    public static void checkEnemy(Enemy e){
        System.out.println("\nEnemy Name: " + e.getName() + "\nEnemy Discription: " + e.getDiscription() + "\nEnemy Health: " + e.getHealth() + "\nEnemy Attack Damage: " + e.getMinDamage() + "-" + e.getMaxDamage() + "\nEnemy Speed: " + e.getSpeed());
    }

    public static String castSpell(String spellName, Enemy e, Player p){

        for(StatusEffects s : p.getAppliedStatusEffects()){
            if (s.getName().equals("Energy Shield") && s.getDuration()>0){
                return "spell failed (can't cast spells while shield is up)";
            }
        }

        for(Spells s : p.getKnownSpells()){
            if(s.getName().equals(spellName)){
                if (spellName.equals("Strength I") && p.getHealth()>9){
                    p.addStatusEffect(new StatusEffects("Strength I", 3));
                    p.setHealth(p.getHealth()-9);
                    return "You sacrificed 9 health and cast Strength I";
                }
                else if(spellName.equals("Strength II") && p.getHealth()>30){
                    p.addStatusEffect(new StatusEffects("Strength II", 5));
                    p.setHealth(p.getHealth()-30);
                    return "You sacrificed 30 health and cast Strength II";
                }
                else if(spellName.equals("Strength III") && p.getHealth()>2){
                    p.addStatusEffect(new StatusEffects("Strength III", 99));
                    int tempH = p.getHealth()/2;
                    p.setHealth(tempH);
                    return "You sacrificed " + tempH + " health and cast Strength III";
                }
                else if (spellName.equals("Flame I") && p.getHealth()>10){
                    e.addStatusEffect(new StatusEffects("Flame I",3));
                    p.setHealth(p.getHealth()-10);
                    return "You sacrificed 10 health and cast Flame I";
                }
                else if (spellName.equals("Flame II") && p.getHealth()>30){
                    e.addStatusEffect(new StatusEffects("Flame II",5));
                    p.setHealth(p.getHealth()-30);
                    return "You sacrificed 30 health and cast Flame II";
                }
                else if (spellName.equals("Flame III") && p.getHealth()>4){
                    e.addStatusEffect(new StatusEffects("Flame III",99));
                    int tempH = (p.getHealth()/3);
                    p.setHealth(p.getHealth()-tempH);
                    return "You sacrificed " + tempH + " health and cast Flame III";
                }
                else if (spellName.equals("Heal I") && p.getHealth()>2){
                    p.addStatusEffect(new StatusEffects("Heal I",2));
                    p.setHealth(p.getHealth()-2);
                    return "You sacrificed 2 health and cast Heal I";
                }
                else if (spellName.equals("Heal II") && p.getHealth()>2){
                    p.addStatusEffect(new StatusEffects("Heal II",3));
                    p.setHealth(p.getHealth()-5);
                    return "You sacrificed 5 health and cast Heal II";
                }
                else if (spellName.equals("Heal III")&& p.getHealth()<p.getMaxHealth()-30){
                    p.addStatusEffect(new StatusEffects("Defense -%25",4));
                    p.setHealth(p.getHealth()+30);
                    return "You regenerated 30 health";
                }
                else if (spellName.equals("Delayed Strike I")&& p.getHealth()>1){
                    e.addStatusEffect(new StatusEffects("Delayed Strike I",2));
                    p.setHealth(p.getHealth()-1);
                    return "You sacrificed 1 health and cast Delayed Strike I";
                }
                else if (spellName.equals("Delayed Strike II")&& p.getHealth()>5){
                    e.addStatusEffect(new StatusEffects("Delayed Strike II",4));
                    p.setHealth(p.getHealth()-5);
                    return "You sacrificed 5 health and cast Delayed Strike II";
                }
                else if (spellName.equals("Delayed Strike III")&& p.getHealth()>10){
                    e.addStatusEffect(new StatusEffects("Delayed Strike III",8));
                    p.setHealth(p.getHealth()-10);
                    return "You sacrificed 10 health and cast Delayed Strike III";
                }
                else if (spellName.equals("Shield")){
                    p.addStatusEffect(new StatusEffects("Energy Shield",30));
                    return "You focused your energy into a shield";
                }
            }
        }
        
    

        return "spell failed";
    }

    public static int[] checkForDamageBuffs(Enemy e,Player p, int Edamage, int Pdamage){
        for(StatusEffects s : p.getAppliedStatusEffects()){
            if(s.getDuration()>0){
                if (s.getName().equals("Defense -%25")){
                    Edamage = (int) Math.round(Edamage * 1.25);
                }
                if (s.getName().equals("Energy Shield")){
                    Edamage/=2;
                    s.duration-=(Edamage/=2);
                }
            }
        }
        return new int[]{Edamage, Pdamage};
    }
    public static void applyStatusEffectDamage(Enemy e, Player p){
        int fireDamage = 0;
        int delayedStrikeDamage = 0;
        for (StatusEffects s : e.getAppliedStatusEffects()){
            if (s.getDuration()>0){
                if (s.getName().equals("Flame I")){
                    fireDamage += 3;
                }
                else if (s.getName().equals("Flame II")){
                    fireDamage += 6;
                }
                else if (s.getName().equals("Flame III")){
                    fireDamage += 5;
                }
            }
            else if(s.getDuration()==0){
                if (s.getName().equals("Delayed Strike I")){
                    delayedStrikeDamage += 5;
                }
                else if (s.getName().equals("Delayed Strike II")){
                    delayedStrikeDamage += 10;
                }
                else if (s.getName().equals("Delayed Strike III")){
                    delayedStrikeDamage += 30;
                }
            }
        }
        int pHeal = 0;
        for (StatusEffects s : p.getAppliedStatusEffects()){
            if(s.getDuration()==1){
                if (s.getName().equals("Heal I")){
                    pHeal += 5;
                }
                else if (s.getName().equals("Heal II")){
                    pHeal += 10;
                }
            }
        }
        if (fireDamage>0){
            System.out.println("Enemy suffered " + fireDamage + " burn damage");
            e.setHealth(e.getHealth()-fireDamage);
        }
        if(delayedStrikeDamage>0){
            System.out.println("Enemy hit with Delayed Strike for " + delayedStrikeDamage + " damage");
            e.setHealth(e.getHealth()-delayedStrikeDamage);
        }
        if (pHeal>0){
            System.out.println("You regenerated " + pHeal + " health");
            p.setHealth(p.getHealth()+pHeal);
            if(p.getHealth()>p.getMaxHealth()){
                p.setHealth(p.getMaxHealth());
            }
        }

        //manage duration
        for(StatusEffects s : p.getAppliedStatusEffects()){
            s.duration -= 1;
        }
        for(StatusEffects s : e.getAppliedStatusEffects()){
            s.duration -= 1;
        }
    }
}
