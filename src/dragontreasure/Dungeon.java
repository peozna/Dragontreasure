package dragontreasure;

/**
 *
 * @author nanna
 */
import java.util.Scanner;
public class Dungeon {
    
    private int currentRoom;
    private String welcomeMessage;
    
    //room array holding all the rooms in the dungeon system
    private Room[] rooms;
    
    public Dungeon(int cR, String wM, int numberRooms){
        currentRoom = cR;
        welcomeMessage = wM;
        rooms = new Room[6];
    }
    public void playGame(){
        Room r;
        Scanner input = new Scanner(System.in);
        String ö = "ö";
        String v="v";
        String n="n";
        String s="s";  
        String textIn;
        ReturnValue rv;
        
        r = rooms[currentRoom];
        while (true) {
            r.doNarrative();
            textIn = input.nextLine();
            rv = r.nextRoom(textIn);
            if (rv.getStatus() == -1) {
                if (rv.getNextRoom() == -2) {
                    System.out.println("Du har avslutat spelet");
                    break;
                }
                else {
                    System.out.println("Det finns ingen dörr åt det hållet");
                }
                continue;
            }           
            else if (rv.getStatus() == -3) {
                Room tempr = rooms[rv.getNextRoom()];
                System.out.println("Du har ingen nyckel till den dörren.");
                if (tempr.hasTreasure()) {
                    System.out.println("Du kikar genom nyckelhålet och ser en skattkista.");
                    tempr.printTreasure();
                }
                continue;
            }            
            else {
                r = rooms[rv.getNextRoom()];
            }
        }
        
        
        
        
    }
    public void setupRoom(int index, Room r){
        this.rooms[index] = r;
        
    }
    
}
