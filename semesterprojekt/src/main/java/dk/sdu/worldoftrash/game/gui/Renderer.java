package dk.sdu.worldoftrash.game.gui;

import dk.sdu.worldoftrash.game.items.Item;
import dk.sdu.worldoftrash.game.items.Player;
import dk.sdu.worldoftrash.game.rooms.Room;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Renderer {

    private Canvas canvas;
    private GraphicsContext context;

    public Renderer(Canvas canvas) {

        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();

    }

    public void render(Room room, Player player) {
        context.save();

        if (room.getBackground() != null) {
            context.drawImage(room.getBackground(), 0,0, canvas.getWidth(), canvas.getHeight());
        }

        for (Item item : room.getItems()) {
            if (item.getImage() != null) {
                drawItem(item);
            }
        }

        drawItem(player);

        context.restore();
    }

    public void drawItem(Item item) {
        Point2D pos = item.getPosition();
        context.drawImage(
                item.getImage(),
                pos.getX() + 0.5 * (item.getWidth() - item.getImage().getWidth() * item.getScale()),
                pos.getY() + 0.5 * (item.getHeight() - item.getImage().getHeight() * item.getScale()),
                item.getImage().getWidth() * item.getScale(),
                item.getImage().getHeight() * item.getScale()
        );
    }

    public void prepare(){
        context.setFill( new Color(0.68, 0.68, 0.68, 1.0) );
        context.fillRect(0,0, canvas.getWidth(),canvas.getHeight());
    }
}
