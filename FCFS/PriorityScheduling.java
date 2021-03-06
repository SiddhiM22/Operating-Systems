package com.sid.FCFS;
import java.util.*;

public class PriorityScheduling {
	void PrioritySort(int bTime[], int PID[],int priority[], int process) {

		for (int i = 0; i < process; i++)
			for (int j = 0; j < process - i - 1; j++)
				if (priority[j] > priority[j + 1]) {
					
					int temp = priority[j];
					priority[j] = priority[j + 1];
					priority[j + 1] = temp;

// swap PID[j+1] and PID[i];
					int temp1 = PID[j];
					PID[j] = PID[j + 1];
					PID[j + 1] = temp1;
// swap bTime[j+1] and bTime[i];
					int temp2 = bTime[j];
					bTime[j] = bTime[j + 1];
					bTime[j + 1] = temp2;
				}
	}
	
	public static void main(String[] args) {
		PriorityScheduling ob=new PriorityScheduling();
		Scanner input=new Scanner(System.in);
		
		int i, process;
		int PID[] = new int[10];
		int arrTime[] = new int[10];
		int bTime[] = new int[10];
		int compTime[] = new int[10];
		int TAT[] = new int[10];
		int waitTime[] = new int[10];
		int priority[]=new int[10];
		float averageTAT, totalTAT = 0.00f;
		float averageWT, totalWT = 0.00f;
		
		System.out.println("Enter the number of processes:");

		process = input.nextInt();
		System.out.println("Enter process IDs:");
		for (i = 0; i < process; i++) {
			PID[i] = input.nextInt();
		}
		System.out.println("Enter same arrival time for all processes(recommended to be 0):");
		for (i = 0; i < process; i++) {
			arrTime[i] = input.nextInt();
		}
		System.out.println("Enter priorities(They will be sorted in ascending order): ");
		for (i = 0; i < process; i++) {
			priority[i] = input.nextInt();
		}
		System.out.println("Enter burst time (distinct burst time for each process):");
		for (i = 0; i < process; i++) {
			bTime[i] = input.nextInt();
		}
//sorting of priority
		ob.PrioritySort(bTime, PID, priority, process);
		
		compTime[0] = arrTime[0] + bTime[0];
		for (i = 0; i < process; i++) {
			if (arrTime[i + 1] <= compTime[i])
				compTime[i + 1] = compTime[i] + bTime[i + 1];
			else
				compTime[i + 1] = arrTime[i + 1] + bTime[i + 1];
		}
		System.out.println("The completion time:");
		for (i = 0; i < process; i++) {
			System.out.println(compTime[i]);
		}

		System.out.println("Turn Around Time:");
		for (i = 0; i < process; i++) {
			TAT[i] = compTime[i] - arrTime[i];
		}
		for (i = 0; i < process; i++) {
			System.out.println(TAT[i]);
		}

		System.out.println("Waiting Time:");
		for (i = 0; i < process; i++) {
			waitTime[i] = TAT[i] - bTime[i];
		}
		for (i = 0; i < process; i++) {
			System.out.println(waitTime[i]);
		}
		System.out.println("PID  arrivalTime  burstTime  completionTime  TurnAroundTime  waitTime");
		for (i = 0; i < process; i++) {
			System.out.println(PID[i] + "\t" + arrTime[i] + "\t \t" + bTime[i] + "\t" + compTime[i] + "\t \t" + TAT[i]
					+ "\t \t" + waitTime[i]);
		}

		System.out.println("Average Waiting Time:");

		for (i = 0; i < process; i++) {
			totalWT = waitTime[i] + totalWT;

		}
		averageWT = totalWT / process;
		System.out.println(averageWT);
		System.out.println("Average Turn Around Time:");
		for (i = 0; i < process; i++) {
			totalTAT = TAT[i] + totalTAT;
		}
		averageTAT = totalTAT / process;
		System.out.println(averageTAT);
		input.close();

	}
}
