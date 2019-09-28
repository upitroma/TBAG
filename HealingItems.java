public class HealingItems{
    public String name;
    public String discription;
    public int saturation;

    public HealingItems() {
    }

    public HealingItems(String name, String discription, int saturation) {
        this.name = name;
        this.discription = discription;
        this.saturation = saturation;
    }

    public String getName(){
        return this.name;
    }
    public String getDiscription(){
        return this.discription;
    }
    public int getSaturation(){
        return this.saturation;
    }
    
}
