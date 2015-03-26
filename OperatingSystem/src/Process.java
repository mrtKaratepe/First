
public class Process {
	
	private String ProcessName;
	private int CputTime;
	private int ArrivalTime;
	private int CompletionTime;
	private int WaitingTime;
	
	
	public Process(String processName) {
		super();
		ProcessName = processName;
	}


	public String getProcessName() {
		return ProcessName;
	}


	public void setProcessName(String processName) {
		ProcessName = processName;
	}


	public int getCputTime() {
		return CputTime;
	}


	public void setCputTime(int cputTime) {
		CputTime = cputTime;
	}


	public int getArrivalTime() {
		return ArrivalTime;
	}


	public void setArrivalTime(int arrivalTime) {
		ArrivalTime = arrivalTime;
	}


	public int getCompletionTime() {
		return CompletionTime;
	}


	public void setCompletionTime(int completionTime) {
		CompletionTime = completionTime;
	}


	public int getWaitingTime() {
		return WaitingTime;
	}


	public void setWaitingTime(int waitingTime) {
		WaitingTime = waitingTime;
	}
	
	
	
	
	
}
