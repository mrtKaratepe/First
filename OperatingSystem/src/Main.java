import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Process processGeneral;
	public static ArrayList<Process> ProcessList = new ArrayList<Process>();
	public static ArrayList<Process> CopyProcessList = new ArrayList<Process>();
	public static int processNumber, CurrentTime = 0;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out
				.println("Please Select one of them: \n [1]First Come First Served\n [2]Shortest Job First(Non Preemptive)\n [3]Shortest Job First(Preemptive)\n [4]Round Robin\n [0]for Exit\n\n Choice:");
		int m = input.nextInt();

		if (m == 1) {
			FillProcessList();
			FCFS();
		} else if (m == 2) {
			FillProcessList();
			NonPreemptiveSJF();
		} else if (m == 3) {
			FillProcessList();
			PreemptiveSJF();
		} else if (m == 4) {

			System.out.println("Please Enter Number of processes: \n");
			processNumber = input.nextInt();

			for (int i = 1; i <= processNumber; i++) {
				processGeneral = new Process(Integer.toString(i));
				System.out.println("Please Enter Cpu Time For Process[" + i
						+ "] : \n");
				processGeneral.setCpuTime(input.nextInt());
				ProcessList.add(processGeneral);
			}

			RoundRobin();
		} else if (m == 0) {
			System.out.println("Bye Bye......");
		} else {
			System.out.println("Opps! Wrong Choice...");
		}

	}

	public static void PreemptiveSJF() {

		for (int i = 0; i < ProcessList.size(); i++) {

			Process p = new Process(ProcessList.get(i));
			CopyProcessList.add(p);

		}
		int sumOfCpuTimes = 0;
		for (int i = 0; i < ProcessList.size(); i++) {
			sumOfCpuTimes += ProcessList.get(i).getCpuTime();
		}
		BringMinArrivalTimeProcess();

		while (sumOfCpuTimes >= 0) {

			if (processGeneral.getCpuTime() > 0) {
				CurrentTime++;
				processGeneral.setCpuTime(processGeneral.getCpuTime() - 1);
				sumOfCpuTimes--;
			}else if(processGeneral.getCpuTime() == 0){
				processGeneral.setCompletionTime(CurrentTime);
				if(processGeneral.getCpuTime() == 0 && processGeneral.getProcessName().equalsIgnoreCase("1")){
					sumOfCpuTimes--;
				}
			}
			
			if(processGeneral.getCpuTime() == 0 && processGeneral.getProcessName().equalsIgnoreCase("1")){
				
			}else{
				BringMinCpuTime();
			}
		}

		for(int i=0;i<ProcessList.size();i++){
			ProcessList.get(i).setCpuTime(CopyProcessList.get(i).getCpuTime());
		}
		
		
		for (int i = 0; i < processNumber; i++) {
			processGeneral = ProcessList.get(i);
			int waitingTime = processGeneral.getCompletionTime()
					- processGeneral.getArrivalTime()
					- processGeneral.getCpuTime();
			processGeneral.setWaitingTime(waitingTime);

		}

		PrintProcesses();
		System.out.print("\n Average Waiting Time= ");
		int average = 0;

		for (int i = 0; i < ProcessList.size(); i++) {
			average = average + ProcessList.get(i).getWaitingTime();
		}
		average = average / ProcessList.size();
		System.out.print(average);

	}

	public static void RoundRobin() {

		for (int i = 0; i < ProcessList.size(); i++) {

			Process p = new Process(ProcessList.get(i));
			CopyProcessList.add(p);

		}
		Scanner input = new Scanner(System.in);
		int totalCpuTime = 0;
		int count = 0;
		System.out.println("Please Enter QUANTUM Number for Round Robin: \n");
		int quantum = input.nextInt();

		for (int i = 0; i < CopyProcessList.size(); i++) {
			totalCpuTime += CopyProcessList.get(i).getCpuTime();
		}

		while (CurrentTime < totalCpuTime) {

			if (count >= CopyProcessList.size()) {
				count = 0;
			}

			if (CopyProcessList.get(count).getCompletionTime() == 0) {
				if ((CopyProcessList.get(count).getCpuTime() - quantum) <= 0) {
					CurrentTime += CopyProcessList.get(count).getCpuTime();
					ProcessList.get(count).setCompletionTime(CurrentTime);
					CopyProcessList.get(count).setCompletionTime(CurrentTime);
					CopyProcessList.get(count).setCpuTime(0);
				} else {
					CopyProcessList.get(count).setCpuTime(
							CopyProcessList.get(count).getCpuTime() - quantum);
					CurrentTime += quantum;
				}
			}
			count++;
		}

		for (int i = 0; i < processNumber; i++) {
			processGeneral = ProcessList.get(i);
			int waitingTime = processGeneral.getCompletionTime()
					- processGeneral.getArrivalTime()
					- processGeneral.getCpuTime();
			processGeneral.setWaitingTime(waitingTime);

		}

		PrintProcesses();
		System.out.print("\n Average Waiting Time= ");
		int average = 0;

		for (int i = 0; i < ProcessList.size(); i++) {
			average = average + ProcessList.get(i).getWaitingTime();
		}
		average = average / ProcessList.size();
		System.out.print(average);

	}

	public static void NonPreemptiveSJF() {

		BringMinArrivalTimeProcess();

		for (int i = 1; i <= processNumber; i++) {

			BringMinCpuTime();
			CurrentTime = CurrentTime + processGeneral.getCpuTime();
			processGeneral.setCompletionTime(CurrentTime);
		}

		for (int i = 0; i < processNumber; i++) {
			processGeneral = ProcessList.get(i);
			int waitingTime = processGeneral.getCompletionTime()
					- processGeneral.getArrivalTime()
					- processGeneral.getCpuTime();
			processGeneral.setWaitingTime(waitingTime);

		}

		PrintProcesses();
		System.out.print("\n Average Waiting Time= ");
		int average = 0;

		for (int i = 0; i < ProcessList.size(); i++) {
			average = average + ProcessList.get(i).getWaitingTime();
		}
		average = average / ProcessList.size();
		System.out.print(average);

	}

	public static void FCFS() {

		for (int i = 1; i <= processNumber; i++) {

			BringMinArrivalTimeProcess();
			CurrentTime = CurrentTime + processGeneral.getCpuTime();
			processGeneral.setCompletionTime(CurrentTime);

		}

		for (int i = 0; i < processNumber; i++) {
			processGeneral = ProcessList.get(i);
			int waitingTime = processGeneral.getCompletionTime()
					- processGeneral.getArrivalTime()
					- processGeneral.getCpuTime();
			processGeneral.setWaitingTime(waitingTime);

		}

		PrintProcesses();
		System.out.print("\n Average Waiting Time= ");
		int average = 0;

		for (int i = 0; i < ProcessList.size(); i++) {
			average = average + ProcessList.get(i).getWaitingTime();
		}
		average = average / ProcessList.size();
		System.out.print(average);

	}

	private static void PrintProcesses() {
		System.out
				.println("---------------------------------------CPU SCHEDULE RESULT----------------------------------------------");
		System.out
				.println("P.NAME          CPU TIME          ARRIVAL TIME          COMP. TIME          WAITING TIME");

		for (int i = 0; i < ProcessList.size(); i++) {
			processGeneral = ProcessList.get(i);
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
		processGeneral = ProcessList.get(cnt);
		while (processGeneral.getCompletionTime() != 0) {
			processGeneral = ProcessList.get(cnt);
			cnt++;
		}

		for (int i = 0; i < ProcessList.size(); i++) {

			if (ProcessList.get(i).getCompletionTime() == 0
					&& ProcessList.get(i).getArrivalTime() <= CurrentTime) {
				if (ProcessList.get(i).getCpuTime() < processGeneral
						.getCpuTime()) {
					processGeneral = ProcessList.get(i);
				}
			}
		}
	}

	private static void BringMinArrivalTimeProcess() {
		int cnt = 0;
		processGeneral = ProcessList.get(cnt);
		while (processGeneral.getCompletionTime() != 0) {
			processGeneral = ProcessList.get(cnt);
			cnt++;
		}

		for (int i = 0; i < ProcessList.size(); i++) {

			if (ProcessList.get(i).getCompletionTime() == 0) {
				if (ProcessList.get(i).getArrivalTime() <= processGeneral
						.getArrivalTime()) {
					processGeneral = ProcessList.get(i);
				}
			}
		}
	}

	private static void FillProcessList() {
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
			ProcessList.add(processGeneral);
		}

	}
}
