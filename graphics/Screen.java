package graphics;

import graphics.Shape.ShapeType;

import java.util.ArrayList;
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
     * @return  shapeNames in ascending order based on area
     * */
    public String[] displayinAscending() throws Exception {

        String shapeNames[] = new String[screenElements.size()];

        for (int i = 0; i < shapeNames.length; i++) {
            shapeNames[i] = screenElements.get(i).getShape().getType();
        }
        checkForEmptyAndThrowException();

        int i = 0;
        while (i < screenElements.size()) {
            int j = 0;
            while (j < (screenElements.size() - 1) - i) {

                if (screenElements.get(j).getShape().getArea() > screenElements.get(j + 1).getShape().getArea()) {

                    String temporary = shapeNames[j];
                    shapeNames[j] = shapeNames[j + 1];
                    shapeNames[j + 1] = temporary;

                }
                j++;
            }
            i++;
        }

        return shapeNames;
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
            System.out.println("DATE : " + shapeGet.getDate());
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
