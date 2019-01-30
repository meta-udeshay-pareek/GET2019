package graphics;

class Triangle extends ShapeDesign{
	
    private int side1;
    private int side2;
    private int side3;
   
    
    public Triangle(Point p,int side1, int side2, int side3){
        this.p = p;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    
    
    /**** Getter start********/
    
    public int getSide1(){
    	return this.side1;
    }
    
    public int getSide2(){
    	return this.side2;
    }
    
    public int getSide3(){
    	return this.side3;
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
              ________________
    *      A=√s(s−a)(s−b)(s−c)    where s = (a+b+c)/2
    */
    @Override
    public double getArea(){
        double semiperimeter = getPerimeter()/2;
        double area = Math.sqrt(
        					(semiperimeter * (semiperimeter - side1) *(semiperimeter - side2) * (semiperimeter - side3))
        				);
      
        
        return area;
    }
    
    
    /*
    *@return Perimeter of Triangle (a+b+c) addition of all three sides 
    */
    @Override
    public double getPerimeter(){
        return (this.side1 + this.side2 + this.side3);
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
    public boolean isPointEnclosed(Point p){
        int xCoordinate = p.getX();
        int yCoordinate = p.getY();

        int x1 = this.p.getX();
        int y1 = this.p.getY();
        
        int x2 = x1 + this.side1;
        int y2 = y1 + this.side1;

        int x3 = x2 + side2;
        int y3 = y2 - side2;

        if ((xCoordinate < x1 || yCoordinate < y1)
                || (xCoordinate < x2 || yCoordinate < y2)
                || (xCoordinate < x3 || yCoordinate < y3)) {

            return false;
        }
        if ((xCoordinate > x1 || yCoordinate > y1)
                || (xCoordinate > x2 || yCoordinate > y2)
                || (xCoordinate > x3 || yCoordinate > y3)) {

            return false;
        }

        return true;
    }
    
    
    
}


