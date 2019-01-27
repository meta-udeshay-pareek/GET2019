package area;
import java.util.*;  

public class Circle extends Shape {
    private final double radius;
    final double pi = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    private double radiousInput(){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Radious :");
	    int r = sc.nextDouble();
	    return r;
    }
    @Override
    public double area() {
        // A = π r^2
        return pi * Math.pow(radiousInput(), 2);
    }
}
