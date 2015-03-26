import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Process processGeneral;
	public static ArrayList<Process> FCFSList = new ArrayList<Process>();
	public static int processNumber, CurrentTime = 0;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please Enter Number of processes: \n");
		processNumber = input.nextInt();

		for (int i = 1; i <= processNumber; i++) {
			processGeneral = new Process(Integer.toString(i));
			System.out.println("Please Enter Cpu Time For Process[" + i
					+ "] : \n");
			processGeneral.setCpuTime(input.nextInt());
			System.out.println("Please Enter Arrival Time For Process[" + i
					+ "] : \n");
			processGeneral.setArrivalTime(input.nextInt());
			FCFSList.add(processGeneral);
		}

		System.out
				.println("Please Select one of them: \n [1]First Come First Served\n [2]Shortest Job First\n [3]Round Robin\n [0]for Exit\n\n Choice:");
		int m = input.nextInt();

		if (m == 1) {
			FCFS();
		} else if (m == 2) {
			NonPreemptiveSJF();
		} else if (m == 3) {
			System.out.println("Round Robin Callout.");
		} else if (m == 0) {
			System.out.println("Bye Bye......");
		} else {
			System.out.println("Opps! Wrong Choice...");
		}

	}

	public static void NonPreemptiveSJF() {
		
		BringMinArrivalTimeProcess();
		
		for(int i=1;i<=processNumber;i++){
			
			BringMinCpuTime();
			CurrentTime = CurrentTime + processGeneral.getCpuTime();
			processGeneral.setCompletionTime(CurrentTime);
		}
		
		for (int i = 0; i < processNumber; i++) {
			processGeneral = FCFSList.get(i);
			int waitingTime = processGeneral.getCompletionTime()
					- processGeneral.getArrivalTime()
					- processGeneral.getCpuTime();
			processGeneral.setWaitingTime(waitingTime);

		}
		
		
		
		PrintProcesses();
		System.out.print("\n Average Waiting Time= ");
		int average = 0;

		for (int i = 0; i < FCFSList.size(); i++) {
			average = average + FCFSList.get(i).getWaitingTime();
		}
		average = average / FCFSList.size();
		System.out.print(average);
		
		
		
		
		
	}

	public static void FCFS() {

		for (int i = 1; i <= processNumber; i++) {

			BringMinArrivalTimeProcess();
			CurrentTime = CurrentTime + processGeneral.getCpuTime();
			processGeneral.setCompletionTime(CurrentTime);

		}

		for (int i = 0; i < processNumber; i++) {
			processGeneral = FCFSList.get(i);
			int waitingTime = processGeneral.getCompletionTime()
					- processGeneral.getArrivalTime()
					- processGeneral.getCpuTime();
			processGeneral.setWaitingTime(waitingTime);

		}

		PrintProcesses();
		System.out.print("\n Average Waiting Time= ");
		int average = 0;

		for (int i = 0; i < FCFSList.size(); i++) {
			average = average + FCFSList.get(i).getWaitingTime();
		}
		average = average / FCFSList.size();
		System.out.print(average);

	}

	private static void PrintProcesses() {
		System.out
				.println("---------------------------------------CPU SCHEDULE RESULT----------------------------------------------");
		System.out
				.println("P.NAME          CPU TIME          ARRIVAL TIME          COMP. TIME          WAITING TIME");

		for (int i = 0; i < FCFSList.size(); i++) {
			processGeneral = FCFSList.get(i);
			System.out.print("P" + processGeneral.getProcessName()
					+ "                 ");
			System.out
					.print(processGeneral.getCpuTime() + "                  ");
			System.out.print(processGeneral.getArrivalTime()
					+ "                     ");
			System.out.print(processGeneral.getCompletionTime()
					+ "                    ");
			System.out.print(processGeneral.getWaitingTime()
					+ "                    ");
			System.out.println("");
		}

	}
	
	private static void BringMinCpuTime() {
		int cnt = 0;
		processGeneral = FCFSList.get(cnt);
		while (processGeneral.getCompletionTime() != 0) {
			processGeneral = FCFSList.get(cnt);
			cnt++;
		}

		for (int i = 0; i < FCFSList.size(); i++) {

			if (FCFSList.get(i).getCompletionTime() == 0 && FCFSList.get(i).getArrivalTime() < CurrentTime) {
				if (FCFSList.get(i).getCpuTime() < processGeneral
						.getCpuTime()) {
					processGeneral = FCFSList.get(i);
				}
			}
		}
	}

	private static void BringMinArrivalTimeProcess() {
		int cnt = 0;
		processGeneral = FCFSList.get(cnt);
		while (processGeneral.getCompletionTime() != 0) {
			processGeneral = FCFSList.get(cnt);
			cnt++;
		}

		for (int i = 0; i < FCFSList.size(); i++) {

			if (FCFSList.get(i).getCompletionTime() == 0) {
				if (FCFSList.get(i).getArrivalTime() <= processGeneral
						.getArrivalTime()) {
					processGeneral = FCFSList.get(i);
				}
			}
		}
	}

	public static void RoundRobin() {

	}

}
