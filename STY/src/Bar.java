import java.awt.*;

public class Bar {
    private static final int BAR_HEIGHT = 20;
    private static final int BAR_WIDTH = 200;
    private static final int BAR_X = 0;
    private static final int BAR_Y = 400;
    private static final int BAR_SPEED = 50;

    private int height;
    private int width;
    private int x;
    private int y;
    private WorldComponent worldComponent;

    public Bar(int height, int width, int x, int y, WorldComponent component) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.worldComponent = component;
    }

    public Bar(WorldComponent component){
        this.height = BAR_HEIGHT;
        this.width = BAR_WIDTH;
        this.x = BAR_X;
        this.y = BAR_Y;
        this.worldComponent = component;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }

    public void drawOn(Graphics2D g2) {
        g2.drawRect(x,y,width,height);
    }

    public void moveLeft() {
        if(x-BAR_SPEED >= 0){
            x-=BAR_SPEED;
        }
    }

    public void moveRight() {
        if(x+width+BAR_SPEED <= Main.FRAME_WIDTH){
            x+=BAR_SPEED;
        }
    }
}
