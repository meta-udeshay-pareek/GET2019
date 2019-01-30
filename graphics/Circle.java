package graphics;

class Circle extends ShapeDesign{
	
    private int radious;
    private final String SHAPE = "CIRCLE";
    
    public Circle(Point p,int radious){
        this.p = p;
        this.radious = radious;
    }
    
    
    
    /**** Getter start********/
    
    public int getRadious(){
    	return this.radious;
    }
    /*
     *@return TYPE OF THIS SHAPE
     */
    public String getType(){
    	return this.SHAPE;
    }
    
    /******* Getter end***********/
    
    
    
    
    
    /**********ALL Public Method ********/
    
    
    /*
    *@return area of Circle(PI*r^2)
    */
    @Override
    public double getArea(){
        return (3.14*radious*radious);
    }
    
    /*
    *@return Perimeter of Circle (2*PI*r)
    */
    @Override
    public double getPerimeter(){
        return (2*3.14*radious);
    }
    
    /*
    *@return starting point of Square p(x,y)
    */
    @Override
    public Point getShapeOrigin(){
        return this.p;
    }
    
    /*
    *
    *   x^2+y^2 <=r^2 then p(x,y) will be inside circle
    *
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point p){
        
        double result = Math.pow(p.getX(),2)+Math.pow(p.getY(),2);
        double r2 = Math.pow(radious, 2);
        
        if( result<=r2 ){
                return true;
        }
        
        return false;
    }
}