import javax.swing.JFrame;

public class PumpkinRunner extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static void main(String[] args) {
        new PumpkinRunner(); 
    }
    
    public PumpkinRunner() {
        
        super("It's Almost Halloween!");
        
        super.setSize(WIDTH, HEIGHT);
        
        //super.getContentPane().add(new TestPanel()); 
        
        // When you're ready to make it move, comment out the line above 
        // and uncomment the next line. 
        super.getContentPane().add(new AnimatedPanel()); 
        
        
        super.setVisible(true); 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
    }

}
