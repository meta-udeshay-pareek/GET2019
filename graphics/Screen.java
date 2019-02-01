package graphics;

import graphics.Shape.ShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Screen {
	
	
	
//	private TreeMap<Date, Shape> shapeWithTime ;
//	private TreeMap<Shape, Double> shapeWithArea;
//	private TreeMap<Double, Shape> shapeWithPerimeter;
//	private TreeMap<Double, Shape> shapeWithOriginDistance;
	
	Screen(){
		
//		shapeWithTime = new TreeMap<Date, Shape>();
//		shapeWithArea = new TreeMap<Shape, Double>();
//		shapeWithPerimeter = new TreeMap<Double, Shape>();
//		shapeWithOriginDistance = new TreeMap<Double, Shape>();
	}
	
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
        
//		this.shapeWithTime.put(new Date(), shape);
//		this.shapeWithArea.put(shape, shape.getArea());
//		this.shapeWithPerimeter.put(shape.getPerimeter(), shape);
//		try {
//			this.shapeWithOriginDistance.put(shape.getShapeOrigin().distanceFromPoint(new Point(0, 0)), shape);
//		}catch(Exception e) {
//			System.out.println(e);
//		}
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
    
    
//    /**
//	 * 
//	 * @return - List of Shapes in sorted according to timestamp
//	 */
//	public List<Shape> sortShapeWithTimestamp(){
//		List<Shape> list = new ArrayList<Shape>();
//		for (Map.Entry<Date, Shape> entry : this.shapeWithTime.entrySet()) {
//	        list.add(entry.getValue());
//	    }
//		return list;
//	}
//	
//	/**
//	 * 
//	 * @return - List of Shapes in sorted according to Area
//	 */
//	public List<Shape> sortShapeWithArea(){
//		List<Shape> list = new ArrayList<Shape>();
//		for (Map.Entry<Shape, Double> entry : this.shapeWithArea.entrySet()) {
//	        list.add(entry.getKey());
//	    }
//		return list;
//	}
//	
//	/**
//	 * 
//	 * @return - List of Shapes in sorted according to Perimeter
//	 */
//	public List<Shape> sortShapeWithPerimeter(){
//		List<Shape> list = new ArrayList<Shape>();
//		for (Map.Entry<Double, Shape> entry : this.shapeWithPerimeter.entrySet()) {
//	        list.add(entry.getValue());
//	    }
//		return list;
//	}
//	
//	/**
//	 * 
//	 * @return - List of Shapes in sorted according to Origin Distance
//	 */
//	public List<Shape> sortShapeWithOriginDistance(){
//		List<Shape> list = new ArrayList<Shape>();
//		for (Map.Entry<Double, Shape> entry : this.shapeWithOriginDistance.entrySet()) {
//	        list.add(entry.getValue());
//	    }
//		return list;
//	}
//	
//	/**
//	 * 
//	 * @return - List of Shapes in given Point is Enclosed
//	 */
//	public List<Shape> getShapesInPointIsEnclosed(Point point){
//		List<Shape> list = new ArrayList<Shape>();
//		for (Map.Entry<Shape, Double> entry : this.shapeWithArea.entrySet()) {
//	        if(entry.getKey().isPointEnclosed(point)) {
//	        	list.add(entry.getKey());
//	        }
//	    }
//		return list;
//	}
//   
    
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
    	System.out.println(screenElements.size());
    	for(ScreenElement screenElement:screenElements)
    		System.out.println(screenElement.getShape()+" "+screenElement.getShape().getArea()+" "+screenElement.getShape().getPerimeter()+" "+screenElement.getShape().getDistanceFromOrigin());
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
