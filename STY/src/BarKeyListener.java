import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.image.ImageObserver.WIDTH;


public class BarKeyListener implements KeyListener {
    WorldComponent worldComponent;
    Bar bar;
    JFrame frame;

    public BarKeyListener(WorldComponent worldComponent, JFrame frame) {
        this.worldComponent = worldComponent;
        bar = worldComponent.getBar();
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println(bar.getX());

        if (bar.getX() >= 0 && bar.getX() <= Main.FRAME_WIDTH - bar.getWidth()) {
            int keynum = e.getKeyCode();
            switch (keynum) {
                case KeyEvent.VK_LEFT:
                    bar.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    bar.moveRight();
                    break;
                case KeyEvent.VK_R:
                    WorldComponent component = new WorldComponent(frame);
                    frame.removeAll();
                    frame.add(component);
                default:
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
