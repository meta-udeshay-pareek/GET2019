package graphics;

import java.util.List;

public abstract class ShapeDesign implements Shape {
    
    List<Integer> dimension;
    Point p;

    /**
     *
     * @return distance from origin of shape starting point
     */
    @Override
    public double getDistanceFromOrigin(){
        double temp;
        temp = Math.pow(this.p.getX(),2)+Math.pow(this.p.getY(),2);
        
        return Math.sqrt(temp);
    }
    
}
