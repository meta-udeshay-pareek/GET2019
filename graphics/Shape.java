package graphics;

public interface Shape {
	public double getArea();
    public double getPerimeter();
    public Point getShapeOrigin();
    public boolean isPointEnclosed(Point p);
    public double getDistanceFromOrigin();
    public String getType();
    
    enum ShapeType{
        SQUARE,RECTANGLE,CIRCLE,TRIANGLE
    }
}
