import java.awt.*;

public class Bar {
    private static final int BAR_HEIGHT = 20;
    private static final int BAR_WIDTH = 200;
    private static final int BAR_X = 0;
    private static final int BAR_Y = 400;

    private int height;
    private int width;
    private int x;
    private int y;

    public Bar(int height, int width, int x, int y) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Bar(){
        this.height = BAR_HEIGHT;
        this.width = BAR_WIDTH;
        this.x = BAR_X;
        this.y = BAR_Y;
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
        if(x-5 >= 0){
            x-=5;
        }
    }

    public void moveRight() {
        if(x+width+5 <= Main.FRAME_WIDTH){
            x+=5;
        }
    }
}
