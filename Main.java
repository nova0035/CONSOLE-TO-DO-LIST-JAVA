import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		File f = new File("task.txt");
		int mainMenuChoice = -1;

		try{

			System.out.println("\n- - - - - - - - - - - TO DO LIST - - - - - - - - - - -\n");
			
			do{

				ArrayList<String> tasks = new ArrayList<String>();

				Scanner fileObj = new Scanner(f);

				if(fileObj.hasNextLine()){

					System.out.println("Current Tasks\n");					
					int counter = 1;
					while(fileObj.hasNextLine()){

						String task = fileObj.nextLine();
						System.out.println(counter + " " +task);
						tasks.add(task);
						counter ++;
					}
				}

				else{

					System.out.println("\nList Is Empty .....");
				}

				System.out.println("\n1) Add A Task");
				System.out.println("2) Remove A Task");
				System.out.println("3) Clear All Task");
				System.out.println("0) Exit");

				System.out.print("\n_ : ");
				mainMenuChoice = scan.nextInt();

				switch(mainMenuChoice){

					case 1:

						System.out.println("\nAdd A Task");

						System.out.print("\nEnter Task : ");
						String newTask = scan.next();
						newTask += scan.nextLine();

						FileWriter fw = new FileWriter("task.txt",true);
						fw.append(newTask + "\n");
						fw.close();

						break;

					case 2:

						System.out.println("\nRemove A Task");

						System.out.print("\nEnter Task Number : ");
						int taskNum = scan.nextInt();

						if(taskNum != 0){
							taskNum --;
						}

						if(taskNum <= tasks.size()){
							tasks.remove(taskNum);

							FileWriter fw2 = new FileWriter("task.txt");
							fw2.write("");

							for(String task : tasks){
								fw2.append(task + "\n");
							}

							fw2.close();
						}
						else{
							System.out.println("\nTask Number Not Found");
						}

						break;
						
					case 3:

					    System.out.println("\nClear All Tasks");

					    FileWriter fw3 = new FileWriter("task.txt");
					    fw3.write(""); // Clear the content of the file

					    fw3.close();
					    break;

					case 0:

						System.out.println("\nTO DO LIST EXITED .....");
						break;

					default:
						System.out.println("\nPlease Enter Valid Choice .....");
						break;
				}

			}
			
			while(mainMenuChoice != 0);

		}


		catch(Exception e){

		}
	}
}
