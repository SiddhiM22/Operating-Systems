package com.sid.FCFS;

import java.util.Scanner;

public class RoundRobin {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number of Processes:");
		int n = sc.nextInt();
		int p[] = new int[n];
		int bt[] = new int[n];
		int ct[] = new int[n];
		int rembt[] = new int[n];
		int at[] = new int[n];
		int tat[] = new int[n];
		int wt[] = new int[n];
		double atat = 0, awt = 0;
		for (int i = 0; i < n; i++) {
			System.out.print("Enter Process id: ");
			p[i] = sc.nextInt();
			System.out.print("Enter Burst Time: ");
			bt[i] = sc.nextInt();
			rembt[i] = bt[i];
			at[i] = 0;
		}
		System.out.print("Enter time quantum: ");
		int tq = sc.nextInt();
		int c = 0;
		while (true) {
			boolean done = true;
			for (int i = 0; i < n; i++) {
				if (rembt[i] > 0) {
					done = false;
					if (rembt[i] > tq) {
						c = c + tq;
						rembt[i] = rembt[i] - tq;
					} else {
						c = c + rembt[i];
						rembt[i] = 0;
						ct[i] = c;
					}
				}
			}
			if (done == true)
				break;
		}
		System.out.println("PI\tBT\tCT\tTAT\tWT");
		for (int i = 0; i < n; i++) {
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt[i];
			System.out.println(p[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
		}
		for (int i = 0; i < n; i++) {
			atat = atat + tat[i];
			awt = awt + wt[i];
		}
		System.out.println("Average turn around time: " + (atat / n));
		System.out.println("Average waiting time: " + (awt / n));
		sc.close();
	}
}