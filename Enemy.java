
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy
{
    public String name;
    public String discription;
    public int health;
    public int armor;
    public int maxDamage;
    public int MinDamage;
    public int speed;


    public Enemy() {
    }

    public Enemy(String name, String discription, int health, int armor, int maxDamage, int MinDamage, int speed) {
        this.name = name;
        this.discription = discription;
        this.health = health;
        this.armor = armor;
        this.maxDamage = maxDamage;
        this.MinDamage = MinDamage;
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public String getDiscription() {
        return this.discription;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return this.armor;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getMinDamage() {
        return this.MinDamage;
    }

    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", discription='" + getDiscription() + "'" +
            ", health='" + getHealth() + "'" +
            ", armor='" + getArmor() + "'" +
            ", maxDamage='" + getMaxDamage() + "'" +
            ", MinDamage='" + getMinDamage() + "'" +
            ", speed='" + getSpeed() + "'" +
            "}";
    }
    

}
