import javax.swing.*;
import java.awt.*;

public class Main {
    public static final int FRAME_HEIGHT = 500;
    public static final int FRAME_WIDTH = 800;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LobPong game = new LobPong(FRAME_WIDTH, FRAME_HEIGHT, frame);
        game.startGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
