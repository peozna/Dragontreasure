package dragontreasure;
/**
 *
 * @author nanna
 */
public class Item {
    protected String name;
    protected String itemDesc;
    
    public Item (String name, String itemDesc) {
        this.name = name;
        this.itemDesc = itemDesc;
    }
    
    public void setName (String name){
    this.name = name;
    }
    
    public String getName(String name){
    return this.name;
    }
    
    public String getItemDesc(){
    return this.itemDesc;
    }
    
}
