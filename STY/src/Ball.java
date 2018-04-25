import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import static java.lang.Math.sqrt;

public class Ball {
    public static final int RADIUS = 10;
    public static final int BALL_X = 95;
    public static final int BALL_Y = 375;
    public static final double BALL_Vx = 0.1;
    public static final double BALL_Vy = -2;
    private double radius;
    private double X;
    private double Y;
    private double Vx;
    private double Vy;
    private int t;
    private boolean pause;
    private WorldComponent worldComponent;

    public Ball(WorldComponent component) {
        this.radius = RADIUS;
        this.X = BALL_X;
        this.Y = BALL_Y;
        Random random = new Random();
        this.Vx = random.nextDouble() * 4 - 2;
        this.Vy = -sqrt(6 - Vx*Vx);
        this.worldComponent = component;
        this.pause = false;
        createTimer();
    }


    public Ball(double radius, double x, double y, double vx, double vy, WorldComponent component) {
        this.radius = radius;
        this.X = x;
        this.Y = y;
        this.Vx = vx;
        this.Vy = vy;
        this.pause = false;
        this.worldComponent = component;
        createTimer();
    }

    private void createTimer() {
        Runnable timer = new Runnable() {
            @Override
            public void run() {
                while (!pause) {
                    try {
                        t++;
                        updatePosition();
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(timer);
        thread.start();
    }

    private void updatePosition() {
        this.Vy = Vy + (9.8  / 1000);
        this.X = X + Vx;
        this.Y = Y + Vy;
        Bar bar = worldComponent.getBar();
        double centerX = X + radius;
        double centerY = Y + radius;
        if (centerX - radius <= 0 || centerX + radius >= Main.FRAME_WIDTH) {
            Vx = -Vx;
        }
        if (centerY - radius <= 0 ) {
            Vy = -Vy;
        }
        if (X >= bar.getX()-radius*2 && X <= bar.getX()+bar.getWidth() && Y >= bar.getY() - radius*2 && Y <= bar.getY()){
            Vy = -Vy;
            worldComponent.getPoint();
        }
        if (centerY >= Main.FRAME_HEIGHT){
            if(!worldComponent.lose){
                pause = true;
                worldComponent.lose();
                worldComponent.restartGame();
            }
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getVx() {
        return Vx;
    }

    public void setVx(double vx) {
        Vx = vx;
    }

    public double getVy() {
        return Vy;
    }

    public void setVy(double vy) {
        Vy = vy;
    }

    public void setPause() {
        this.pause = true;
    }

    public void drawOn(Graphics2D g2) {
        Ellipse2D.Double circle = new Ellipse2D.Double(X, Y, radius * 2, radius * 2);
        g2.fill(circle);
        g2.draw(circle);
    }
}
