package dragontreasure;
/**
 *
 * @author nanna
 */
public class Weapon extends Item {
    private int increaseDamage;
    
    public Weapon (String name, String itemDesc) {
       super (name, itemDesc);
    }
    
    public void increaseDamage(int inD){
    this.increaseDamage = inD;
    }
    
}
