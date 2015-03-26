import java.util.ArrayList;
import java.util.Scanner;

 
public class Main {
	
	public static Process processGeneral;
	
	
	 public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out
				.println("Please Select one of them: \n [1]First Come First Served\n [2]Shortest Job First\n [3]Round Robin\n [0]for Exit\n\n Choice:");
		int m = input.nextInt();

		if (m == 1) {
			FCFS();
		} else if (m == 2) {
			System.out.println("SJF Callout.");
		} else if (m == 3) {
			System.out.println("Round Robin Callout.");
		} else if (m == 0) {
			System.out.println("Bye Bye......");
		} else {
			System.out.println("Opps! Wrong Choice...");
		}
		 
	 }
	 
	 
	 public static void FCFS(){
		 Scanner input = new Scanner(System.in);
		 ArrayList<Process> FCFSList = new ArrayList<Process>();
		 
		 System.out.println("Please Enter Number of processes: \n");
		 int processNumber=input.nextInt();
		 
		 for(int i=1;i<=processNumber;i++){
			 processGeneral = new Process(Integer.toString(i));
			 System.out.println("Please Enter Cpu Time For Process["+i+"] : \n");
			 processGeneral.setCputTime(input.nextInt());
			 System.out.println("Please Enter Arrival Time For Process["+i+"] : \n");
			 FCFSList.add(processGeneral);
			 
			 
		 }
		 
		 
		 
	 } 
	 
	 
	 public static void SJF() {
		
	 }
	
	
	 
	 public static void RoundRobin() {
		
	 }


}
