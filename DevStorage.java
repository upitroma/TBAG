/**
 * Used for storing pre-built objects
 * 
 * @author Allen
 */
public class DevStorage{

    //all spells are hard coded for now
    //make sure to add new spells to the Player and combat class
    public static Spells strengthI = new Spells("Strength I","increases damage by 3 for 3 turns, lowers health by 9");
    public static Spells strengthII = new Spells("Strength II","increases damage by 8 for 5 turns, lowers health by 30");
    public static Spells strengthIII = new Spells("Strength III","increases damage by 10 for 99 turns, lowers current health by %50");

    public static Spells flameI = new Spells("Flame I","3 damage to enemy for 3 turns, lowers health by 10");
    public static Spells flameII = new Spells("Flame II","6 damage to enemy for 5 turns, lowers health by 30");
    public static Spells flameIII = new Spells("Flame III","5 damage to enemy for 99 turns, lowers health by %50");

    public static Spells healI = new Spells("Heal I","regenerate 5 health after 2 rounds, lowers health by 2");
    public static Spells healII = new Spells("Heal II","regenerate 10 health after 3 rounds, lowers health by 5");
    public static Spells healIII = new Spells("Heal III","regenerate 30 health, lowers defence by %25 for 4 rounds");//not tested

    //public static Spells shelf = new Spells("Not Heal III","regenerate 50 health after 5 rounds, lowers health by 40");

    public static StandardWeapons brassKnuckles = new StandardWeapons("brass knuckles","your grandmother's lucky brass knuckles",1,3,20);
    public static StandardWeapons fork = new StandardWeapons("fork","a fork that was in the road", 1,4,10);


}
