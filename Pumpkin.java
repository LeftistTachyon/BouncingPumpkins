
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pumpkin extends AbstractCharacter {
    
    BufferedImage pumpkin = null;
    GravityHandler gh = null;
    Graphics window;

    public Pumpkin(int x, int y, int wd, int ht, int xS, int yS) {
        super(x, y, wd, ht, xS, yS); 
        gh = new GravityHandler(y, ht);
        try {
            pumpkin = ImageIO.read(new File("src/images/pumpkin.jpg"));
        } catch (IOException e) {
        }
    }
    
    @Override
    public void move() {
        if(getX() < getHeight()/2) {
            setXSpeed(getXSpeed() * -1);
        }
        /*if(getY() < getWidth()/2) {
            setYSpeed(getYSpeed() * -1);
        }
        setY(getY() + getYSpeed());
        setYSpeed(getYSpeed()-3);*/
        gh.next();
        setY((int) gh.getCurrentY());
    }
    
    @Override
    public void draw(Graphics window) {
        
        this.window = window;
        
        // Leave this here. It draws a red box around
        // your shape. Your entire shape needs to be
        // fill the shape, but not go outside. 
        if (getDrawBox()) {
            window.setColor(Color.RED);
            window.drawRect(getX(), getY(), getWidth(), getHeight()); 
        }
        
        Color lightOrange = new Color(255, 183, 61);
        Color darkOrange = new Color(242, 153, 0);
        Color brown = new Color(132, 88, 11);
        
        // Draw your pumpkin here
        //window.drawImage(pumpkin, getX(), getY(), getWidth(), getHeight(), null);
        int ovalWidth = (int) (getWidth()*0.4), ovalHeight = (int) (getHeight()*0.8), ovalY = (int) (getY()+(getHeight()*0.2));
        drawAndFillRoundRect(getX() + (int) (getWidth() * 0.4), getY(), (int) (getWidth() * 0.2), (int) (getHeight() * 0.5), getWidth()/5, darkOrange, brown);
        drawAndFillOval(getX(), ovalY, ovalWidth, ovalHeight, darkOrange, lightOrange);
        window.setColor(darkOrange);
        drawAndFillOval(getX() + getWidth() - ovalWidth, ovalY, ovalWidth, ovalHeight, darkOrange, lightOrange);
        drawAndFillOval((int) (getX() + (getWidth()/2) - (ovalWidth/2)), ovalY, ovalWidth, ovalHeight, darkOrange, lightOrange);
        window.setColor(Color.BLACK);
        window.fillPolygon(new int[]{getX() + (getWidth()/3), getX() + (getWidth()/3) + (getWidth()/10), getX() + (getWidth()/3) - (getWidth()/10)}, 
                new int[]{(int) (getY()+(getHeight()*0.4)), (int) (getY()+(getHeight()*0.6)), (int) (getY()+(getHeight()*0.6))}, 3);
        window.fillPolygon(new int[]{getX() + 2*(getWidth()/3), getX() + 2*(getWidth()/3) + (getWidth()/10), getX() + 2*(getWidth()/3) - (getWidth()/10)}, 
                new int[]{(int) (getY()+(getHeight()*0.4)), (int) (getY()+(getHeight()*0.6)), (int) (getY()+(getHeight()*0.6))}, 3);
        window.fillArc(getX() + (getWidth()/3) - (getWidth()/10), (int) (getY() + (getHeight() * 0.7)), (getWidth()/3) + (getWidth()/5), getWidth()/10, 180, 180);
    }
    
    private void drawAndFillRoundRect(int x, int y, int width, int height, int arcRadius, Color border, Color fill) {
        window.setColor(fill);
        window.fillRoundRect(x, y, width, height, arcRadius, arcRadius);
        window.setColor(border);
        window.drawRoundRect(x, y, width, height, arcRadius, arcRadius);
    }
    
    private void drawAndFillOval(int x, int y, int width, int height, Color border, Color fill) {
        window.setColor(fill);
        window.fillOval(x, y, width, height);
        window.setColor(border);
        window.drawOval(x, y, width, height);
    }
    
    /*private void drawAndFillCircleArc(int x, int y, int radius, int startAngle, int arcAngle, Color border, Color fill) {
        window.setColor(fill);
        window.fillArc(x-radius, y-radius, radius*2, radius*2, startAngle, arcAngle);
        window.setColor(border);
        window.drawArc(x-radius, y-radius, radius*2, radius*2, startAngle, arcAngle);
    }*/
}
