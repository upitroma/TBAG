
/**
 * For all basic enemies
 * 
 * @author Allen
 */
public class Enemy
{
    public String name;
    public String discription;
    public int health;
    public int armor; //not used yet
    public int maxDamage;
    public int minDamage;
    public int speed;
    public StatusEffects[] appliedStatusEffects;


    public Enemy() {
    }

    public Enemy(String name, String discription, int health, int armor, int maxDamage, int MinDamage, int speed) {
        this.name = name;
        this.discription = discription;
        this.health = health;
        this.armor = armor;
        this.maxDamage = maxDamage;
        this.minDamage = MinDamage;
        this.speed = speed;
        this.appliedStatusEffects = new StatusEffects[0];
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
        return this.minDamage;
    }

    public int getSpeed() {
        return this.speed;
    }
    public int getDamage() {
        return  minDamage+(int)(Math.random()*((this.maxDamage-this.minDamage)*1.0));  
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
