package area;

import java.util.*;  

/**
*
* @author udeshay
*/
public class Rectangle implements Shape {
   private  double width, length; //sides

   public Rectangle() {
       widthHeightInput();
   }

   private void widthHeightInput(){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter width :");
	    this.width = sc.nextDouble();
       System.out.println("Enter height :");
	    this.length = sc.nextDouble();
    }
   @Override
   public double area() {
       // A = w * l
       return this.width * this.length;
   }

}

