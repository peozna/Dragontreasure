package dragontreasure;
/**
 *
 * @author nanna
 */
import java.util.ArrayList;
import java.util.Scanner;
public class DragonTreasure {
    private Dungeon dungeon;
    
    public DragonTreasure(Dungeon d){
        this.dungeon = d;
    }
    
    public void setupGame(){
        
        //item setup
        Item key = new Key("nyckel", "En rostig nyckel");
        this.dungeon.setupItem(0, key);
        Item potion = new Potion ("hälsodryck", "Du hittar en hälsodryck!");
        this.dungeon.setupItem(1, potion);
        Item weapon = new Weapon ("svärd", "Du ser ett glimmande svärd på marken.");
        this.dungeon.setupItem (2, weapon);
        Item treasure = new Treasure ("skatt", "En stor skattkista står i mitten av rummet.");
        this.dungeon.setupItem (3, treasure);
        
        //monster setup
        Monster monster0 = new Monster("Drake", 18, 2, "En enorm eldsprutande drake"+
                "uppenbarar sig från skugggorna.");
        Monster monster1 = new Monster("Troll", 12, 2, "Ett stort illaluktande troll står i ena hörnet "+
                "och stirrar på dig.");
        this.dungeon.setupMonster(0, monster0);
        this.dungeon.setupMonster(1, monster1);
        
        //room 0
        Room room0 = new Room("Rummet är upplyst av några ljus som sitter på ett bord framför dig.\n",
             false, false, false);
        //connect north door to room 4
        room0.connectDoor(0, new Door('n', false, 4));
        //there is no door to the east
        room0.connectDoor(1, new Door('ö', false, -1));
        //connect south door to room 1
        room0.connectDoor(2, new Door('s', false, 1));
        //there is no door to the west
        room0.connectDoor(3, new Door('v', false, -1));
        this.dungeon.setupRoom(0, room0);
        
         //room 1
        Room room1 = new Room("Du kommer in i ett rymligt bergrum med en "+
                "ljusstrimma sipprandes genom en spricka i den östra väggen",
                false, true, false);
        //connect north door to room 0
        room1.connectDoor(0, new Door('n', false, 0));
        //connect east door to room 2
        room1.connectDoor(1, new Door('ö', false, 2));
        //no door to south
        room1.connectDoor(2, new Door('s', false, -1));
        //there is no door to the west
        room1.connectDoor(3, new Door('v', false, -1));
        room1.addItem(0);
        this.dungeon.setupRoom(1, room1);
        
         //room 2
        Room room2 = new Room("Du kommer in i ett fuktigt rum med vatten "+
                "sipprandes längs den ena väggen",
                false, true, false);
        //connect north door to room 5
        room2.connectDoor(0, new Door('n', false, 5));
        //connect east door to room 4
        room2.connectDoor(1, new Door('ö', true, 3));
        //no door south
        room2.connectDoor(2, new Door('s', false, -1));
        //connect west door to room 1
        room2.connectDoor(3, new Door('v', false, 1));
        room2.addItem (1);
        this.dungeon.setupRoom(2, room2);
        
         //room 3
        Room room3 = new Room("Du kommer in i rummet och ser den stora skattkistan, ",
                true, false, true);
        //connect north door to room 4
        room3.connectDoor(0, new Door('n', false, -1));
        //there is no door to the east
        room3.connectDoor(1, new Door('ö', false, -1));
        //connect south door to room 1
        room3.connectDoor(2, new Door('s', false, -1));
        //there is no door to the west
        room3.connectDoor(3, new Door('v', false, 2));
        room3.addMonster(0);
        room3.addItem(3);
        this.dungeon.setupRoom(3, room3);
    
        
        
         //room 4
        Room room4 = new Room("Du ser en död kropp på golvet.\n", 
                 false, true, false);
        //connect north door to room 4
        room4.connectDoor(0, new Door('n', false,-1));
        //there is no door to the east
        room4.connectDoor(1, new Door('ö', false, 5));
        //connect south door to room 1
        room4.connectDoor(2, new Door('s', false, 0));
        //there is no door to the west
        room4.connectDoor(3, new Door('v', false, -1));
        room4.addItem (2);
        this.dungeon.setupRoom(4, room4);
        
         //room 5
        Room room5 = new Room("Du ser en brinnande fackla i rummets ena hörn ",
                false, false, true);
        //connect north door to room 4
        room5.connectDoor(0, new Door('n', false, 4));
        //connect east to exit the game
        room5.connectDoor(1, new Door('ö', false, -2));
        //connect south door to room 2
        room5.connectDoor(2, new Door('s', false, 2));
        //connect west door to room 4
        room5.connectDoor(3, new Door('v', false, 4));
        room5.addMonster(1);
        this.dungeon.setupRoom(5, room5);
    }
       
 public static void main(String[] args){
    DragonTreasure dt = new DragonTreasure(new Dungeon(0, "Welcome to dungeons", 6));
    dt.setupGame();
    
    Scanner input = new Scanner(System.in);
    
    String ö = "ö";
    String textIn;
     
     
    System.out.println("Välkommen till Dragon Treasure");
    System.out.println("Skriv ditt namn och tryck på [Enter] för att starta spelet...");
    String theName = input.nextLine();
    Player mySpelare = new Player(theName);
                 
    System.out.printf("Välkommen %s till din skattjakt! %n", mySpelare.getName());
    
     
    System.out.println("Du står utanför en grotta. Det luktar svavel från öppningen");
    System.out.println("Grottöppningen ligger österut, tryck på ö och [Enter] för att gå in i grottan.");
    textIn = input.nextLine();
    
        
    while (!textIn.equals(ö)){
        System.out.println("Grottöppningen ligger österut, tryck på ö och [Enter] för att gå in i grottan.");
        textIn = input.nextLine();
    }
    
    System.out.printf("När du går in i grottan kollapsar ingången bakom dig. %n"); 
    
    dt.dungeon.playGame(mySpelare);
    
     System.out.printf("Du gick ur grottan. %n");
   }
     
        
     
     
     
     
 }
    
    
    
    

