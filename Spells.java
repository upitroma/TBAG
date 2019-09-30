/**
 * @author Allen
 */
public class Spells{
    public String name;
    public String discription;

    public Spells(String name, String discription){
        this.name = name;
        this.discription = discription;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.discription;
    }
}
