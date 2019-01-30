package graphics;

import static org.junit.Assert.*;
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
	    */
	    @Test
	    public void testSquare() {

	        
	    	//origin of shape on screen new Point(xCordinates,yCordinates)
	        Point point = new Point(5,5);
	        
	        //side of square=5 adding to 0th index of list
	        dimension.add(5);
	        
	        //creating square shape from shape factory
	        Shape shapeSquare = ShapeFactory.createShape(ShapeType.SQUARE, point,dimension);
	        
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
	        enclosed = shapeSquare.isPointEnclosed(new Point(11,11));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(2,3));
	        assertEquals(false, enclosed);
	        enclosed = shapeSquare.isPointEnclosed(new Point(8,8));
	        assertEquals(true, enclosed);
	        
	        //adding shape to screen
	        screen.addShape(shapeSquare);
	        
	       
	    }
	    
	    /**
	     *Function to test for Rectangle
	     */
	     @Test
	     public void testRectangle() {
	         
	         //origin of shape on screen new Point(xCordinates,yCordinates)
	         Point point = new Point(5,5);
	         
	         //width and height of rectangle
	         dimension.add(5);
	         dimension.add(6);

	         //creating Rectangle shape from shape factory
	         Shape shapeRectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, point, dimension);
	         
	         /***********AREA*******************/
		     //calculating area of Rectangle
	         
	         area = shapeRectangle.getArea();
	         assertEquals(30, area, 0.002);
	         
	         
	         /**********perimeter**************/
	         //calculating perimeter of Rectangle
	         
	         perimeter = shapeRectangle.getPerimeter();
	         assertEquals(22, perimeter, 0.002);

	         
	         /*********Point inclusion**********/
	         //checking point inclusion in Rectangle
	         
	         enclosed = shapeRectangle.isPointEnclosed(new Point(1,1));
	         assertEquals(false, enclosed);
	         enclosed = shapeRectangle.isPointEnclosed(new Point(11,11));
	         assertEquals(false, enclosed);
	         enclosed = shapeRectangle.isPointEnclosed(new Point(8,8));
	         assertEquals(true, enclosed);
	         enclosed = shapeRectangle.isPointEnclosed(new Point(10,11));
	         assertEquals(true, enclosed);

	         screen.addShape(shapeRectangle);
	        
	     }
	     
	     /**
	      *Function to test for Triangle
	      */
	      @Test
	      public void testTriangle() {
	         
	    	  //origin of shape on screen new Point(xCordinates,yCordinates)
	          Point point = new Point(5,5);
	         
	          //3 sides of triangle
	          dimension.add(2);
	          dimension.add(3);
	          dimension.add(4);

	          //creating Triangle shape from shape factory
	          Shape shapeTriangle = ShapeFactory.createShape(ShapeType.TRIANGLE, point, dimension);

	          /***********AREA*******************/
			  //calculating area of Triangle
	          
	          area = shapeTriangle.getArea();
	          assertEquals(3.464, area, 0.002);
	          
	          
	          /**********perimeter**************/
	          //calculating perimeter of Triangle
	          
	          perimeter = shapeTriangle.getPerimeter();
	          assertEquals(9, perimeter, 0.002);
	          
	          
	          
	          /*********Point inclusion**********/
		      //checking point inclusion in Triangle
	          
	          enclosed = shapeTriangle.isPointEnclosed(new Point(3,3));        
	          assertEquals(true, enclosed);
	          enclosed = shapeTriangle.isPointEnclosed(new Point(2,3));        
	          assertEquals(true, enclosed);
	          
	          
	          screen.addShape(shapeTriangle);
	      }


}
