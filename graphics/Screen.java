package graphics;

import graphics.Shape.ShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Screen {
	
	


	
	//List of ScreenElements on the screen
    private List <ScreenElement> screenElements= new ArrayList<ScreenElement>();
    
    
    /*
     * @return ScreenElement,list of elements on the screen
     * */
    public List<ScreenElement> getScreenElementList(){
    	return screenElements;
    }
    
   
    /**
     * Function to add shape to screen
     * 
     * @param shape
     */
    public void addShape(Shape shape){
        screenElements.add(new ScreenElement(shape));
    }
    
    
    /**
     * Function to remove shape
     * 
     * @param index
     */
    public void deleteShape(int index){
    	
    	screenElements.remove(index);

    }
    
    /**
     * Function to remove all shape of specific type
     * 
     * @param index
     * @throws Exception 
     */
    public void deleteAllShapeOfType(ShapeType shape) throws Exception{
    	
    	
    	// iterating  list of screen element
    	Iterator<ScreenElement> element =  screenElements.iterator();
    	//checking is list empty 
    	checkForEmptyAndThrowException();
    	
    	while(element.hasNext()){
    		
    		ScreenElement shapeGet =  element.next();
    		//if object class name is same as entered type then this object will remove from screen
    		if(shape.name().equals(shapeGet.getClass().getSimpleName().toUpperCase())){
    			screenElements.remove(shapeGet);
    		}
    	}  	

    }
    

    
    /*
     * @param choice , user choice to sort screenElement List on an specific based parameter
     * @return screenElements sorted list
     * */
    public List<ScreenElement> getSortedShapeList(int choice){
    	
    	switch(choice){
    		case 1:
    			Collections.sort(screenElements, ScreenElement.araeaComparator);
    			break;
    		case 2:
    			Collections.sort(screenElements, ScreenElement.perimeterComparator);
    			break;
    		case 3:
    			Collections.sort(screenElements, ScreenElement.timestempComparator);
    			break;
    		case 4:
    			Collections.sort(screenElements, ScreenElement.distanceComparator);
    			break;
    		default:
    			
    	}
    	
    	return screenElements;
    	
    }
    
    
    /**
     * Function to Display list
     * 
     * @param index
     */
    public void display() throws Exception {

    	Iterator<ScreenElement> screenElement =  screenElements.iterator();
    	
        checkForEmptyAndThrowException();
        int index = 0;
        while (screenElement.hasNext()) {
        	ScreenElement shapeGet =  screenElement.next();
            System.out
                    .println("----------------------------------------------");
            System.out.println("INDEX : " + index);
            System.out.println("DATE : " + shapeGet.getTimestemp());
            System.out.println("SHAPE : " + shapeGet.getShape().getType());
            System.out.println("Area : " + shapeGet.getShape().getArea());
            System.out.println("Perimeter : " + shapeGet.getShape().getPerimeter());
            System.out.println("Origin of shape : " + shapeGet.getShape().getShapeOrigin());
            System.out
                    .println("----------------------------------------------");

            index++;
            // shape.next();
        }
    }
    
    /**
     * Function to check if list is empty
     * 
     * @throws Exception
     */
    public void checkForEmptyAndThrowException() throws Exception {
        if (screenElements.size() == 0) {
            System.out.println("List of Shapes Empty");
            throw new Exception("!! Empty !!");
        }
    }


    
    
  
  
}
