package dragontreasure;
/**
 *
 * @author nanna
 */
public class Monster {
    private String name;
    private int healthPoints;
    private int damagePoint;
    private String monsterDesc;
    
    
    public Monster (String name, int hP, int dP, String mD){
        this.name = name;
        healthPoints = hP;
        damagePoint = dP;
        monsterDesc = mD;  
    }
   
    public String getDesc() {
        if (this.healthPoints >0) {
            return monsterDesc;
        }
        else {
            return "Det ligger ett kadaver i rummet";
        }
    }
   
    public int getDamagePoint () {
        if (this.healthPoints == 0) {
            return 0;
        }
        else {
            return this.damagePoint;
        }
    }
    
    public void decrementHP(int dP) {
        this.healthPoints -= dP;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }
    
    public int getHP() {
        return this.healthPoints;
    }
    
    public boolean isDead() {
        return this.healthPoints == 0;
    }
}
    
  
    

