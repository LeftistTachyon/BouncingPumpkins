
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class AnimatedPanel extends JPanel implements Runnable {

    Pumpkin[] p1;

    public AnimatedPanel() {

        // Instantiate a new pumpkin
        p1 = new Pumpkin[]{
            new Pumpkin(100, 24, 50, 50, 2, 2), 
            new Pumpkin(200, 71, 50, 50, 2, 2), 
            new Pumpkin(300, 116, 50, 50, 2, 2), 
            new Pumpkin(400, 159, 50, 50, 2, 2), 
            new Pumpkin(500, 200, 50, 50, 2, 2), 
            new Pumpkin(600, 239, 50, 50, 2, 2), 
            new Pumpkin(700, 276, 50, 50, 2, 2)
        };

        super.setVisible(true);
        new Thread(this).start();
    }

    @Override
    public void update(Graphics window) {
        paint(window);
    }

    @Override
    public void paint(Graphics window) {
        drawBackground(window);

        for(Pumpkin p:p1) {
            p.draw(window);
            p.move();
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
