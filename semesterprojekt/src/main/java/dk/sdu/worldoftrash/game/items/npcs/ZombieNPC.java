package dk.sdu.worldoftrash.game.items.npcs;

import dk.sdu.worldoftrash.game.Game;
import dk.sdu.worldoftrash.game.Inventory;
import dk.sdu.worldoftrash.game.items.Item;

public class ZombieNPC extends NPC {
    private Item arm;
    private Item sewing_kit;

    public ZombieNPC(Game game, String name, String dialogue) {
        super(game, name, dialogue, new Inventory(2));
    }

    @Override
    public void talk() {
        if (getInventory().hasItems(arm, sewing_kit)) {
            System.out.println("Now I can right my wrongs of my past, Ignorance! Lazy! Reluctant! I wasn't the best trash sorter in my good days.");
            System.out.println("My worst enemy actually were office supplies. Especially paper clips and post it notes. Did you know those two aren't worth recycling?");
            System.out.println("They’ll leave a larger carbon food print rather than just tossing them in with residual waste! You didn't? now you do chap.");
        } else {
            System.out.println("RAAAAUUUUGHHHH. *Coughs * Sorry sir, but do you have a second to help me in this awkward situation?");
            System.out.println("I accidentally lost one of my arms, and I could not avoid seeing you on the way to the HOSPITAL, so would you kindly search for my arm inside the hospital and if possible, also bring me a sewing kit so I can sew my arm on again?");
            System.out.println("Thanks in advance.");
        }
    }

    @Override
    public boolean giveItem(Item item) {
        if (item == arm) {
            getInventory().storeItem(item);
            System.out.println("Oh my if you aren't marching so gallantly with my arm under your arm.");
            if (!getInventory().hasItems(sewing_kit)) {
                System.out.println("If you'd get me a sewing kit, I would be eternally grateful.");
            }
            checkItems();
            return true;
        } else if (item == sewing_kit) {
            getInventory().storeItem(item);
            System.out.println("Thank you for the sewing kit!");
            if (!getInventory().hasItems(arm)) {
                System.out.println("If you’d get me my arm, I can sew it on.");
            }
            checkItems();
            return true;
        } else {
            System.out.println("Are you joking with me?!");
            return false;
        }
    }

    public void checkItems() {
        if (getInventory().hasItems(arm, sewing_kit)) {
            System.out.println("Now I can right my wrongs of my past, Ignorance! Lazy! Reluctant! I wasn't the best trash sorter in my good days.");
            System.out.println("My worst enemy actually were office supplies. Especially paper clips and post it notes. Did you know those two aren't worth recycling?");
            System.out.println("They’ll leave a larger carbon food print rather than just tossing them in with residual waste! You didn't? now you do chap.");
        }
    }

    public void setArm(Item arm) {
        this.arm = arm;
    }

    public void setSewing_kit(Item sewing_kit) {
        this.sewing_kit = sewing_kit;
    }
}
