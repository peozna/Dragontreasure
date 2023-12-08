package dragontreasure;
/**
 *
 * @author nanna
 */
public class Monster {
    private String name;
    private int healthPoints;
    private int damage;
    private String monsterDesc;
    
    
    public Monster (String name, int hP, int dmg, String mD){
        this.name = name;
        healthPoints = hP;
        damage = dmg;
        monsterDesc = mD;  
    }
   
    public String getDesc() {
        return monsterDesc;
    }
   
}
    
  
    

