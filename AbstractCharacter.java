
import java.awt.Graphics;

public abstract class AbstractCharacter {
 
    private int x; 
    private int y;
    private int height;
    private int width;
    private int xSpeed;
    private int ySpeed;
    
    private boolean drawBox = false; 
    
    public AbstractCharacter(int xPos, int yPos, int ht, int wd, int xS, int yS) {
        setX(xPos);
        setY(yPos);
        setHeight(ht);
        setWidth(wd);
        setXSpeed(xS);
        setYSpeed(yS); 
    }
    
    public abstract void draw(Graphics window);
    public abstract void move();
        
    public void setX(int newX) {
        x = newX;
    }
    public int getX() {
        return x; 
    }
    public void setY(int newY) {
        y = newY;
    }
    public int getY() {
        return y; 
    }
    public void setHeight(int h) {
        height = h; 
    }
    public int getHeight() {
        return height; 
    }
    public void setWidth(int w) {
        width = w; 
    }
    public int getWidth() {
        return width; 
    }
    public void setXSpeed(int xS) {
        xSpeed = xS;
    }
    public int getXSpeed() {
        return xSpeed;
    }
    public void setYSpeed(int yS) {
        ySpeed = yS;
    }
    public int getYSpeed() {
        return ySpeed; 
    }
    public boolean getDrawBox() {
        return drawBox; 
    }
    
    @Override
    public String toString() {
        return "x = " + getX() + ", y = " + getY() + ", width = " + getWidth() + ", height = " + getHeight() + ", xSpeed = " + getXSpeed() + ", ySpeed = " + getYSpeed(); 
    }
}
