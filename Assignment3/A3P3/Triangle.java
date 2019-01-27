package area;


/**
 *
 * @author udeshay
 */
 public class Triangle implements Shape {
	 private final double base , height; // sides

	    
	    public Triangle() {
	        widthHeightInput();
	    }

	  private void widthHeightInput(){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter base :");
	    this.base = sc.nextDouble();
            System.out.println("Enter height :");
	    this.height = sc.nextDouble();
          }
	    @Override
	    public double area() {
	        double result = (this.base*this.height) / 2;
	        return result;
	    }

}
