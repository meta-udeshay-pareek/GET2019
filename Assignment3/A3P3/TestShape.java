package area;




public class TestShape {
    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("1.Area of Cicle ");
            System.out.println("2.Area of Rectangle ");
            System.out.println("3.Area of Square ");
            System.out.println("4.Area of Triangle ");
            System.out.println("5.Exit ");
            System.out.println("Enter your choice");
            
            choice = input.nextInt();
            
            switch(choice){
                case 1 :
                        Circle circle = new Circle();
                        System.out.println("Area is : - "+circle.area());
                        break;
                case 2:
                        Rectangle rectangle = new Rectangle();
                        System.out.println("Area is : - "+rectangle.area());
                        break;
                case 3:
                        Square square = new Square();
                        System.out.println("Area is : - "+square.area());
                        break;
                case 4:
                        Triangle triangle = new Triangle();
                        System.out.println("Area is : - "+Triangle.area());
                        break;
                case 5:
                        System.exit(0);
                        break;
                default:
                    System.out.println("Invalid Choice");
                    
            }
            
        }
        
    }
}
