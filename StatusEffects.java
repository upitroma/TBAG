/**
 * @author Allen
 */
public class StatusEffects{
    public String name;
    public int duration;
    public boolean isActive; 

    public StatusEffects(){

    }
    public StatusEffects(String name, int duration){
        this.name = name;
        this.duration = duration; //might not need
        this.isActive = true;
    }
    public String getName(){
        return this.name;
    }
    public int getDuration(){
        return this.duration;
    }
}
