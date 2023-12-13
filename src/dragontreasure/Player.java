package dragontreasure;

import java.util.HashSet;

/**
 *
 * @author nanna
 */
        
public class Player {
    private String name;
    private int healthPoints;
    private int damage;
    private HashSet<Integer> items;
    
    public Player (String name) {
        this.name = name;
        this.items = new HashSet<Integer>();
    }
    
   public void setName(String name) {
    this.name=name;
   }
   
    public String getName(){
     return name;
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
