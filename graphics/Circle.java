package graphics;

import graphics.Point.InvalidCoordinate;

class Circle implements Shape{
	
    private int radius;
    private Point originPoint;
    private Point centerPoint;
    
    public Circle(Point originPoint,int radious) throws InvalidCoordinate{
        this.originPoint = originPoint;
        this.radius = radious;
        
        //calculating centre of circle
        double m = this.originPoint.distanceFromPoint(new Point(0,0)) + (double)this.radius;
        int x1 = (int)( (m * (double)this.originPoint.getX())/ (m - (double)this.radius) );
		int y1 = (int)( (m * (double)this.originPoint.getY())/ (m - (double)this.radius) );
		this.centerPoint = new Point(x1, y1);
    }
    
    
    
    /**** Getter start********/
    /*
     *@return radius of this circle
     */
    public int getRadius(){
    	return this.radius;
    }
    /*
     *@return TYPE OF THIS SHAPE
     */
    public String getType(){
    	return this.getClass().getSimpleName();
    }
    
    /*
     *@return centerPoint of this circle
     */
    
    public Point getCenterPoint(){
    	return this.centerPoint;
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
        return this.originPoint;
    }
    
    /*
    *
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point p){
        
    	if( this.centerPoint.distanceFromPoint(p) <= this.radius ) {
			return true;
		}
		return false;
    }



    /*
     *@return distance,from origin point to shape origin point
     */
	@Override
	public double getDistanceFromOrigin() {
		double distance=0 ;
		try{
			distance= this.originPoint.distanceFromPoint(new Point(0,0));
		}catch(Exception e){
			System.out.print(e);
		}
		
		return distance;
	}
		
}
