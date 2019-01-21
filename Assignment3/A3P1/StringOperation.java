package stringoperation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author udeshay
 */


public class StringOperation {

    //input string  used in inputString() Method
    String str1,str2;
    
    /**
    * @param String1,String2   for comparison
    * @return 1 (if both string are equal) 0(if they are not equal)
    */
    int compareString(String s1,String s2){
        int status=1;//if both string are equal then status=1
        
        //if length not equal then string will not be equal
        if(s1.length()!=s2.length()){
            return 0;
        }        
        else{
            for(int i=0;i<s1.length();i++){
                //if any character mismatch then string not equal 
                if(s1.charAt(i)!=s2.charAt(i))
                    return 0;
            }
        }
        return status;
    }
    
    /**
    * @param String s  for reverse it
    * @return reverse of the string
    */
    String reverseString(String s){
        String reverse="";
        
        for ( int i = s.length() - 1 ; i >= 0 ; i-- ){
            reverse = reverse + s.charAt(i);
        }
       
        return reverse;
    }
    
    /**
    * @param String s  for Convert characters of a string to opposite case
    * @return a string
    */
    String convertOpposite(String s) 
     { 
        StringBuffer str = new StringBuffer(s);
        
             
        // Conversion using predefined methods 
        for (int i=0; i<str.length(); i++) 
        { 
            Character c = str.charAt(i); 
            if (Character.isLowerCase(c)) 
                str.replace(i, i+1, Character.toUpperCase(c)+""); 
            else
                str.replace(i, i+1, Character.toLowerCase(c)+"");     
        } 
        
        //converson stringBuffer to String
        return (str.toString());
     } 
    
    /**
    * @param String s  for returning longest word in that
    * @return a string which is longest word in string
    */
    String longestWord(String str) 
    { 
        String[] words = str.split(" "); 
        String longestWord=" ";
        int length = 0; 
          
        for(String word:words){ 
            if(length < word.length()||length==word.length()){ 
                length = word.length(); 
                longestWord = word;
            }  
        } 
        return longestWord; 
    } 

    
    /**
    * @return a integer which is user Choice
    */
    int choiceMenu(){
        Scanner input = new Scanner(System.in);
        int userChoice=0;
        System.out.println("1.compare two String");
        System.out.println("2.Reverse String");
        System.out.println("3.Conver String into opposite case charecter:");
        System.out.println("4.Find longest word in String:");
        System.out.println("5.Exit");

        System.out.print("Enter Your Choice:-");
        userChoice = input.nextInt();
        return userChoice;
    }
    
    /**
     * @param userChoice=number of string as a input require for operation
     */
    void inputString(int userChoice){
        Scanner input = new Scanner(System.in);
        if(userChoice==1){
            System.out.println("Enter String1:-");
            str1=input.nextLine(); 
            System.out.println("Enter String12:-");
            str2=input.nextLine(); 
            
        }else if (userChoice>1&&userChoice<5){
           System.out.println("Enter your String:-");
           str1=input.nextLine(); 
        }else if (userChoice>5){
        	System.out.println("Invalid Choice");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userChoice;
        //object Creation
        StringOperation stringOperation = new StringOperation();
        
        while(true){
	        //menu for different choice which return user choice
	        userChoice=stringOperation.choiceMenu();
	        
	        //String Input process
	        stringOperation.inputString(userChoice);
	        
	        switch(userChoice){
	            case 1:
	                System.out.println(stringOperation.compareString(stringOperation.str1, stringOperation.str2));
	                break;
	            case 2:
	               System.out.println(stringOperation.reverseString(stringOperation.str1));
	               break;
	            case 3:
	                System.out.println(stringOperation.convertOpposite(stringOperation.str1));
	                break;
	            case 4:
	                System.out.println(stringOperation.longestWord(stringOperation.str1));
	                break;
	            case 5:
	                System.exit(0);
	                break;
	            default:
	                System.out.println("Enter Valid Choice.");
	        }
        }
        
        
    }
    
}
