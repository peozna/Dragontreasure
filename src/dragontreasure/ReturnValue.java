package dragontreasure;
/**
 *
 * @author nanna
 */
public class ReturnValue {
    private int status;
    private int nextRoom;
    
    public ReturnValue(int s, int nR) {
        status = s;
        nextRoom = nR;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public int getNextRoom(){
        return this.nextRoom;
    }
}
