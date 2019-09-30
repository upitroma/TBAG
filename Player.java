/**
 * @author Allen
 */
import java.util.List;
public class Player
{
    public String username;
    public int baseDamage;
    public int health;
    public int maxHealth;
    public int speed;
    public StandardWeapons currentWeapon;
    public StandardWeapons[] inventory;
    public HealingItems[] healingItems;
    public StatusEffects[] appliedStatusEffects;
    public Spells[] knownSpells;

    public Player() {
    }

    public Player(String username, int baseDamage, int health, int maxHealth, int speed, StandardWeapons currentWeapon, StandardWeapons[] inventory, HealingItems[] healingItems, StatusEffects[] appliedStatusEffects, Spells[] knownSpells) {
        this.username = username;
        this.baseDamage = baseDamage;
        this.health = health;
        this.maxHealth = maxHealth;
        this.speed = speed;
        this.inventory = inventory;
        this.currentWeapon = currentWeapon;
        this.healingItems = healingItems;
        this.appliedStatusEffects = appliedStatusEffects;
        this.knownSpells = knownSpells;
    }
    public Player(String username, int baseDamage, int maxHealth, int speed) {
        this.username = username;
        this.baseDamage = baseDamage;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.speed = speed;
        this.currentWeapon = new StandardWeapons("fists","Literally just your fists",1,2);
        this.inventory = new StandardWeapons[] {this.currentWeapon};
        this.healingItems = new HealingItems[] {new HealingItems("pie","Just like mama used to make.",10), new HealingItems("Pop-Tart","Breakfast of Champions",5)};
        this.appliedStatusEffects = new StatusEffects[0];
        this.knownSpells = new Spells[0];
    }

    public StatusEffects[] getAppliedStatusEffects() {
        return this.appliedStatusEffects;
    }

    public void addStatusEffect(StatusEffects w){
        int x = this.appliedStatusEffects.length;
        StatusEffects[] sta = new StatusEffects[x+1];
        for (int i = 0; i<this.appliedStatusEffects.length; i++){
             sta[i] = this.appliedStatusEffects[i];
        } 
        sta[sta.length-1] = w;
        this.appliedStatusEffects = sta;
    }

    public Spells[] getKnownSpells(){
        return this.knownSpells;
    }

    public void addKnownSpell(Spells spell){
        int x = this.knownSpells.length;
        Spells[] spells = new Spells[x+1];
        for (int i = 0; i<this.knownSpells.length; i++){
             spells[i] = this.knownSpells[i];
        } 
        spells[spells.length-1] = spell;
        this.knownSpells = spells;
    }

    public String getUsername() {
        return this.username;
    }

    public StandardWeapons getCurrentWeapon(){
        return this.currentWeapon;
    }

    public void setCurrentWeapon(StandardWeapons w){
        this.currentWeapon = w;
    }

    public StandardWeapons[] getInventory(){
        return this.inventory;
    }
    public HealingItems[] getHealingItems(){
        return this.healingItems;
    }

    public void setInventory(StandardWeapons[] inv){
        this.inventory = inv;
    }

    public void addItemToInventory(StandardWeapons w){ //not tested
       int x = inventory.length;
       StandardWeapons[] inv = new StandardWeapons[x+1];
       for (int i = 0; i<this.inventory.length; i++){
            inv[i] = this.inventory[i];
       } 
       inv[inv.length-1] = w;
       this.inventory = inv;
    }

    public void addHealingItem(HealingItems k){ //not tested
        int x = healingItems.length;
        HealingItems[] inv = new HealingItems[x+1];
        for (int i = 0; i<this.healingItems.length; i++){
             inv[i] = this.healingItems[i];
        } 
        inv[-1] = k;
        this.healingItems = inv;
     }

     public boolean useHealingItem(String s){

        if(playerHas(s)>=0){
            this.health += this.healingItems[playerHas(s)].saturation;
            if (this.health>this.maxHealth){
                this.health = this.maxHealth;
            }
            HealingItems[] temp = new HealingItems[this.healingItems.length -1];
            for (int i = 0, k = 0; i < this.healingItems.length; i++) { 
                if (i == playerHas(s)) { 
                    continue; 
                } 
                temp[k++] = this.healingItems[i]; 
            } 
            this.healingItems = temp;

            return true;
        }
        else{
            return false;
        }
        
     }
     private int playerHas(String s){ 
        for(int i = 0; i<healingItems.length; i++){
            if(healingItems[i].getName().equals(s)){
                return i;
            }
        }  
        return -1;
    }

    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public int getTotalDamage(){
        int x = this.baseDamage + this.currentWeapon.getDamage();
        for (StatusEffects effect : appliedStatusEffects){
            if (effect.getDuration()>0){
                if(effect.getName().equals("Strength I")){
                    x+=3;
                }
                else if(effect.getName().equals("Strength II")){
                    x+=8;
                }
                else if (effect.getName().equals("Strength III")){
                    x+=10;
                }

            }
        }
        return x;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", base damage='" + getBaseDamage() + "'" +
            ", health='" + getHealth() + "'" +
            "}";
    }

}
