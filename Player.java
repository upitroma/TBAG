
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    

    public String username;
    public int maxDamage;
    public int minDamage;
    public int health;
    public double critChance;


    public Player() {
    }

    public Player(String username, int maxDamage, int minDamage, int health) {
        this.username = username;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.health = health;
    }

    public String getUsername() {
        return this.username;
    }

    public int getDamage() {
        return minDamage+(int)(Math.random()*(maxDamage-minDamage));  
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
            ", damage='" + getDamage() + "'" +
            ", health='" + getHealth() + "'" +
            "}";
    }

}
