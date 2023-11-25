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
        
        r = rooms[currentRoom];
        while (true) {
            r.doNarrative();
            System.out.println("Tryck någon av riktingarna n,ö,s,v");
            textIn = input.nextLine();
            currentRoom = r.nextRoom(textIn);
            if (currentRoom == -1){
                System.out.println("Det finns ingen dörr åt det hållet");
            }
            else if (currentRoom == -2){
                System.out.println("Du har avslutat spelet");
                break;
            }
            else {
                r = rooms[currentRoom];
            }
        }
        
        
        
        
    }
    public void setupRoom(int index, Room r){
        this.rooms[index] = r;
        
    }
    
}
