import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {
    public static final int RADIUS = 10;
    public static final int BALL_X = 95;
    public static final int BALL_Y = 375;
    public static final double BALL_Vx = 3;
    public static final double BALL_Vy = -4;
    private double radius;
    private double X;
    private double Y;
    private double Vx;
    private double Vy;
    private int t;

    public Ball() {
        this.radius = RADIUS;
        this.X = BALL_X;
        this.Y = BALL_Y;
        this.Vx = BALL_Vx;
        this.Vy = BALL_Vy;
        createTimer();
    }


    public Ball(double radius, double x, double y, double vx, double vy) {
        this.radius = radius;
        X = x;
        Y = y;
        Vx = vx;
        Vy = vy;
    }

    private void createTimer() {
        Runnable timer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        t++;
                        X = X + Vx ;
                        Y = Y + Vy ;
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(timer);
        thread.start();
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

    public void drawOn(Graphics2D g2) {
        Ellipse2D.Double circle = new Ellipse2D.Double(X, Y, radius*2, radius*2);
        g2.fill(circle);
        g2.draw(circle);
    }
}
