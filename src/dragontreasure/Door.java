package dragontreasure;
/**
 *
 * @author nanna
 */
public class Door {
    
    private char position;
    private boolean locked;
    
    //points to the adjoining room in the rooms array
    private int nextRoom;
    
    public Door(char p, boolean l, int nR){
        position = p;
        locked = l;
        nextRoom = nR;
    }
   
    public boolean isLocked(){
        return locked;
    }
    
    public int nextRoom(){
        return nextRoom;
    }
    
}
