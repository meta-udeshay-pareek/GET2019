package graphics;

public interface Shape {
	
	/**
	 * Calculate Area for Shape 
	 * @return - Area of shape
	 */
	double getArea();
	
	/**
	 * Calculate Perimeter for Shape
	 * @return - Perimeter of shape
	 */
    double getPerimeter();
    
    
    /**
	 * Find Origin of a shape
	 * @return - Point class 
	 */
    Point getShapeOrigin();
    
    /**
	 * @param point
	 * @return - True if point is Enclosed otherwise false
	 */
    boolean isPointEnclosed(Point p);
    double getDistanceFromOrigin();
   
    /**
   	 * @return - Type of shape
   	 */
    String getType();
    
    enum ShapeType{
        Square,Rectangle,Circle,Triangle
    }
}
