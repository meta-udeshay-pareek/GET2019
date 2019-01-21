package area;

/**
*
* @author udeshay
*/
public class Square extends Shape {
   private final double side; //sides

   public Square(double side) {
       this.side = side;
   }

   @Override
   public double area() {
       // A = w * l
       return side*side;
   }
}