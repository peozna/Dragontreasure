package dragontreasure;
/**
 *
 * @author nanna
 */
public class Room {
    
    private String roomDesc;
    private Door[] doors;
    
    public Room(String r){
        roomDesc = r;
        doors = new Door[4];
    }

    public void doNarrative(){
        System.out.println( this.roomDesc);
    }
    
    public void connectDoor(int index, Door d){
        doors[index] = d;
    }
   
    public int nextRoom(String direction){
        if (direction.equals("n")) {
            return doors[0].nextRoom();   
        }
        else if (direction.equals("ö")){
            return doors[1].nextRoom();
        }
        else if (direction.equals("s")){
            return doors[2].nextRoom();
        }
        else if (direction.equals("v")) {
            return doors[3].nextRoom();
        }
        else {
            return -1;       
        }    
    }    
    
    
        
           
    
    
  
    
   


}          

   

