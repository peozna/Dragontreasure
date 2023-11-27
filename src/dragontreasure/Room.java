package dragontreasure;
/**
 *
 * @author nanna
 */
public class Room {
    
    private String roomDesc;
    private Door[] doors;
    private boolean hasTreasure;
    
    public Room(String r, boolean hT) {
        roomDesc = r;
        doors = new Door[4];
        hasTreasure = hT;
    }
    
    public boolean hasTreasure() {
        return hasTreasure;
    }
    
    public void doNarrative() {
        System.out.println( this.roomDesc);
    }
    
    public void connectDoor(int index, Door d){
        doors[index] = d;
    }
   
    public ReturnValue nextRoom(String direction){
        Door d;
        Room r;
        if (direction.equals("n")) {
            d = doors[0];
            if (d.isLocked()){
                return new ReturnValue(-3, d.nextRoom());
            }
            else if (d.nextRoom() >= 0) {
                return new ReturnValue(0, d.nextRoom());    
            }
            else {
                return new ReturnValue(-1, d.nextRoom());
            }
        }
        else if (direction.equals("ö")){
            d = doors[1];
            if (d.isLocked()){
                return new ReturnValue(-3, d.nextRoom());
            }
            else if (d.nextRoom() >= 0) {
                return new ReturnValue(0, d.nextRoom());    
            }
            else {
                return new ReturnValue(-1, d.nextRoom());
            }
        }
        else if (direction.equals("s")){
            d = doors[2];
            if (d.isLocked()){
                  return new ReturnValue(-3, d.nextRoom());
            }
            else if (d.nextRoom() >= 0) {
                return new ReturnValue(0, d.nextRoom());    
            }
            else {
                return new ReturnValue(-1, d.nextRoom());
            }
        }
        else if (direction.equals("v")) {
            d = doors[3];
            if (d.isLocked()){
                return new ReturnValue(-3, d.nextRoom());
            }
           else if (d.nextRoom() >= 0) {
                return new ReturnValue(0, d.nextRoom());    
            }
            else {
                return new ReturnValue(-1, d.nextRoom());
            }
        }
        else {
            return new ReturnValue(-1, -1);       
        }    
    }    
    
    public void printTreasure(){
        System.out.println(
            "          _.--.\n"+
            "      _.-'_:-'||\n"+
            "     _.-'_.-::::'||\n"+
            "    _.-:'_.-::::::' ||\n"+
            "   .'`-.-:::::::' ||\n"+
            "  /.'`;|:::::::' ||_\n"+
            " ||   ||::::::' _.;._'-._\n"+
            " ||   ||:::::' _.-!oo @.!-._'-.\n"+
            " \'.  ||:::::.-!() oo @!()@.-'_.||\n"+
            "  '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
            "   `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
            "      ||-._'-.@.-'_.-' _.-o |'||\n"+
            "      ||=[ '-._.-\\U/.-' o |'||\n"+
            "      || '-.]=|| |'| o |'||\n"+
            "      ||      || |'| _| ';\n"+
            "      ||      || |'| _.-'_.-'\n"+
            "      |'-._   || |'|_.-'_.-'\n"+
            "       '-._'-.|| |' `_.-'\n"+
            "           '-.||_/.-'\n");
    }        
    
    
  
    
   


}          

   

