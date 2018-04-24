import javax.swing.*;
import java.awt.*;

public class WorldComponent extends JComponent {
    private Bar bar;
    private Ball ball;
    private int point;
    private int lives;

    public WorldComponent() {
        this.bar = new Bar();
        this.ball = new Ball();
        this.point = 0;
        this.lives = 3;
        this.setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);

        Runnable repainter = new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        repaint();
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread repaint = new Thread(repainter);
        repaint.start();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        bar.drawOn(g2) ;
        ball.drawOn(g2);
        g2.drawString("Points: " + Integer.toString(point), 20, 20);
        g2.drawString("Lives: " + Integer.toString(lives), 700, 20);
    }

    public Bar getBar() {
        return bar;
    }
}
