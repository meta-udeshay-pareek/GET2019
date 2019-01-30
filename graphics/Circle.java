package graphics;

class Circle extends ShapeDesign{
	
    private int radius;
    
    
    public Circle(Point p,int radious){
        this.p = p;
        this.radius = radious;
    }
    
    
    
    /**** Getter start********/
    
    public int getRadius(){
    	return this.radius;
    }
    /*
     *@return TYPE OF THIS SHAPE
     */
    public String getType(){
    	return this.getClass().getSimpleName();
    }
    
    /******* Getter end***********/
    
    
    
    
    
    /**********ALL Public Method ********/
    
    
    /*
    *@return area of Circle(PI*r^2)
    */
    @Override
    public double getArea(){
        return (Math.PI*radius*radius);
    }
    
    /*
    *@return Perimeter of Circle (2*PI*r)
    */
    @Override
    public double getPerimeter(){
        return (2*Math.PI*radius);
    }
    
    /*
    *@return starting point of Circle p(x,y)
    */
    @Override
    public Point getShapeOrigin(){
        return this.p;
    }
    
    /*
     * 
     * slop(m)=(y2-y1)/(x2-x1)
    *
    *   (x - x1)^2 + (y - y1)^2 <= r^2
    *   where x,y will be the center point of the circle and x1,y1 is the point p.
    *   then p(x,y) will be inside circle
    *
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point p){
        
        double slop = p.getY()/p.getX();// slop = (y2-y1)/(x2-x1)  but origin(0,0) p(x,y)  so (y-0)/(x-0)=> y/x
        
        return false;
    }
}
