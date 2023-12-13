package dragontreasure;
/**
 *
 * @author nanna
 */
import java.util.HashSet;
import java.util.List;
public class Room {
    
    private String roomDesc;
    private Door[] doors;
    private boolean hasTreasure;
    private int addMonster;
    private int removeMonster;
    private boolean hasMonster;
    
    HashSet<Integer> monsters;
    HashSet<Integer> items;              
    
    public void addMonster(int index) {
        monsters.add(index);
    }
    
    public void removeMonster(int index) {
        monsters.remove(index);
    }
    
    public boolean hasMonster() {
        if (monsters.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
 
    public HashSet<Integer> getAllMonsters () {
        return monsters;
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
    
    public Room(String r, boolean hT, boolean hI, boolean hM) {
        roomDesc = r;
        doors = new Door[4];
        hasTreasure = hT;
        hasMonster = hM;
        monsters = new HashSet<Integer>();
        items = new HashSet<Integer>();
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
    
    public String getRoomDirection () {
        String s = "";
        if (doors[0].validRoom() && doors[0].getDirection() == 'n') {
            s += "En dörr leder norrut [n]\n";
        }
        if (doors[1].validRoom() && doors[1].getDirection() == 'ö') {
            s += "En dörr leder österut [ö]\n";
        }
        if (doors[2].validRoom() && doors[2].getDirection() == 's') {
            s += "En dörr leder söderut [s]\n";
        }
        if (doors[3].validRoom() && doors[3].getDirection() == 'v') {
            s += "En dörr leder västerut [v]\n";
        }
        return s;
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

   

