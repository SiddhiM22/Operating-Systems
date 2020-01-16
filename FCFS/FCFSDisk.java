package com.sid.FCFS;
import java.util.Scanner;

public class FCFSDisk {

	public static void main(String[] args) {
		int max,n,head,diff,seek=0;
		int queue[]=new int[10];
		Scanner input=new Scanner(System.in);
		System.out.println("Enter maximum disk range:");
		max=input.nextInt();
		System.out.println("Enter queue size:");
		n=input.nextInt();
		System.out.println("Enter disk positions:");
		for (int i = 0; i < n; i++) {
			queue[i]=input.nextInt();
		}
		
		System.out.println("Enter initial head position:");
		head=input.nextInt();
		queue[0]=head;
		for (int i = 0; i <=n-1; i++) {
			diff=Math.abs(queue[i+1]-queue[i]);
			seek=seek+diff;
			System.out.println("Disk head movements from "+queue[i]+" to "+queue[i+1]+" position with seek time "+diff);
		}
		
		System.out.println("Total seek time: "+seek);
		input.close();
	}

}
