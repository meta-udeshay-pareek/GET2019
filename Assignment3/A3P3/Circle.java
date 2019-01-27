/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package area;

import java.util.*;  

public class Circle implements Shape {
    private  double radius;
    final double pi = Math.PI;

    public Circle() {
         radiousInput();
    }

    private void radiousInput(){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Radious :");
	    this.radius = sc.nextDouble();
    }
    @Override
    public double area() {
        // A = π r^2
        return pi * Math.pow(this.radius, 2);
    }
}
