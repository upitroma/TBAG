
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    public String username;
    public int baseDamage;
    public int health;
    public int speed;
    public StandardWeapons currentWeapon;
    public StandardWeapons[] inventory;

    public Player() {
    }

    public Player(String username, int baseDamage, int health, int speed, StandardWeapons currentWeapon, StandardWeapons[] inventory) {
        this.username = username;
        this.baseDamage = baseDamage;
        this.health = health;
        this.speed = speed;
        this.inventory = inventory;
        this.currentWeapon = currentWeapon;
    }
    public Player(String username, int baseDamage, int health, int speed) {
        this.username = username;
        this.baseDamage = baseDamage;
        this.health = health;
        this.speed = speed;
        this.currentWeapon = new StandardWeapons("fists","Literally just your fists",1,2);
        this.inventory = new StandardWeapons[] {this.currentWeapon};
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

    public void setInventory(StandardWeapons[] inv){
        this.inventory = inv;
    }

    public void addItemToInventory(StandardWeapons w){
       int x = inventory.length;
       StandardWeapons[] inv = new StandardWeapons[x+1];
       for (int i = 0; i<this.inventory.length; i++){
            inv[i] = this.inventory[i];
       } 
       inv[-1] = w;
       this.inventory = inv;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getHealth() {
        return this.health;
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
