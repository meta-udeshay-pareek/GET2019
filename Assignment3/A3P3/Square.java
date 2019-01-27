package area;

import java.util.*;  

/**
*
* @author udeshay
*/
public class Square implements Shape {
   private  double side; //sides

   public Square() {
       sideInput();
   }
   private void sideInput(){
      System.out.println("Enter Side :");
      Scanner sc = new Scanner(System.in);
      this.side = sc.nextDouble();
   }
   @Override
   public double area() {
       // A = w * l
       return this.side*this.side;
   }
}
