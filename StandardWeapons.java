
/**
 * Write a description of class StandardWeapons here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StandardWeapons
{
    public String name;
    public String discription;
    public int minDamage;
    public int maxDamage;
    public int critPercent;

    public StandardWeapons() {
    }

    public StandardWeapons(String name, String discription, int minDamage, int maxDamage) {
        this.name = name;
        this.discription = discription;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.critPercent = 0;
    }
    public StandardWeapons(String name, String discription, int minDamage, int maxDamage, int critPercent) {
        this.name = name;
        this.discription = discription;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.critPercent = critPercent;
    }

    public String getName() {
        return this.name;
    }

    public String getDiscription() {
        return this.discription;
    }

    public int getCritPercent(){
        return critPercent;
    }

    public int getDamage(){
        if((Math.random()*100>=critPercent)){
            return minDamage+(int)(Math.random()*(this.maxDamage-this.minDamage))*5;
        }
        return minDamage+(int)(Math.random()*(this.maxDamage-this.minDamage)); 
    }

    

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", discription='" + getDiscription() + "'" +
            ", minDamage='" + this.minDamage + "'" +
            ", maxDamage='" + this.maxDamage + "'" +
            ", critPercent='" + getCritPercent() + "'" +
            "}";
    }


}
