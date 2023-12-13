package dragontreasure;

/**
 *
 * @author nanna
 */
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class Dungeon {
    
    private int currentRoom;
    private String welcomeMessage;
    
    //room array holding all the rooms in the dungeon system
    private Room[] rooms;
    private Monster[] monsters;
    private Item [] items;
    
    public Dungeon(int cR, String wM, int numberRooms){
        currentRoom = cR;
        welcomeMessage = wM;
        rooms = new Room[6];
        monsters = new Monster [2];
        items = new Item [4];
    }
    public void playGame(Player player){
        Room r;
        Scanner input = new Scanner(System.in);
        String ö = "ö";
        String v="v";
        String n="n";
        String s="s";  
        String textIn;
        ReturnValue rv;
        
        r = rooms[currentRoom];
        OUTER:
        while (true) {
            r.doNarrative();
            descAnyMonsters(r);
            descRoomItems(r);
            System.out.println(r.getRoomDirection());
            textIn = input.nextLine();
            rv = processInput(player, r, textIn);
            switch (rv.getStatus()) {
                case -1:
                    if (rv.getNextRoom() == -2) {
                        System.out.println("Du har avslutat spelet");
                        break OUTER;
                    } else {
                        System.out.println("Det finns ingen dörr åt det hållet");
                    }
                    break;
                case -3:
                    Room tempr = rooms[rv.getNextRoom()];
                    System.out.println("Du har ingen nyckel till den dörren.");
                    if (tempr.hasTreasure()) {
                        System.out.println("Du kikar genom nyckelhålet och ser en skattkista.");
                        tempr.printTreasure();
                    }
                    break;
                case -4:
                    break;
                default:
                    r = rooms[rv.getNextRoom()];
                    break;
            }
        }
       
    }
    public void setupRoom (int index, Room r) {
        this.rooms[index] = r;
        
    }
    public void setupMonster (int index, Monster m) {
        this.monsters[index] = m;
    }
    
    public void descAnyMonsters(Room r) {
        if (r.hasMonster()) {
            HashSet <Integer> roomMonsters = r.getAllMonsters();
            for (Integer i : roomMonsters) {
                Monster m = this.monsters[i];
                String desc = m.getDesc();
                System.out.println(desc);
            }
        }
    }
    
    public void setupItem (int index, Item i) {
        this.items[index] = i;
    } 
    public void descRoomItems(Room r) {
        if (r.hasItem()) {
            HashSet <Integer> roomItem = r.getAllItems();
            for (Integer i : roomItem) {
                Item x = this.items[i];
                String desc = x.getItemDesc() + "[" + Integer.toString(i) + "]";
                System.out.println(desc);
            }
        }
    }
    
    public void descPlayerItems(Player p) {
        if (p.hasItem()) {
            HashSet <Integer> playerItem = p.getAllItems();
            System.out.println("Du har följande saker: ");
            for (Integer i : playerItem) {
                Item x = this.items[i];
                String desc = x.getName();
                System.out.println("  " + desc);
            }
        }
    }
     
    public ReturnValue processInput (Player p, Room r, String input) {
        if (input.startsWith("t")) {
            String [] arrofStr = input.split(" ", 2);
            Integer i = Integer.valueOf(arrofStr[1]);
            if (r.existItem(i)) {
                System.out.println ("Du plockade upp: " + items[i].getName());
                r.removeItem(i);
                p.addItem(i);
            }
            return new ReturnValue(-4, -1); 
        }
        else if (input.startsWith("i")) {
            descPlayerItems(p);
            return new ReturnValue(-4, -1); 
        }
        
        else {
            return r.nextRoom(input); 
        }
    }
}

