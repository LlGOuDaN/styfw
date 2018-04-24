import javax.swing.*;
import java.awt.*;

public class LobPong {
    private int height;
    private int width;
    private JFrame worldFrame;

    public LobPong(int width, int height, JFrame worldFrame) {
        this.width = width;
        this.height = height;
        this.worldFrame = worldFrame;
        this.worldFrame.setSize(width, height);
    }

    public void startGame(){
        WorldComponent component = new WorldComponent();
        worldFrame.add(component);
        worldFrame.addKeyListener(new BarKeyListener(component));
    }
}
