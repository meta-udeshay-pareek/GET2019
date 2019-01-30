package graphics;

class Square extends ShapeDesign{
	
	
    private int side;
    private final String SHAPE = "SQUARE";
    
    public Square(Point p,int side){
        this.p = p;
        this.side = side;
    }
    
    
    /**** Getter start********/
    
    public int getSide(){
    	return this.side;
    }
    
    public String getType(){
    	return this.SHAPE;
    }
    
    /******* Getter end***********/
    
    
    
    
    
    
    /**********ALL Public Method ********/
    
    /*
    *@return area of Square(side^2)
    */
    @Override
    public double getArea(){
        return (side*side);
    }
    
    /*
    *@return Perimeter of Square (4*side)
    */
    @Override
    public double getPerimeter(){
        return (4*side);
    }
    
    /*
    *@return starting point of Square p(x,y)
    */
    @Override
    public Point getShapeOrigin(){
        return this.p;
    }
    
    /*
    *(x,y+side)    (x+side,y+side)
    *       ------  
    *      |  *(p)|
    *      |      |
    *       ------
    *    (x,y)    (x+side,y)
    *
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point p){
        if( ( p.getX()>=this.p.getX() && p.getX()<=(this.p.getX()+side) ) 
                               &&
            ( p.getY()>=this.p.getY() && p.getY()<=(this.p.getY()+side) ) 
          ){
                return true;
        }
        
        return false;
    }
    
    
}