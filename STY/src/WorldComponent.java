import javax.swing.*;
import java.awt.*;

public class WorldComponent extends JComponent {
    private int DEFAULT_TIME = 60;
    public Bar bar;
    public Ball ball;
    public int point;
    public int lives;
    public int time;
    public boolean lose;
    public boolean pause;
    public JFrame parentFrame;

    public WorldComponent(JFrame frame) {
        this.bar = new Bar(this);
        this.ball = new Ball(this);
        this.point = 0;
        this.lives = 3;
        this.lose = false;
        this.pause = false;
        this.time = DEFAULT_TIME;
        this.parentFrame = frame;
        this.setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);

        Runnable repainter = new Runnable() {
            @Override
            public void run() {
                while (!pause) {
                    repaint();
                }

            }
        };
        Thread repaint = new Thread(repainter);
        repaint.start();

        Runnable timer = new Runnable() {
            @Override
            public void run() {

                try {
                    while (!pause) {
                        if (time != 0) {
                            Thread.sleep(1000);
                            time--;
                        } else {
                            WorldComponent.this.getBall().setPause();
                            JOptionPane.showMessageDialog(WorldComponent.this, "Cong! You Win!");
                            levelUp();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread timeCount = new Thread(timer);
        timeCount.start();
    }

    public void restartGame() {
        this.lose = false;
        this.bar = new Bar(this);
        this.ball = new Ball(this);
        this.time = DEFAULT_TIME;
        parentFrame.addKeyListener(new BarKeyListener(this, parentFrame));
    }

    private void levelUp() {
        restartGame();
        point += 50;
        this.time*=2;
        DEFAULT_TIME *= 2;
    }

    public void lose() {
        lose = true;
        lives--;
        if (lives == 0) {
            pause = true;
            ball.setPause();
            JOptionPane.showMessageDialog(this, "Game over! Final Score " + point);
            System.exit(0);
        }
    }

    public void getPoint() {
        point++;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        bar.drawOn(g2);
        ball.drawOn(g2);
        g2.drawString("Points: " + Integer.toString(point), 20, 20);
        g2.drawString("Lives: " + Integer.toString(lives), 700, 20);
        g2.drawString("Time: " + Integer.toString(time), 500, 20);
    }

    public Bar getBar() {
        return bar;
    }

    private Ball getBall() {
        return ball;
    }
}
