package graphics;

class Triangle extends ShapeDesign{
	
	private int base;
	private int height;
   
    
    public Triangle(Point p,int base, int height){
        this.p = p;
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
        return this.p;
    }
    
    
    /*
    *@param p , point p(x,y) 
    *@return "true" if exist in shape area else "false"
    */
    @Override
    public boolean isPointEnclosed(Point point){
    	try {
			Point p1 = new Point(this.p.getX()+this.base, this.p.getY());
			Point p2 = new Point(this.p.getX(), this.p.getY()+this.height);
			if(point.getX()>=this.p.getX() && point.getY() >= this.p.getY()) {
				double left = point.getY()*( p2.getX() - p1.getX() ) - point.getX()*(p2.getY() - p1.getY());
				double right = p1.getY()*p2.getX() - p1.getX()*p2.getY();
				if(left >= right) {
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
    }
    
    
    
}


