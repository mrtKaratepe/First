import java.util.Scanner;

 
public class Main {

	 public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please Select one of them: \n [1]First Come First Served\n [2]Shortest Job First\n [3]Round Robin\n\n Choice:");
		int m=input.nextInt();
		
		if (m==1)
		{
			FCFS();
		}
		else if (m==2)
		{
			System.out.println("SJF Callout.");
		}
		else if (m==3)
		{
			FCFS();
		}
		else
		{
			System.out.println("Opps! Wrong Choice...");
		}
		 
	 }
	 public static void FCFS(){
	  int i,n;
	     float ortalama,beklemesuresý=0;
	     Scanner scan = new Scanner(System.in);
	     System.out.print("Kac Tane Process Isleme Alýnacak ?\t");
	     n = scan.nextInt();
	     int cput[]= new int[n];
	     int bekt[]= new int[n];
	     int art[]=new int[n];
	     for(i=0;i<n;i++)
	     {
		      System.out.print("Cpu Time Giriniz Process "+(i+1)+" :\t");
		      cput[i] = scan.nextInt();
		      System.out.println("Arrival Time giriniz :\t");
		      art[i] = scan.nextInt();
		      art[0]=0;
	     }
	     
	     scan.close();
	     System.out.print("\n\nBekleme Süresi Process 1 : 0 \t");
	     bekt[0]=0;
	     
	     for(i=1;i<n;i++)
	     {
	         bekt[i]=cput[i-1]+bekt[i-1]+art[i-1]-art[i];
	       
	         System.out.print("\nBekleme Süresi Process"+(i+1)+" : "+bekt[i]+" \t");
	         beklemesuresý = beklemesuresý + bekt[i];
	     }
	     
	     System.out.print("\n\nToplam bekleme süresi : "+beklemesuresý);
	     ortalama= beklemesuresý/n;
	     System.out.println("\n\nOrtalama bekleme süresi1 : "+ortalama);
	}
	 public void SJF() {
		
	}
	 
	 public void RoundRobin() {
		
	}


}
