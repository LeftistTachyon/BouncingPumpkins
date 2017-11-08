
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A class that represents a ghost on a <code>Canvas</code>.
 * @author Jed Wang, Ryan Nutt
 */
public class Ghost extends AbstractCharacter {

    BufferedImage ghost1 = null, ghost2 = null;
    
    public Ghost(int x, int y, int wd, int ht, int xS, int yS) {
        super(x, y, wd, ht, xS, yS);
        try {
            ghost1 = ImageIO.read(new File("src/images/ghost1.jpg"));
            ghost2 = ImageIO.read(new File("src/images/ghost2.jpg"));
        } catch (IOException e) {
        }
    }
    
    @Override
    public void draw(Graphics window) {
        if(getXSpeed() > 0) {
            window.drawImage(ghost2, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            window.drawImage(ghost1, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

    @Override
    public void move() {
        if(getX() >= 800-getWidth() || getX() <= 0) {
            setXSpeed(getXSpeed() * -1);
        }
        setX(getX() + getXSpeed());
        if(getY() >= 600-getHeight() || getY() <= 0) {
            setYSpeed(getYSpeed() * -1);
        }
        setY(getY() + getYSpeed());
    }
    
}
