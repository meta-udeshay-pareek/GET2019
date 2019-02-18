package graphics;

import java.util.List;

public class ShapeFactory {

	/**
     * Function to initialize shapes
     * 
     * @param shapeType
     * @param point
     * @param list
     * @return
     */
	
	public static Shape createShape(Shape.ShapeType shape, Point p,List<Integer> l){
		 
		Shape createdShape=null;
		
			switch (shape) {
			
				case SQUARE:
					//new Square(squareOriginPoint,side)
					createdShape = new Square(p, l.get(0));
					break;
				
				case RECTANGLE:
					//new Rectangle(rectangleOriginPoint,width,height)
					createdShape = new Rectangle(p, l.get(0), l.get(1));
					break;
					
				case CIRCLE:
					//new Circle(circleOriginPoint,radios)
					createdShape = new Circle(p, l.get(0));
					break;
					
				case TRIANGLE:
					//new Triangle(triangleOriginPoint,side1,side2,side3)
					createdShape = new Triangle(p, l.get(0), l.get(1),l.get(2));
					break;
	
				default:
					System.out.println("Not a valid shape for object creation");
			}
		return createdShape;
	}
}
