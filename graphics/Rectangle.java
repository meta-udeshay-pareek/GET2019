package graphics;

class Rectangle extends ShapeDesign{
	
    private int width,height;
    private final String SHAPE = "Rectangle"; 
    
    public Rectangle(Point p,int width,int height){
        this.p = p;
        this.width = width;
        this.height = height;
    }
    
    
    /**** Getter start********/
    
    public int getWidth(){
    	return this.width;
    }
    
    public int getHeight(){
    	return this.height;
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
    *@return area of Rectangle(width*height)
    */
    @Override
    public double getArea(){
        return (width*height);
    }
    
    /*
    *@return Perimeter of Rectangle 2*(w+h)
    */
    @Override
    public double getPerimeter(){
        return 2*(width+height);
    }
    
    /*
    *@return starting point of Square p(x,y)
    */
    @Override
    public Point getShapeOrigin(){
        return this.p;
    }
    
    /*
    *(x,y+height)    (x+width,y+height)
    *       -----------  
    *      |  *(p)     |
    *      |           |
    *       -----------
    *    (x,y)         (x+width,y)
    *
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point p){
        if( ( p.getX()>=this.p.getX() && p.getX()<=(this.p.getX()+width) ) 
                               &&
            ( p.getY()>=this.p.getY() && p.getY()<=(this.p.getY()+height) ) 
          ){
                return true;
        }
        
        return false;
    }
}