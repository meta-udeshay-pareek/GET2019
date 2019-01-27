package area;
import java.util.*;  

public class Circle implements Shape {
    private final double radius;
    final double pi = Math.PI;

    public Circle() {
         radiousInput();
    }

    private void radiousInput(){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Radious :");
	    this.radius = sc.nextDouble();
	    this.area();
    }
    @Override
    public double area() {
        // A = π r^2
        return pi * Math.pow(this.radius, 2);
    }
}
