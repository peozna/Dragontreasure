package dragontreasure;
/**
 *
 * @author nanna
 */
public class Item {
    protected String name;
    protected String itemDesc;
    private int damagePoint = 0;
    
    public Item (String name, String itemDesc, int damagePoint) {
        this.name = name;
        this.itemDesc = itemDesc;
        this.damagePoint = damagePoint;
    }
    
    public int getDamagePoint(){
       return this.damagePoint;
    }
    
    public void setName (String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getItemDesc(){
        return this.itemDesc;
    }   
}
