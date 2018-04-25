import javax.swing.*;
import java.awt.*;

public class LobPong {
    private int height;
    private int width;
    public JFrame worldFrame;

    public LobPong(int width, int height, JFrame worldFrame) {
        this.width = width;
        this.height = height;
        this.worldFrame = worldFrame;
        this.worldFrame.setSize(width + 16,height + 39);
    }

    public void startGame(){
        WorldComponent component = new WorldComponent(worldFrame);
        worldFrame.add(component);
        worldFrame.addKeyListener(new BarKeyListener(component, worldFrame));
    }
}
