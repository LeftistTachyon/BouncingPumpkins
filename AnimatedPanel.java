
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A class that draws and animates <code>AbstractCharacter</code>s on a <code>Canvas</code>.
 * @author Jed Wang, Ryan Nutt
 */

public class AnimatedPanel extends JPanel implements Runnable {

    Pumpkin[] pumpkins;
    Ghost[] ghosts;

    public AnimatedPanel() {

        // Instantiate new pumpkins
        pumpkins = new Pumpkin[]{
            new Pumpkin(100, 24, 50, 50, randomVelocity(), randomVelocity()), 
            new Pumpkin(200, 71, 50, 50, randomVelocity(), randomVelocity()), 
            new Pumpkin(300, 116, 50, 50, randomVelocity(), randomVelocity()), 
            new Pumpkin(400, 159, 50, 50, randomVelocity(), randomVelocity()), 
            new Pumpkin(500, 200, 50, 50, randomVelocity(), randomVelocity()), 
            new Pumpkin(600, 239, 50, 50, randomVelocity(), randomVelocity()), 
            new Pumpkin(700, 276, 50, 50, randomVelocity(), randomVelocity())
        };
        // Instantiate new ghosts
        ghosts = new Ghost[]{
            new Ghost((int) (Math.random()*750), (int) (Math.random()*550), 50, 50, -2, 2),
            new Ghost((int) (Math.random()*750), (int) (Math.random()*550), 50, 50, 2, 2),
            new Ghost((int) (Math.random()*750), (int) (Math.random()*550), 50, 50, -2, -2),
            new Ghost((int) (Math.random()*750), (int) (Math.random()*550), 50, 50, 2, -2)
        };
        super.setVisible(true);
        new Thread(this).start();
    }
    
    private int randomVelocity() {
        int negOrNotToNeg = (Math.random() > 0.5)?1:-1;
        return (int) (Math.round(Math.random()) + 1) * negOrNotToNeg;
    }

    @Override
    public void update(Graphics window) {
        paint(window);
    }

    @Override
    public void paint(Graphics window) {
        drawBackground(window);

        for(Pumpkin p:pumpkins) {
            p.draw(window);
            p.move();
        }
        for(Ghost g:ghosts) {
            g.draw(window);
            g.move();
        }
    }

    private void drawBackground(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, getWidth(), getHeight());
        
        // Draw a background for your pumpkin and ghosts to
        // float over
         
    }

    /** Don't touch this method */
    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(10);
                repaint();
            }
        } catch (InterruptedException e) {
        }
    }

}
