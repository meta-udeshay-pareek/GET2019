package graphics;

import java.util.Date;

public class ScreenElement {
    private Shape shape;
    private Date timestemp;

    public ScreenElement(Shape shape){
        this.shape = shape;
        timestemp = new Date();
    }
    
    /**** Getter start********/
    
    public Date getDate(){
    	return this.timestemp;
    }
    
    public Shape getShape(){
    	return shape;
    }
    
    /******* Getter end***********/
}