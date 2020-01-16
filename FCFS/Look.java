package com.sid.FCFS;

import java.util.Scanner;

public class Look {
	static int low = 0;
	static int high = 199;

	public static void main(String[] args) {
		int queue[] = new int[20];
		int queue1[] = new int[20];
		int queue2[] = new int[20];
		int head, q_size, i, j, seek = 0, diff, max, temp, temp1 = 0, temp2 = 0;
		float avg;
		Scanner input = new Scanner(System.in);
		System.out.println("Input the number of disk locations");
		q_size = input.nextInt();
		System.out.println("Enter initial head position");
		head = input.nextInt();
		System.out.println("Enter disk positions to read");
		for (i = 0; i < q_size; i++) {
			temp = input.nextInt();
			if (temp >= head) {
				queue1[temp1] = temp;
				temp1++;
			} else {
				queue2[temp2] = temp;
				temp2++;
			}
		}
		for (i = 0; i < temp1 - 1; i++) {
			for (j = i + 1; j < temp1; j++) {
				if (queue1[i] > queue1[j]) {
					temp = queue1[i];
					queue1[i] = queue1[j];
					queue1[j] = temp;
				}
			}
		}
		for (i = 0; i < temp2 - 1; i++) {
			for (j = i + 1; j < temp2; j++) {
				if (queue2[i] < queue2[j]) {
					temp = queue2[i];
					queue2[i] = queue2[j];
					queue2[j] = temp;
				}
			}
		}
		if (java.lang.Math.abs(head - low) >= java.lang.Math.abs(head - high)) {
			for (i = 1, j = 0; j < temp1; i++, j++) {
				queue[i] = queue1[j];
			}
			for (i = temp1 + 1, j = 0; j < temp2; i++, j++) {
				queue[i] = queue2[j];
			}
		} else {
			for (i = 1, j = 0; j < temp2; i++, j++) {
				queue[i] = queue2[j];
			}
			for (i = temp2 + 1, j = 0; j < temp1; i++, j++) {
				queue[i] = queue1[j];
			}
		}
		queue[0] = head;
		for (j = 0; j < q_size; j++) {
			diff = java.lang.Math.abs(queue[j + 1] - queue[j]);
			seek += diff;
			System.out.println("Disk head moves with seek " + diff);
		}
		System.out.println("Total seek time is " + seek);
		avg = seek / (float) q_size;
		System.out.println("Average seek time is " + avg);

	}
}
