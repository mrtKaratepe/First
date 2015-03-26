
public class Process {
	
	private String ProcessName;
	private int CpuTime;
	private int ArrivalTime;
	private int CompletionTime;
	private int WaitingTime;
	
	
	public Process(String processName) {
		super();
		ProcessName = processName;
		this.ArrivalTime=0;
		this.CompletionTime=0;
		this.WaitingTime=0;
	}

	
	
	public Process(Process p) {
		this.ProcessName=p.ProcessName;
		this.CpuTime=p.CpuTime;
		this.ArrivalTime=p.ArrivalTime;
		this.CompletionTime=p.CompletionTime;
		this.WaitingTime=p.WaitingTime;
		
	}



	public String getProcessName() {
		return ProcessName;
	}


	public void setProcessName(String processName) {
		ProcessName = processName;
	}


	public int getCpuTime() {
		return CpuTime;
	}


	public void setCpuTime(int cputTime) {
		CpuTime = cputTime;
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
