package dragontreasure;

/**
 *
 * @author nanna
 */
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import dragontreasure.ReturnValue.ReturnCode;

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
        this.rooms = new Room[6];
        this.monsters = new Monster [2];
        this.items = new Item [4];
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
            switch (rv.getReturnCode()) {
                case ERROR:
                    if (rv.getNextRoom() == -2) {
                        System.out.println("Du har avslutat spelet");
                        break OUTER;
                    } else {
                        System.out.println("Det finns ingen dörr åt det hållet");
                    }
                    break;
                case LOCKED:
                    Room tempr = rooms[rv.getNextRoom()];
                    System.out.println("Du har ingen nyckel till den dörren.");
                    if (tempr.hasTreasure()) {
                        System.out.println("Du kikar genom nyckelhålet och ser en skattkista.");
                        tempr.printTreasure();
                    }
                    break;
                case NOOP:
                    break;
                case DEAD: 
                    System.out.println("Du dog.");
                    break OUTER;
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
                System.out.println("För att plocka upp föremål tryck [t] mellanslag siffran");
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
    
    public int getPlayerDP(Player p) {
        int dP = 0;
        
        if (p.hasItem()) {
            HashSet <Integer> playerItem = p.getAllItems();
            for (Integer i : playerItem) {
                Item x = this.items[i];
                dP = x.getDamagePoint();
            }
        }
        return dP;
    }
    
    public boolean hasPlayerKey(Player p) {
        if (p.hasItem()) {
            HashSet <Integer> playerItem = p.getAllItems();
            for (Integer i : playerItem) {
                Item x = this.items[i];
                String n = x.getName();
                if (n.equals("nyckel")) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int getMonsterDP(Room r) {
        int dP = 0;
        
        if (r.hasMonster()) {
            HashSet <Integer> monster = r.getAllMonsters();
            for (Integer i : monster) {
                Monster x = this.monsters[i];
                dP = x.getDamagePoint();               
            }
        }
        return dP;
    }
    
     public int decrementMonsterHP(Room r, int dP) {
        if (r.hasMonster()) {
            HashSet <Integer> monster = r.getAllMonsters();
            for (Integer i : monster) {
                Monster x = this.monsters[i];
                x.decrementHP(dP);
                return x.getHP();
            }
        }
        return -1;
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
            return new ReturnValue(ReturnCode.NOOP, -1); 
        }
        else if (input.startsWith("i")) {
            descPlayerItems(p);
            return new ReturnValue(ReturnCode.NOOP, -1); 
        }
        else if (input.startsWith("f")) {
            if (r.hasMonster()) {
                int playerDP = getPlayerDP(p);
                int monsterDP = getMonsterDP(r);
                p.decrementHP(monsterDP);
                int monsterHP = decrementMonsterHP(r, playerDP);
                if (p.isDead()) {
                    return new ReturnValue(ReturnCode.DEAD, -1); 
                }
                else if (monsterHP > 0) {
                    System.out.println("Monstret dog inte.");
                    return new ReturnValue(ReturnCode.NOOP, -1);
                }
                else if (monsterHP == 0) {
                    System.out.println("Monstret dog.");
                    return new ReturnValue(ReturnCode.NOOP, -1);
                }
                else {
                    return new ReturnValue(ReturnCode.NOOP, -1);
                }
            }
            else {
                System.out.println("Det finns inget monster att slåss mot.");
                return new ReturnValue(ReturnCode.NOOP, -1); 
            }
          
        }
        
        else {
            boolean hasKey = hasPlayerKey(p);
            return r.nextRoom(input, hasKey); 
        }
    }
}

