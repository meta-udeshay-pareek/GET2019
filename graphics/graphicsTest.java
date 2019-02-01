package graphics;

import static org.junit.Assert.*;
import graphics.Point.InvalidCoordinate;
import graphics.Shape.ShapeType;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class graphicsTest {

		List<Integer> dimension = new ArrayList<Integer>();
	    double area, perimeter;
	    boolean enclosed;
	    Screen screen = new Screen();

	    /**
	    *Function to test for square
	     * @throws InvalidCoordinate 
	    */
	    
	    @Test
	    public void testSquare() throws InvalidCoordinate {

	    	//origin of shape on screen new Point(xCordinates,yCordinates)
	        Point origin = new Point(5,5);
	        
	        //side of square=5 adding to 0th index of list
	        dimension.add(5);
	        
	        //creating square shape from shape factory
	        Shape shapeSquare = ShapeFactory.createShape(ShapeType.Square, origin,dimension);
	        
	        /***********AREA*******************/
	        //calculating area of Square
	        area = shapeSquare.getArea();
	        assertEquals(25, area, 0.002);
	        
	        
	        /**********perimeter**************/
	        
	        //calculating perimeter of square
	        perimeter = shapeSquare.getPerimeter();
	        assertEquals(20, perimeter, 0.002);
	        
	        
	        /*********Point inclusion**********/
	        //checking point inclusion in 
	        enclosed = shapeSquare.isPointEnclosed(new Point(5,11));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(7,11));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(11,11));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(4,7));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(7,7));
	        assertEquals(true, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(11,7));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(2,2));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(3,2));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(11,2));
	        assertEquals(false, enclosed);
	        
	        //adding shape to screen
	        screen.addShape(shapeSquare);
	        
	       
	    }
	    
	    /**
	     *Function to test for Rectangle
	     * @throws InvalidCoordinate 
	     */
	     @Test
	     public void testRectangle() throws InvalidCoordinate {
	         
	         //origin of shape on screen new Point(xCordinates,yCordinates)
	         Point origin = new Point(5,5);
	         
	         //width and height of rectangle
	         dimension.add(5);
	         dimension.add(6);

	         //creating Rectangle shape from shape factory
	         Shape shapeRectangle = ShapeFactory.createShape(ShapeType.Rectangle, origin, dimension);
	         
	         /***********AREA*******************/
		     //calculating area of Rectangle
	         
	         area = shapeRectangle.getArea();
	         assertEquals(30, area, 0.002);
	         
	         
	         /**********perimeter**************/
	         //calculating perimeter of Rectangle
	         
	         perimeter = shapeRectangle.getPerimeter();
	         assertEquals(22, perimeter, 0.002);

	         
	         /*********Point inclusion**********/
	         
	         
	         //checking point inclusion in 
	        enclosed = shapeRectangle.isPointEnclosed(new Point(5,12));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(7,12));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(11,12));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(4,7));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(7,7));
	        assertEquals(true, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(11,7));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(2,2));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(3,2));
	        assertEquals(false, enclosed);
	        enclosed = shapeRectangle.isPointEnclosed(new Point(11,2));
	        assertEquals(false, enclosed);
	         screen.addShape(shapeRectangle);
	        
	     }
	     
	     
	     
	     
	     /**
	      *Function to test for circle
	     * @throws InvalidCoordinate 
	      */
	      @Test
	      public void testCircle() throws InvalidCoordinate {
	         
	    	  //origin of shape on screen new Point(xCordinates,yCordinates)
	          Point origin = new Point(5,5);
	         
	          //radius of circle
	          dimension.add(5);
	   
	      

	          //creating circle shape from shape factory
	          Shape shapeCircle = ShapeFactory.createShape(ShapeType.Circle, origin, dimension);

	          /***********AREA*******************/
			  //calculating area of circle
	          
	          area = shapeCircle.getArea();
	          assertEquals(78.53981633974483, area, 0.002);
	          
	          
	          /**********perimeter**************/
	          //calculating perimeter of circle
	          
	          perimeter = shapeCircle.getPerimeter();
	          assertEquals(31.41592653589793, perimeter, 0.002);
	          
	          
	          
	          /*********Point inclusion**********/
		      //checking point inclusion in circle
	          
	          enclosed = shapeCircle.isPointEnclosed(new Point(0,0));        
	          assertEquals(false, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(0,10));        
	          assertEquals(false, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(0,20));        
	          assertEquals(false, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(2,5));        
	          assertEquals(false, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(5,5));        
	          assertEquals(true, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(10,5));        
	          assertEquals(true, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(5,8));        
	          assertEquals(true, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(5,10));        
	          assertEquals(true, enclosed);
	          enclosed = shapeCircle.isPointEnclosed(new Point(5,20));        
	          assertEquals(false, enclosed);
	         
	
	      }
	      
	      
	     
	     /**
	      *Function to test for Triangle
	     * @throws InvalidCoordinate 
	      */
	      @Test
	      public void testTriangle() throws InvalidCoordinate {
	         
	    	  //origin of shape on screen new Point(xCordinates,yCordinates)
	          Point origin = new Point(5,5);
	         
	          //3 sides of triangle
	          dimension.add(2);
	          dimension.add(2);
	      

	          //creating Triangle shape from shape factory
	          Shape shapeTriangle = ShapeFactory.createShape(ShapeType.Triangle, origin, dimension);

	          /***********AREA*******************/
			  //calculating area of Triangle
	          
	          area = shapeTriangle.getArea();
	          assertEquals(2.0, area, 0.002);
	          
	          
	          /**********perimeter**************/
	          //calculating perimeter of Triangle
	          
	          perimeter = shapeTriangle.getPerimeter();
	          assertEquals(6.828, perimeter, 0.002);
	          
	          
	          
	          /*********Point inclusion**********/
		      //checking point inclusion in Triangle
	          
	          enclosed = shapeTriangle.isPointEnclosed(new Point(2,3));        
	          assertEquals(false, enclosed);
	          enclosed = shapeTriangle.isPointEnclosed(new Point(3,2));        
	          assertEquals(false, enclosed);
	
	      }
	      
	      
	      
	      

}
