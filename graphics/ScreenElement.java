package graphics;

import java.util.Comparator;
import java.util.Date;

public class ScreenElement {
    private Shape shape;
    private Date timestemp;

    public ScreenElement(Shape shape){
        this.shape = shape;
        timestemp = new Date();
    }
    
    /**** Getter start********/
    
    public Date getTimestemp(){
    	return this.timestemp;
    }
    
    public Shape getShape(){
    	return shape;
    }
    
    /******* Getter end***********/
    
    
    /**
     * Comparator to sort ScreenElement list  in order of Area
     */
    public static Comparator<ScreenElement> araeaComparator = new Comparator<ScreenElement>() {

        @Override
        public int compare(ScreenElement se1, ScreenElement se2) {
            return (int) (se1.getShape().getArea() - se2.getShape().getArea());
        }
    };

    /**
     * Comparator to sort ScreenElement list  in order of Perimeter
     */
    public static Comparator<ScreenElement> perimeterComparator = new Comparator<ScreenElement>() {

        @Override
        public int compare(ScreenElement se1, ScreenElement se2) {
        	 return (int) (se1.getShape().getPerimeter() - se2.getShape().getPerimeter());
        }
    };
    

    /**
     * Comparator to sort ScreenElement list  in order of Timestemp
     */
    public static Comparator<ScreenElement> timestempComparator = new Comparator<ScreenElement>() {

        @Override
        public int compare(ScreenElement se1, ScreenElement se2) {
        	 return (int) (se1.getTimestemp().compareTo(se2.getTimestemp()));
        }
    };
    
    /**
     * Comparator to sort ScreenElement list in order of DistanceFromOrigin
     */
    public static Comparator<ScreenElement> distanceComparator = new Comparator<ScreenElement>() {

        @Override
        public int compare(ScreenElement se1, ScreenElement se2) {
        	 return (int) (se1.getShape().getDistanceFromOrigin()- se2.getShape().getDistanceFromOrigin());
        }
    };
}
