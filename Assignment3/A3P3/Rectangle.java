package area;

/**
*
* @author udeshay
*/
public class Rectangle extends Shape {
   private final double width, length; //sides

   public Rectangle(double width, double length) {
       this.width = width;
       this.length = length;
   }

   @Override
   public double area() {
       // A = w * l
       return width * length;
   }

}
