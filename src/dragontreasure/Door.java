package dragontreasure;
/**
 *
 * @author nanna
 */
public class Door {
    
    // direction 'n' = north etc
    private char direction;
    private boolean locked;
    
    //points to the adjoining room in the rooms array
    private int nextRoom;
    
    public Door(char d, boolean l, int nR){
        direction = d;
        locked = l;
        nextRoom = nR;
    }
   
    public boolean isLocked(){
        return locked;
    }
    
    public int nextRoom(){
        return nextRoom;
    }
    
    public char getDirection () {
        return direction;
    }
    
    public boolean validRoom() {
        return (nextRoom >= 0);
    }
}
