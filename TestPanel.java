
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TestPanel extends JPanel {

        Pumpkin p1, p2, p3, p4;
    
    public TestPanel() {
        
        p1 = new Pumpkin(100, 100, 200, 200, 0, 0);
        p2 = new Pumpkin(400, 50, 50, 50, 0, 0);
        p3 = new Pumpkin(400, 325, 200, 100, 0, 0);
        p4 = new Pumpkin(350, 150, 100, 300, 0, 0);
        
        super.setVisible(true); 
    }
    
    @Override
    public void update(Graphics window) {
        paint(window); 
    }
    
    
    @Override
    public void paint(Graphics window) {
        drawBackground(window);  
        
        // Draw 4 pumpkins
        p1.draw(window);
        p2.draw(window); 
        p3.draw(window); 
        p4.draw(window); 
    }
    
    private void drawBackground(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, getWidth(), getHeight());
      
    }
    
}
