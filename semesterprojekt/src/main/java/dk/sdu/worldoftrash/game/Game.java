package dk.sdu.worldoftrash.game;

import dk.sdu.worldoftrash.game.data.WasteType;
import dk.sdu.worldoftrash.game.items.*;
import dk.sdu.worldoftrash.game.items.npcs.*;
import dk.sdu.worldoftrash.game.rooms.Room;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Room currentRoom;

    private ScoreSystem scoreSystem;

    private Player player;

    private TextLogArea textLogArea;

    private double height;
    private double width;

    private Room start, sortingRoom, odense,
    /* level 1 */supermarket, office, storageRoom, parkinglot,
    /* level 2 */hospitalOutside, reception, operatingRoom, morgue, canteen,
    /* level 3 */schoolOutside, teachersLounge, chemistryRoom, gymnasticsRoom, girlsLockerRoom;

    public Game(double width, double height) {
        this.player = new Player(this, "Player");
        this.scoreSystem = new ScoreSystem(this);

        this.height = width;
        this.width = height;

        initObjects();
    }


    /**
     * Initializes game world objects.
     */
    private void initObjects() {
        //Rooms
        start = new Room(this, "start", "in the start room. The beginning of this trashy world's hero... You!!! \nA man greets you and says \"Welcome to the World of Trash. My name is Trash Master Martin, but you can just call me Martin. \nYou must help us save the planet! Now follow me if you want to survive, start by using GO to the sorting-room and TALK to me there.\"");
        start.setBackground(new Image(getClass().getResourceAsStream("/images/maps/supermarket.png")));

        for (int i = 0; i < 10; i++) {
            Waste waste = new Waste(this, "Skrald", WasteType.GLASS, "Test", true);
            waste.setImage(new Image(getClass().getResourceAsStream("/images/placeholder.png")));
            waste.fitToImage();

            waste.setPosition(i * waste.getWidth() * 3, i * waste.getHeight() * 3);

            start.addItem(waste);
        }

        WasteContainer wasteContainer = new WasteContainer(this, "Glas", WasteType.GLASS);
        wasteContainer.setImage(new Image(getClass().getResourceAsStream("/images/placeholder.png")));
        wasteContainer.fitToImage();
        wasteContainer.moveFromMid(new Point2D(width/2, height/2));
        start.addItem(wasteContainer);

        sortingRoom = new Room(this, "sortingRoom", "in sorting room. Martin follows you. This is where you sort the trash and clean it in the sink if needed be. \nThere are 8 different containers, a organic-container, a glass-container, a metal-container, a paper-container, a residual-container, a cardboard-container, a hazardous-container and a plastic-container");


        odense = new Room(this, "city", "in the city of Odense. Martin follows you. The city is in shambles and filled with trash. In the distance you see mountains of trash towering over the city.\nIn the east is a supermarket, in the west is the sorting room, in the south is a hospital and in the north is a school");


        supermarket = new Room(this, "supermarket", "in the supermarket");


        office = new Room(this, "office", "in the supermarket office");


        storageRoom = new Room(this, "storageRoom", "in the storage room");


        parkinglot = new Room(this, "parking-lot", "at the parking lot. There is an homeless man staring intensely at you. A nametag on his coat says Dan");


        hospitalOutside = new Room(this, "hospital-outside", "outside the hospital. You see a man resting in front of the hospital entrance. He looks to be over his expiration date and missing an arm. He greets you and tells you to call him Mr.Zombie");


        reception = new Room(this, "reception", "in the hospital reception");


        operatingRoom = new Room(this, "operating-room", "in the operations room");


        morgue = new Room(this, "morgue", "in the morgue");


        canteen = new Room(this, "canteen", "in the canteen");


        schoolOutside = new Room(this, "school-outside", "outside the school");


        teachersLounge = new Room(this, "teachers-lounge", "in the teachers lounge. A guy in an dirty lab coat is resting in a sofa. He looks like a Mad-Chemist");


        chemistryRoom = new Room(this, "chemistry-room", "in the chemistry room");


        gymnasticsRoom = new Room(this, "gymnastics-room", "in the gymnastics room");


        girlsLockerRoom = new Room(this, "girls-locker-room", "in the girls locker room");


        //**************************************** Waste objects - Start ***********************************************

        // Waste objects #Level 1 - Supermarket
        Waste tomatoCan = new Waste(this, "tomato-can", WasteType.METAL, "cans are made of metal, and therefore goes in metals", false);
        Waste sodaCan = new Waste(this, "soda-can", WasteType.METAL, "cans are made of metal, and therefore goes in metals", false);
        Waste meatTray = new Waste(this, "meat-tray", WasteType.HARD_PLASTIC, "meat-trays are made of hard plastic, and therefore goes in hard plastic", false);
        Waste ketchupPlasticBottle = new Waste(this, "ketchup-plastic-bottle", WasteType.HARD_PLASTIC, "it is made of hard plastic, and therefore goes in hard plastic", false);
        Waste picklesGlass = new Waste(this, "pickle-glass", WasteType.GLASS, "this is a glass, and therefore goes in glass", false);
        Waste beerBottle = new Waste(this, "beer-bottle", WasteType.GLASS, "beer bottles typically are made of glass, and therefore goes in glass", false);
        Waste freshApple = new Waste(this, "fresh-apple", WasteType.ORGANIC, "apples are organic, and therefore goes in organic", true);
        Waste pizzaSlice = new Waste(this, "pizza-slice", WasteType.ORGANIC, "pizza slice is organic, and therefore goes in organic", true);
        Waste paint1 = new Waste(this, "paint", WasteType.HAZARDOUS, "paint is an hazardous material and should be handled accordingly and placed in hazardous", true);
        Waste aaBatteries = new Waste(this, "AA-batteries", WasteType.HAZARDOUS, "batteries contain hazardous chemicals, and therefore goes in hazardous", true);
        Waste deodorant = new Waste(this, "deodorant", WasteType.HAZARDOUS, "deodorants are typically cans containing chemicals, and therefore goes in hazardous", true);
        Waste newspaper = new Waste(this, "newspaper", WasteType.PAPER, "newspapers are made of paper, and therefore goes in paper", true);
        Waste cardboardBox = new Waste(this, "cardboard-box", WasteType.CARDBOARD, "cardboard boxes are made of cardboard, and therefore goes in cardboard", true);
        Waste pizzaBox = new Waste(this, "pizza-box", WasteType.RESIDUAL, "a pizza box has been dirtied by a pizza, and therefore goes in residual", true);
        Waste receipt = new Waste(this, "receipt", WasteType.RESIDUAL, "receipts is made of a special kind of paper containing chemicals and should not be sorted in paper, therefore it goes in residual", true);
        Key bigbox = new Key(this, "biggest-box");


        // Waste objects #Level 2 - Hospital
        Waste papers1 = new Waste(this, "papers", WasteType.PAPER, "this is a paper, it goes in paper",true);
        Waste medicineBottle = new Waste (this, "glass-medicine-bottle", WasteType.GLASS, "it is made out of glass, and therefore goes in glass", false);
        Waste syringe = new Waste (this, "syringe", WasteType.HAZARDOUS, "most biochemical equipment are hazardous, so are syringes, never reuse a syringe!", true);
        Waste scalpel = new Waste (this, "scalpel", WasteType.METAL, "a scalpel is made of metal. This goes into metal", true);
        Waste paperclip = new Waste (this, "paperclips", WasteType.RESIDUAL, "unless you got a large quantity of paper clips, recycling paper clips have a larger carbon footprint rather than just sorting them to residual, and therefore goes in residual", true);
        Waste facemask = new Waste (this, "face-mask", WasteType.RESIDUAL, "this is a face mask. It goes into residual", true);
        Waste bloodbag = new Waste (this, "blood-bag", WasteType.HAZARDOUS, "blood bags are biohazardous material and goes in hazardous", true);
        Waste apple = new Waste (this, "apple",WasteType.ORGANIC, "apples usually are organics and can be dropped in organic", true);
        Waste needle = new Waste (this, "needle", WasteType.RESIDUAL, "Needles in themselves are not worth recycling themselves and usually can be drop in residual ", true);
        Waste chocolateMilkBottle = new Waste (this, "chocolate-milk-bottle", WasteType.GLASS, "this is a glass bottle, and therefore goes into glass", false);
        Waste can = new Waste (this, "can", WasteType.METAL, "cans are made out of metal. It goes into metal", false);
        Waste cake = new Waste (this, "moldy-cake", WasteType.ORGANIC, "this is food and therefore organic. It goes into organic", true);
        Waste tray = new Waste(this,"tin-tray", WasteType.METAL, "tin trays are made out of metal. It goes into metal", false);
        Waste ballPen = new Waste(this, "ball-pen", WasteType.RESIDUAL, "a ball pen is compromised of multiple components and hard to recycle. It goes into residual", true);
        Waste toothBrush = new Waste(this, "tooth-brush", WasteType.RESIDUAL, "a tooth brush is not recycled due to repeated contact with a persons mouth and therefore unhygienic, it goes into residual", true);
        Key arms = new Key(this, "arm");
        Key sewing_kit = new Key(this, "sewing-kit");


        // Waste objects #Level 3 - School
        Waste papers = new Waste(this, "papers", WasteType.PAPER, "this is a paper, it goes in paper",true);
        Waste lighter = new Waste(this, "lighter", WasteType.HAZARDOUS, "lighters contains hazardous materials and therefore goes in hazardous", true);
        Waste bananas = new Waste(this, "bananas", WasteType.ORGANIC, "this is an organic material and can be used as an compost, and therefore goes in organic", true);
        Waste jam_jar = new Waste(this, "jam-jar", WasteType.GLASS, "a jam jar is made of glass, and can therefore if clean be recycled for reuse if put into glass", false);
        Waste nutella_glass = new Waste(this, "nutella-glass", WasteType.GLASS, "a nutella glass is made of glass, and can therefore if clean be recycled for reuse if put into glass", false);
        Waste coffee_grounds = new Waste(this, "coffee-grounds", WasteType.ORGANIC, "coffee grounds are an organic substance and be used for compost. It goes into organic", true);
        Waste poster = new Waste(this, "poster", WasteType.CARDBOARD, "a poster is of cardboard material and goes in cardboard", true);
        Waste spectacles_frame = new Waste(this, "spectacles-frame", WasteType.METAL, "spectacles frame is made of steel and therefore goes in metal", true);
        Waste post_it = new Waste(this, "post-it", WasteType.RESIDUAL, "due to the adhesive substance in the back of post it notes, they are not to be recycled with normal paper, and goes in residual", true);
        Waste milk_carton = new Waste(this, "milk-carton", WasteType.RESIDUAL, "due to a milk carton being soaked in a organic substance it goes in residual", true);
        Waste perfume_bottle = new Waste(this, "perfume-bottle", WasteType.GLASS, "if you remove the perfume substances in the bottle, then the bottle can be recycled for reuse and therefore goes in glass", false);
        Waste water_bottle = new Waste(this, "plastic-water-bottle", WasteType.HARD_PLASTIC, "it is made of hard plastic and can be recycled for reuse and therefore goes in hard plastic", true);
        Waste safety_goggles = new Waste(this, "safety-goggles", WasteType.HARD_PLASTIC, "typically safety goggles are made of hard plastic and can be recycled for reuse, and therefore goes in hard plastic", true);
        Waste paper_clip = new Waste(this, "paper-clips", WasteType.RESIDUAL, "unless you got a large quantity of paper clips, recycling paper clips have a larger carbon footprint rather than just sorting them to residual, and therefore goes in residual", true);
        Waste paint = new Waste(this, "paint", WasteType.HAZARDOUS, "paint is an hazardous material and should be handled accordingly, and placed in hazardous", true);
        Key fertilizer = new Key(this,"fertilizer");

        //NPCs
        ParkingLotNPC homelessDan = new ParkingLotNPC(this, "Dan", "Hello weary traveller");
        ZombieNPC mrZombie = new ZombieNPC(this, "Mr.Zombie", "Hello weary traveller");
        SchoolNPC madChemist = new SchoolNPC(this, "Mad-Chemist", "Hello weary traveller");
        NPC martin = new CityNPC(this, "Martin", "Hello weary traveller");
        start.addItem(martin);

        Door startSort = new Door(this, "Start", start);
        startSort.setWidth(32);
        startSort.setHeight(32);
        startSort.setPosition(200, 200);
        Door sortStart = new Door(this, "Sort", sortingRoom);
        sortStart.setWidth(32);
        sortStart.setHeight(32);
        sortStart.setPosition(50, 50);

        startSort.connect(sortStart);

        start.addItem(startSort);
        sortingRoom.addItem(sortStart);

        sortingRoom.addItem(martin);
        odense.addItem(martin);
        parkinglot.addItem(homelessDan);
        homelessDan.setBigbox(bigbox);
        mrZombie.setArm(arms);
        mrZombie.setSewing_kit(sewing_kit);
        hospitalOutside.addItem(mrZombie);
        teachersLounge.addItem(madChemist);
        madChemist.setFertilizer(fertilizer);

        //Creating trash container objects
        WasteContainer organicContainer = new WasteContainer(this, "organic-container", WasteType.ORGANIC);
        WasteContainer glassContainer = new WasteContainer(this, "glass-container", WasteType.GLASS);
        WasteContainer metalContainer = new WasteContainer(this, "metal-container", WasteType.METAL);
        WasteContainer papercontainer = new WasteContainer(this, "paper-container", WasteType.PAPER);
        WasteContainer residualcontainer = new WasteContainer(this, "residual-container", WasteType.RESIDUAL);
        WasteContainer cardboardcontainer = new WasteContainer(this, "cardboard-container", WasteType.CARDBOARD);
        WasteContainer hardPlasticcontainer = new WasteContainer(this, "plastic-container", WasteType.HARD_PLASTIC);
        WasteContainer hazardouscontainer = new WasteContainer(this, "hazardous-container", WasteType.HAZARDOUS);

        //Assigning containers to the Sorting room
        sortingRoom.addItem(organicContainer);
        sortingRoom.addItem(glassContainer);
        sortingRoom.addItem(metalContainer);
        sortingRoom.addItem(papercontainer);
        sortingRoom.addItem(residualcontainer);
        sortingRoom.addItem(cardboardcontainer);
        sortingRoom.addItem(hazardouscontainer);
        sortingRoom.addItem(hardPlasticcontainer);

        //Assigning trash for level #1 - Supermarket
        supermarket.addItem(tomatoCan);
        supermarket.addItem(ketchupPlasticBottle);
        supermarket.addItem(meatTray);
        supermarket.addItem(receipt);

        office.addItem(beerBottle);
        office.addItem(pizzaSlice);
        office.addItem(pizzaBox);
        office.addItem(bigbox);

        storageRoom.addItem(freshApple);
        storageRoom.addItem(paint1);
        storageRoom.addItem(aaBatteries);
        storageRoom.addItem(cardboardBox);

        parkinglot.addItem(newspaper);
        parkinglot.addItem(sodaCan);
        parkinglot.addItem(deodorant);
        parkinglot.addItem(picklesGlass);

        //Assigning trash for level #2 - Hospital
        hospitalOutside.addItem(syringe);
        hospitalOutside.addItem(needle);
        hospitalOutside.addItem(apple);

        reception.addItem(papers1);
        reception.addItem(paperclip);
        reception.addItem(facemask);

        operatingRoom.addItem(bloodbag);
        operatingRoom.addItem(medicineBottle);
        operatingRoom.addItem(toothBrush);
        operatingRoom.addItem(sewing_kit);

        morgue.addItem(scalpel);
        morgue.addItem(tray);
        morgue.addItem(ballPen);
        morgue.addItem(arms);

        canteen.addItem(chocolateMilkBottle);
        canteen.addItem(can);
        canteen.addItem(cake);

        //Assigning trash for level #3 - School
        schoolOutside.addItem(papers);
        schoolOutside.addItem(lighter);
        schoolOutside.addItem(bananas);
        schoolOutside.addItem(fertilizer);

        teachersLounge.addItem(jam_jar);
        teachersLounge.addItem(nutella_glass);
        teachersLounge.addItem(coffee_grounds);

        gymnasticsRoom.addItem(poster);
        gymnasticsRoom.addItem(spectacles_frame);
        gymnasticsRoom.addItem(post_it);

        girlsLockerRoom.addItem(milk_carton);
        girlsLockerRoom.addItem(perfume_bottle);
        girlsLockerRoom.addItem(water_bottle);

        chemistryRoom.addItem(safety_goggles);
        chemistryRoom.addItem(paper_clip);
        chemistryRoom.addItem(paint);


        //**************************************** Waste objects - end ************************************************

        //Sink
        Sink sink = new Sink(this, "sink");
        sortingRoom.addItem(sink);

        //Exits in "Start" #0
        start.setExit("sorting-room", sortingRoom);

        //Exits in "Sorting Room" #0
        sortingRoom.setExit("start", start);
        sortingRoom.setExit("Odense", odense);

        //Exits in "Odense" #0
        odense.setExit("supermarket", supermarket);
        odense.setExit("sorting-room", sortingRoom);
        odense.setExit("hospital", hospitalOutside);
        odense.setExit("school", schoolOutside);

        //Exits in Supermarket #1
        supermarket.setExit("Odense", odense);
        supermarket.setExit("office", office);
        supermarket.setExit("storage-room", storageRoom);
        supermarket.setExit("parking-lot", parkinglot);

        office.setExit("supermarket", supermarket);
        storageRoom.setExit("supermarket", supermarket);
        parkinglot.setExit("supermarket", supermarket);

        //Exits in "Hospital" #2
        hospitalOutside.setExit("Odense", odense);
        hospitalOutside.setExit("reception", reception);

        reception.setExit("hospital-outside", hospitalOutside);
        reception.setExit("operations-room", operatingRoom);
        reception.setExit("morgue", morgue);
        reception.setExit("canteen", canteen);

        operatingRoom.setExit("reception", reception);
        morgue.setExit("reception", reception);
        canteen.setExit("reception", reception);

        //Exits in "School" #3
        schoolOutside.setExit("Odense", odense);
        schoolOutside.setExit("teachers-lounge", teachersLounge);
        schoolOutside.setExit("chemistry-room", chemistryRoom);
        schoolOutside.setExit("gymnastics-room", gymnasticsRoom);

        teachersLounge.setExit("school", schoolOutside);
        chemistryRoom.setExit("school", schoolOutside);
        gymnasticsRoom.setExit("school", schoolOutside);
        gymnasticsRoom.setExit("girls-locker-room", girlsLockerRoom);
        girlsLockerRoom.setExit("gymnastics-room", gymnasticsRoom);

        // Misc.
        currentRoom = start;

        //Scores
        scoreSystem.getLevelHandler().addLevel(supermarket, 0);
        scoreSystem.getLevelHandler().addLevel(hospitalOutside, 0);
        scoreSystem.getLevelHandler().addLevel(schoolOutside, 6);
    }

    // Getters for NPC locations
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getOdense() {
        return odense;
    }

    public Room getSortingRoom() {
        return sortingRoom;
    }

    public Room getStart() {
        return start;
    }

    /*** Prints out a welcome message.***/
    public void printWelcome() {
        textLogArea.printText("Welcome to the World of Trash!!!");
        textLogArea.printText("The world has been through an apocalypse caused by massive amounts of trash and is in need of a hero. \nThis is an incredibly exciting adventure game.");
        textLogArea.printText(currentRoom.getLongDescription());
    }

    //********************************************* Commands - Start ***************************************************

    /**
     * Prints out a help message.
     */
    private void printHelp() {
        getTextLogArea().printText("You are lost. You are alone. You wander");
        getTextLogArea().printText("around the city of Odense.");
        getTextLogArea().printText("");
        getTextLogArea().printText("Your command words are:");
    }

    /**
     * Changes current room to the given room.
     * @param room Room to go to.
     */
    public void changeRoom(Room room) {
        if (room.isLocked()) {
            getTextLogArea().printText("This room is locked.");
            return;
        }
        currentRoom = room;
        textLogArea.printText(currentRoom.getLongDescription());
    }

    //********************************************* Commands - End ***************************************************

    public void update(float delta) {
        getCurrentRoom().update(delta);
        player.update(delta);
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Returns a list of items in the current room whose boundary box collides with the players'.
     * @return List of colliding items.
     */
    public List<Item> getCollisionsWithPlayer() {
        List<Item> colliding = new ArrayList<>();
        for (Item item : currentRoom.getItems()) {
            if (player.getBoundaryBox().intersects(item.getBoundaryBox())) {
                colliding.add(item);
            }
        }
        return colliding;
    }

    /**
     * Returns a list of objects of given type in the current room whose boundary box collides with the players'.
     * @return List of colliding items of given type.
     */
    public <T> List<T> getCollisionsWithPlayer(Class<T> type) {
        List<T> colliding = new ArrayList<>();
        for (Item item : currentRoom.getItems()) {
            if (type.isInstance(item) && player.getBoundaryBox().intersects(item.getBoundaryBox())) {
                colliding.add(type.cast(item));
            }
        }
        return colliding;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ScoreSystem getScoreSystem () {
        return scoreSystem;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public TextLogArea getTextLogArea() {return textLogArea;}

    public void setTextLogArea(TextLogArea textLogArea) {this.textLogArea = textLogArea;}

}


