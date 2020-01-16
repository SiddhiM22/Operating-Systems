package com.sid.FCFS;


import java.util.Scanner;
public class SstfDisk {
public static void main(String[] args) {
int head,seek=0,i,c,j,temp,seek_time;
float avg;
            Scanner sc=new Scanner(System.in);
System.out.print("Enter the size of Queue : ");
            c=sc.nextInt();
System.out.print("Enter the seek time per cylinder : ");
seek_time=sc.nextInt();
int queue[]=new int[c];
int t[]=new int[c];
System.out.println("Enter the Queue");
for(i=0;i<c;i++)
             {
queue[i]=sc.nextInt();
             }
System.out.print("Enter the initial head position : ");
head=sc.nextInt();
for(i=1;i<c;i++)
t[i]=java.lang.Math.abs(head-queue[i]);
for(i=0;i<c;i++)
             {
for(j=i+1;j<c;j++)
                          {
if(t[i]>t[j])
                                       {
temp=t[i];
t[i]=t[j];
t[j]=temp;
temp=queue[i];
queue[i]=queue[j];
queue[j]=temp;
                                       }
                         }
             }
for(i=1;i<c;i++)
             {
seek=seek+java.lang.Math.abs(head-queue[i]);
head=queue[i];
             }
System.out.println("\nTotal Head movements are: "+seek);
System.out.println("\nTotal Seek Time is: "+seek * seek_time);
sc.close();

    }    
}


