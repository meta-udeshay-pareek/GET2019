package graphics;

public interface Shape {
    double getArea();
    double getPerimeter();
    Point getShapeOrigin();
    boolean isPointEnclosed(Point p);
    double getDistanceFromOrigin();
    String getType();
    
    enum ShapeType{
        SQUARE,RECTANGLE,CIRCLE,TRIANGLE
    }
}
