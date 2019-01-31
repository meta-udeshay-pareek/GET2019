package graphics;

public class Point{
	private int x;
	private int y;
	
	
	Point(int x, int y) throws InvalidCoordinate{
		if( x < 0 || y < 0) {
			throw new InvalidCoordinate("Coordinates exceed screen size!");
		}
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Custom Exception class 
	 * @author User29
	 *
	 */
	class InvalidCoordinate extends Exception{
		
		InvalidCoordinate(String exception){
			
			super(exception);
		}
	}
	
	/**
	 * 
	 * @return - X coordinate of Point
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @return - Y coordinate of Point
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Calculate distance between Both points
	 * @param point - Second point
	 * @return - Distance between both point
	 */
	public double distanceFromPoint(Point point) {
		
		return Math.sqrt(Math.pow((point.getX() - this.getX()), 2) + Math.pow(( point.getY() - this.getY() ), 2));
	}
}
