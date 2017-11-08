/**
 * Uses the equation y = -1/16x^2 + a to find th y value of the object
 */
// 600 = 1/16x^2 + a
// 600 - a = 1/16x^2
// +/- sqrt(600 - a) = 1/4 x
// +/- 4sqrt(600 - a) = x
public class GravityHandler {
    
    private final int initY, height;
    private int graphX;
    private double currentY;
    
    public GravityHandler(int startingY, int height) {
        graphX = 0;
        this.height = height;
        initY = startingY;
    }
    
    public double getCurrentY() {
        return currentY;
    }
    
    public void next() {
        if(graphX == (int) (4*Math.sqrt(600-initY+height))) {
            graphX = (int) (-4*Math.sqrt(600-initY+height));
        } else {
            graphX++;
        }
        currentY = (1.0/16)*graphX*graphX + initY;
    }
}