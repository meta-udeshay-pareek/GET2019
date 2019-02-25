package com.metacube.triangle;

public class Triangle {

	public double getArea(int side1,int side2,int side3){
		 double semiperimeter = (side1 + side2 + side3 )/ 2 ;
		 return Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
	}
}
