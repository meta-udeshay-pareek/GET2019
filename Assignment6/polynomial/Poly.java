import java.util.Arrays;

/*
Implement the immutable class Poly using an array to represent single variable polynomial. 
Note that you should be storing only those terms of polynomial that have non zero coefficient. 
You can assume that the coefficients are integers
It should support methods like - 
evaluate(float) - return the value of the polynomial for the given value of the variable
degree() - return the degree of the polynomial
addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1 and p2
multiplyPoly(Poly p1, Poly p2) - return the product of polynomials p1 and p2
You may use private helper methods. addPoly() and multiplyPoly() can make assumptions 
about size of the resulting polynomial to decide about the size of the array to be created.
*/
public class Poly {
    //Power and coefficient  of polynomial
    private int power[];
    private int coeff[];
    
    
    //initialising a polynomial
    public Poly(int power[],int coeff[]){
        int n = power.length;
        this.power = new int[n];
        this.coeff = new int[n];
        for(int i=0; i<n; i++){
            this.power[i] = power[i];
            this.coeff[i] = coeff[i];
        }
    }
    
    //returning power of polynomial
    public int[] getPower(){
        return Arrays.copyOf(power,power.length);
    }
    
   //returning coefficient array of polynomial
    public int[] getCoeff(){
        return Arrays.copyOf(coeff, coeff.length);
    }
    
   //evaluating polynomial by putting value at place of variable
   //x^2+x+1 so x=val
    public double evaluate(float val){
        int n = coeff.length;
        double result=0;
        double pow_result;
        for(int i = 0; i < n; i++){
            pow_result = 1;
            for(int pow = 0; pow < power[i]; pow++){
               pow_result = pow_result * val;  
            }
            result += coeff[i] * pow_result;
        }
        return result;
    }
    
    //returning degree of polynomial
    //x^2+x+1    degree wil be 2
    public int degree(){
        int degree = power[0];
        for(int i = 1; i < power.length; i++)
            if(power[i] > degree )
                degree = power[i];
        return degree;
    }
    
    /*@param p1 polynomial one 
     *@param p2 polynomial two
     *@return p3=p1*p2
    **/
    public Poly multiplyPoly(Poly p1,Poly p2){
        int n1 = p1.power.length;
        int n2 = p2.power.length;
        int resultPolyPower[] = new int[n1*n2];
        int resultPolyCoeff[] = new int[n1*n2];
        int k =0;
        for(int i=0;i < n1;i++){
            for(int j=0; j < n2; j++){
                resultPolyPower[k] = p1.power[i]+p2.power[j];
                resultPolyCoeff[k] = p1.coeff[i]*p2.coeff[j];
                k++;
            }
        }
        Poly resultPoly = new Poly(resultPolyPower,resultPolyCoeff);
        sort(resultPoly);
        int countSamePower =0;
        for(int i=0; i< n1*n2-1;){
            if(resultPoly.power[i] == resultPoly.power[i+1]){
                countSamePower++;
                resultPoly.coeff[i] = resultPoly.coeff[i] + resultPoly.coeff[i+1];
                for(int j = i+1; j < n1*n2 -countSamePower ; j++){
                    resultPoly.power[i] = resultPoly.power[i+1];
                    resultPoly.coeff[i] = resultPoly.coeff[i+1];
                }
            }
            i++;
        }
        int multPower[] = new int[n1*n2-countSamePower];
        int multCoeff[] = new int[n1*n2-countSamePower];
        for(int i = 0; i< multPower.length; i++){
            multPower[i] = resultPolyPower[i];
            multCoeff[i] = resultPolyCoeff[i];
        }
        return new Poly(multPower,multCoeff);
    }
    

   /*@param p1 polynomial one 
     *@param p2 polynomial two
     *@return p3=p1+p2
    **/
    public Poly addPoly(Poly p1,Poly p2){
        sort(p1);
        sort(p2);
        //resultant polynomial with approximating size more than actual
        int n1 = p1.power.length;
        int n2 = p2.power.length;
        int resultPolyPower[] = new int[n1+n2];
        int resultPolyCoeff[] = new int[n1+n2];
        int i,j,k;
        for(i =0,j=0,k=0; i < n1 && j < n2 && k < n1+n2; k++){
            if(p1.power[i] > p2.power[j]){
                resultPolyPower[k] = p1.power[i];
                resultPolyCoeff[k] = p1.coeff[i];
                i++;
            }
            else if(p1.power[i] < p2.power[j]){
                resultPolyPower[k] = p2.power[j];
                resultPolyCoeff[k] = p2.coeff[j];
                j++;
            }
            else{
                resultPolyPower[k] = p2.power[j];
                resultPolyCoeff[k] = p1.coeff[i] + p2.coeff[j];
                i++;
                j++;
            }
        }
        if(i >= n1){
            while(j < n2){
                resultPolyPower[k] = p2.power[j];
                resultPolyCoeff[k] = p2.coeff[j];
                j++;
                k++;
            }
        }
        if(j >= n2){
            while(i < n1){
                resultPolyPower[k] = p1.power[i];
                resultPolyCoeff[k] = p1.coeff[i];
                i++;
                k++;
            }
        }
        // resultant polynomial of exact size 
        int added_pow[] = new int[k];
        int added_coeff[] = new int[k];
        for(int index =0; index < k; index++){
            added_pow[index] = resultPolyPower[index];
            added_coeff[index] = resultPolyCoeff[index];
        }  
        return new Poly(added_pow,added_coeff);
    }
    
    //sorting polynomial coefficient and power array
    private void sort(Poly poly){
        int n = poly.power.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(poly.power[i] < poly.power[j]){
                    int temp_pow = poly.power[i];
                    poly.power[i] = poly.power[j];
                    poly.power[j] = temp_pow;
                    
                    int temp_coeff = poly.coeff[i];
                    poly.coeff[i] = poly.coeff[j];
                    poly.coeff[j] = temp_coeff;
                }
            }
        }
    }
}_
