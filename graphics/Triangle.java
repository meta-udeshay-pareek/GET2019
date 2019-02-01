package graphics;

class Triangle implements Shape{
	
	private int base;
	private int height;
	private Point originPoint;
    
    public Triangle(Point p,int base, int height){
        this.originPoint = p;
        this.base = base;
        this.height = height;
      
    }
    
    
    
    /**** Getter start********/
    
    public int getHeight(){
    	return this.height;
    }
    
    public int getBase(){
    	return this.base;
    }
    
    
    /*
     * @return TYPE OF THIS SHAPE
    */
    public String getType(){
    	return this.getClass().getSimpleName();
    }

    
    /******* Getter end***********/
    
    
    
    
    
    
    /**********ALL Public Method ********/    
    
    /*
    *@return area of Triangle
    */
    @Override
    public double getArea(){
    	return 0.5 * this.base * this.height;
    }
    
    
    /*
    *@return Perimeter of Triangle (a+b+c) addition of all three sides 
    */
    @Override
    public double getPerimeter(){
    	return this.base + this.height + Math.sqrt( this.base*this.base + this.height*this.height );
    }
    
    
    /*
    *@return starting point of Square p(x,y)
    */
    @Override
    public Point getShapeOrigin(){
        return this.originPoint;
    }
    
    /*
    * |\
    * | \
    * |  \
    * |   \
    * |    \
    * |     \
    * |      \
    * |       \  
    * |________\
    * 
    *  1.creating three triangle inside original triangle by jointing all the three point with inner point which is given by user
    *  2.calculating area of all three triangle ,if addition of area of those three triangle is equal to the area of original triangle
    *   then point is enclosed else not.
    *  
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point p) {
    	
        double x1=this.originPoint.getX();
        double y1=this.originPoint.getY()+this.getHeight();
        double x2=this.originPoint.getX()+ this.getBase();
        double y2=this.originPoint.getY();
        
        double hypotenuse=Math.sqrt(Math.pow(height,2)+Math.pow(base,2));
        double side = Math.sqrt(Math.pow((p.getX()-x1),2)+Math.pow((p.getY()-y1),2));
        double side1 = Math.sqrt(Math.pow((p.getX()-this.originPoint.getX()),2)+Math.pow((p.getY()-this.originPoint.getY()),2));
        double side2= Math.sqrt(Math.pow((p.getX()-x2),2)+Math.pow((p.getY()-y2),2));
        
        double peri= (side+side1+height)/2;
        double peri1= (side1+side2+base)/2;
        double peri2= (side+side2+hypotenuse)/2;
        
        double area=getArea();
        double area1=Math.sqrt(peri*(peri-side)*(peri-height)*(peri-side1));
        double area2=Math.sqrt(peri1*(peri-side1)*(peri1-base)*(peri1-side2));
        double area3=Math.sqrt(peri2*(peri-side)*(peri1-hypotenuse)*(peri2-side2));
        if((area1+area2+area3)==area)
            return true;
        else
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


