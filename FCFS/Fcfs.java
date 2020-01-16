package com.sid.FCFS;

import java.util.Scanner;

public class Fcfs {
 
	public static void main(String[] args) {
		int i,process,total=0;
		int PID[]=new int[10];
		int arrTime[]=new int[10];
		int bTime[]=new int[10];
		int compTime[]=new int[10];
		int TAT[]=new int[10];
		int waitTime[]=new int[10];
		float average=0.00f;
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter number of processes:");
		process=input.nextInt();
		
		System.out.println("Enter process IDs:");
		for ( i = 0; i< process; i++) {
			PID[i]=input.nextInt();
		}
		
		System.out.println("Enter arrival time:");
		for ( i = 0; i < process; i++) {
			arrTime[i]=input.nextInt();
		}
		
		System.out.println("Enter burst time:");
		for ( i = 0; i < process; i++) {
			bTime[i]=input.nextInt();
		}
		
		compTime[0]=arrTime[0]+bTime[0];
		for ( i = 0; i < process; i++) {
			if(arrTime[i+1]<=compTime[i])
				compTime[i+1]=compTime[i]+bTime[i+1];
			else
				compTime[i+1]=arrTime[i+1]+bTime[i+1];
		}
		
		System.out.println("The completion time:");
		for ( i = 0; i < process; i++) {
			System.out.println(compTime[i]);
		}
		
		System.out.println("Turn Around Time:");
		for (i = 0; i < process; i++) {
			TAT[i]=compTime[i]-arrTime[i];
		}
		for (i = 0; i < process; i++) {
			System.out.println(TAT[i]);
		}
		
		System.out.println("Waiting Time:");
		for (i = 0; i < process; i++) {
			waitTime[i]=TAT[i]-bTime[i];
		}
		for (i = 0; i < process; i++) {
			System.out.println(waitTime[i]);
		}
		System.out.println("PID  arrivalTime  burstTime  completionTime  TurnAroundTime  waitTime");
		for ( i = 0; i < process; i++) {
			System.out.println(PID[i]+"\t"+arrTime[i]+"\t \t"+bTime[i]+"\t"+compTime[i]+"\t \t"+TAT[i]+"\t \t"+waitTime[i]);
		}
		
		System.out.println("Average Waiting Time:");
		for (i = 0; i < process; i++) {
			total=waitTime[i]+total;
		}
		average=total/process;
		System.out.println(average);
		input.close();
	}

}
