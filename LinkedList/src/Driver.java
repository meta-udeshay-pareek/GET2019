import java.util.Scanner;

public class Driver {

	public static void main(String [] args) {

		//scanner object for scanning input
		Scanner scanner = new Scanner(System.in);

		int choice = 0;

		while(true) {

			

			try {
				System.out.println("Enter 0 for exit or 1 for start:");
				choice = scanner.nextInt();
				if(choice==0) {
					System.exit(0);
				}
			}catch (Exception e) {
				System.out.println(e);
			}

			if(choice==1) {
				
				//creatig object of LinkedList
				LinkedList list = new LinkedList();

				//Initializing currentNode with head of LinkedList
				Node currentNode = list.getHead();

				System.out.println("Enter Elements for creating linked list \n enter 0 for exit");



				//Loop for scanning all the element for building LinkedList
				while(scanner.hasNext())
				{
					int element = scanner.nextInt();

					// if user  entered Zero then it will stop to scanning element for linked list
					if(element==0)
						break;

					//adding element one by one at last of linked list and last node reference will be currentNode which is returning by the method
					currentNode = list.addElementAtLast(currentNode, element);
				}


				System.out.println("Enter L R N : ");

				//Scanning position of subList in List and number of rotation
				int L = scanner.nextInt();
				int R = scanner.nextInt();
				int N = scanner.nextInt();

				try {
					//if Input Is not valid it will throw exception
					if(L>R || list.getSize()<R) {
						throw new Exception("Invalid Input ");
					}

					//calling method for applying rotation on subList and updated list is returning by method
					list  = list.rotate(list, L, R, N);

					System.out.print("Your List is->");

					//printing linkedList
					currentNode = list.getHead();
					while(currentNode!=null) {
						System.out.print(currentNode.getData()+"->");
						currentNode=currentNode.getNext();
					}

				}catch (Exception e) {
					System.out.println(e);
				}
			}

		}
	}

}
