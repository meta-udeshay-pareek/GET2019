import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Command {

	Folder currentFolder;//in which folder you are working currently
	List<String> folders = new ArrayList<String>();//for keeping hierarchy of folder 



	/*
	 * @return currentFolder, in which folder you are working currently
	 * */
	public Folder getCurrentFolder() {
		return currentFolder;
	}

	/*
	 * @param currentFolder
	 * */
	public void setCurrentFolder(Folder currentFolder) {
		this.currentFolder = currentFolder;
	}

	/*
	 * @return List folder 
	 * */
	public List<String> getFolders() {
		return folders;
	}

	/*
	 * Constructor
	 * */
	public Command() {
		currentFolder = new Folder("R");//root folder(Directory) created
	}


	/*
	 * Flow of Virtual command prompt will start from here
	 *  */
	public void runVcp() {
		
		String inputCommand;//input command for perform operation 
		Scanner input = new Scanner(System.in);//input object for taking input

		//infinite loop ..will break when user will give "exit" command
		while(true) {
			
			printPath();//calling private method for printing current folder path on command prompt
			inputCommand = input.nextLine();//taking input from cmd for command

			String [] commands = inputCommand.split(" ");//Splitting command using spaces for separating command and folder name

			//if command contain only single string then 
			if(commands.length==1) {

				switch (commands[0]) {

				case "bk":
					bk();//bk() method of this class will call
					break;

				case "ls":
					ls();//ls() method of this class will call
					break;

				case "tree":
					tree();//tree() method of this class will call
					break;
				case "exit":
					System.exit(0);//will exit from this program
					break;

				default:
					System.out.println("Command Not found");
				}
			}


			else if(commands.length==2) {

				switch (commands[0]) {

				case "mkdir":
					mkdir(commands[1]);//mkdir() method of this class will call
					break;

				case "cd":
					cd(commands[1]);//cd() method of this class will call
					break;

				case "find":
					find(commands[1]);//cd() method of this class will call
					break;

				default:
					System.out.println("Command Not found");
				}
			}

		}
	}




	/*
	 * @param folderName,new folder name which is going to be create in this current folder
	 * 
	 * */
	public void mkdir(String folderName) {
		
		//status of new folder creation in current folder with given name
		boolean status = this.getCurrentFolder().mkdir(folderName);
		
		//if folder is already exist with same name then new folder cann't create with given name
		if(status == false) {
			System.out.println("folder already exist with same name then new folder will not create");
		}

	}

	/*
	 *  @param folderName,sub folder name  which is going to be current folder now
	 *  */
	public void cd(String folderName) {
		Folder subFolder = this.getCurrentFolder().cd(folderName);
		if(subFolder!=null) {
			this.setCurrentFolder(subFolder);
			this.folders.add(subFolder.getName());
		}else {
			System.out.println("folder doesn't exist with this name");
		}
	}

	
	/*
	 *  @param folderName,for finding folder recursively in current folder in it's sub folder as well
	 *  */
	public void find(String folderName) {
		Folder foundFolder = this.getCurrentFolder().find(folderName);
		if(foundFolder!=null) {
			String path = getPathOfFolder(foundFolder);
			System.out.println(path);
		}else {
			System.out.println("Not Found");
		}
	}

	/*
	 * @param foundFolder, for finding path of given folder
	 * @param path, path of foundFolder in string form
	 * */
	private String getPathOfFolder(Folder foundFolder) {
		
		//setting currentFolder to foundFoder as from there only you will reach to it's parent
		Folder currentFolder = foundFolder;
		
		//making a stack for maintaining the hierarchy
		Stack<String> folders = new Stack<String>();
		
		//path as string 
		String path = new String(" ");

		//moving from current folder to towards it's parent and recursively doing this until reach null because null is parent of root
		//and continuously pushing current folder in stack
		while(currentFolder!=null) {
			folders.push(currentFolder.getName());
			currentFolder = currentFolder.getParent();
		}
	
		//popping folders'name one by one as it will start from root because at last root was pushed 
		//we will pop until stack get empty
		while(!folders.empty()) {
			path=path+"/"+folders.pop();//adding folder in path 
		}
		
		//returning whole path of folder
		return path;
	}

	
	/*
	 * moving form current directory to it's parent directory 
	 * */
	public void bk() {
		
		if(this.getCurrentFolder().getParent()!=null) {
			//setting or moving from current folder to it's parent folder
			this.setCurrentFolder(this.getCurrentFolder().getParent());
			
			//removing last folder name from list 
			this.folders.remove(this.folders.size()-1);
		}
		
	}

	/*
	 * will print all the subFolder in this folder
	 * */
	public void ls() {
		List<Folder> subFolders = this.getCurrentFolder().ls();
		
		for(Folder subFolder :subFolders ) {
			System.out.println(subFolder.getDateAndTime()+"  "+subFolder.getName());
		}
	}

	public void tree() {
		printTree(this.getCurrentFolder(),0);
	
	}

	 /**
     * method to display the tree of the given directory
     * 
     * @param currentDirectory
     * @param nesting          is the level of the subfolder
     */

    private void printTree(Folder currentDirectory, int nesting) {
        for (Folder subDirectory : currentDirectory.getSubFolders()) {
            for (int i = 0; i < nesting; i++)
                System.out.print("|    ");
            if (subDirectory.getSubFolders().size() != 0) {
                System.out.println("|---" + subDirectory.getName());
                printTree(subDirectory, nesting + 1);
            } else
                System.out.println("|___" + subDirectory.getName());
        }
    }

	/*
	 * Will print the whole path of current working directory
	 * */
	private void printPath() {
		System.out.print("R:");
		for(String folderName : this.getFolders()) {
			System.out.print("\\" + folderName );
		}

		System.out.print(">");
	}
	
	//main method
	public static void main(String [] args) {
		Command command = new Command();
		command.runVcp();
	}

}
