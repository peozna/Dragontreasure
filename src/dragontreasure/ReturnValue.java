package dragontreasure;
/**
 *
 * @author nanna
 */
public class ReturnValue {
    public enum ReturnCode {
        OK,
        ERROR,
        LOCKED,
        EXIT,
        NOOP // no operation
    }
    private ReturnCode rc;
    private int nextRoom;
    
    public ReturnValue(ReturnCode s, int nR) {
        rc = s;
        nextRoom = nR;
    }
    
    public ReturnCode getReturnCode() {
        return this.rc;
    }
    
    public int getNextRoom(){
        return this.nextRoom;
    }
}
