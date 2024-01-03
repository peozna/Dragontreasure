package dragontreasure;

import java.util.HashSet;

/**
 *
 * @author nanna
 */
        
public class Player {
    private String name;
    private int healthPoints;
    private int damagePoint = 1;
    private HashSet<Integer> items;
    
    public Player (String name, int hP) {
        this.name = name;
        this.items = new HashSet<Integer>();
        this.healthPoints = hP;
    }
    
   public void setName(String name) {
    this.name=name;
   }
   
    public String getName(){
     return name;
}

    public int getDamagePoint () {
        return this.damagePoint;
    }
    
    public void decrementHP(int dP) {
        this.healthPoints -= dP;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }
    
    public boolean isDead() {
        return this.healthPoints == 0;
    }
    
    public void addItem(int index) {
        items.add(index);
        
    }
    
    public void removeItem(int index) {
        items.remove(index);
    }
     
    public boolean hasItem() {
        if (items.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }   
    
    public HashSet<Integer> getAllItems () {
        return items;
    }
}
